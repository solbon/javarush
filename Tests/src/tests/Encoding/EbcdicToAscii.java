package tests.Encoding;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.*;

/**
 * various functions needed to pack/unpack ISO-8583 fields
 *
 * @author apr@jpos.org
 * @author Hani S. Kirollos
 * @author Alwyn Schoeman
 * @version $Id$
 */
public class EbcdicToAscii {

    /**
     * All methods in this class are static, so there's usually no need to instantiate it
     * We provide this public constructor in order to deal with some legacy script integration
     * that needs an instance of this class in a rendering context.
     */
    public EbcdicToAscii() {
        super();
    }
    public static final String[] hexStrings;

    static {
        hexStrings = new String[256];
        for (int i = 0; i < 256; i++ ) {
            StringBuilder d = new StringBuilder(2);
            char ch = Character.forDigit((byte)i >> 4 & 0x0F, 16);
            d.append(Character.toUpperCase(ch));
            ch = Character.forDigit((byte)i & 0x0F, 16);
            d.append(Character.toUpperCase(ch));
            hexStrings[i] = d.toString();
        }

    }

    /**
     * Default encoding (charset) for bytes transmissions over network
     * @deprecated use {@link #CHARSET} instead
     */
    public static final String ENCODING  = "ISO8859_1";

    /**
     * Default charset for bytes transmissions over network
     */
    public static final Charset CHARSET  = Charset.forName("ISO8859_1");
    public static final Charset EBCDIC_CHARSET = Charset.forName("IBM-1047");

    public static final byte[] EBCDIC2ASCII = new byte[] {
            (byte)0x0,  (byte)0x1,  (byte)0x2,  (byte)0x3,
            (byte)0x9C, (byte)0x9,  (byte)0x86, (byte)0x7F,
            (byte)0x97, (byte)0x8D, (byte)0x8E, (byte)0xB,
            (byte)0xC,  (byte)0xD,  (byte)0xE,  (byte)0xF,
            (byte)0x10, (byte)0x11, (byte)0x12, (byte)0x13,
            (byte)0x9D, (byte)0xA,  (byte)0x8,  (byte)0x87,
            (byte)0x18, (byte)0x19, (byte)0x92, (byte)0x8F,
            (byte)0x1C, (byte)0x1D, (byte)0x1E, (byte)0x1F,
            (byte)0x80, (byte)0x81, (byte)0x82, (byte)0x83,
            (byte)0x84, (byte)0x85, (byte)0x17, (byte)0x1B,
            (byte)0x88, (byte)0x89, (byte)0x8A, (byte)0x8B,
            (byte)0x8C, (byte)0x5,  (byte)0x6,  (byte)0x7,
            (byte)0x90, (byte)0x91, (byte)0x16, (byte)0x93,
            (byte)0x94, (byte)0x95, (byte)0x96, (byte)0x4,
            (byte)0x98, (byte)0x99, (byte)0x9A, (byte)0x9B,
            (byte)0x14, (byte)0x15, (byte)0x9E, (byte)0x1A,
            (byte)0x20, (byte)0xA0, (byte)0xE2, (byte)0xE4,
            (byte)0xE0, (byte)0xE1, (byte)0xE3, (byte)0xE5,
            (byte)0xE7, (byte)0xF1, (byte)0xA2, (byte)0x2E,
            (byte)0x3C, (byte)0x28, (byte)0x2B, (byte)0x7C,
            (byte)0x26, (byte)0xE9, (byte)0xEA, (byte)0xEB,
            (byte)0xE8, (byte)0xED, (byte)0xEE, (byte)0xEF,
            (byte)0xEC, (byte)0xDF, (byte)0x21, (byte)0x24,
            (byte)0x2A, (byte)0x29, (byte)0x3B, (byte)0x5E,
            (byte)0x2D, (byte)0x2F, (byte)0xC2, (byte)0xC4,
            (byte)0xC0, (byte)0xC1, (byte)0xC3, (byte)0xC5,
            (byte)0xC7, (byte)0xD1, (byte)0xA6, (byte)0x2C,
            (byte)0x25, (byte)0x5F, (byte)0x3E, (byte)0x3F,
            (byte)0xF8, (byte)0xC9, (byte)0xCA, (byte)0xCB,
            (byte)0xC8, (byte)0xCD, (byte)0xCE, (byte)0xCF,
            (byte)0xCC, (byte)0x60, (byte)0x3A, (byte)0x23,
            (byte)0x40, (byte)0x27, (byte)0x3D, (byte)0x22,
            (byte)0xD8, (byte)0x61, (byte)0x62, (byte)0x63,
            (byte)0x64, (byte)0x65, (byte)0x66, (byte)0x67,
            (byte)0x68, (byte)0x69, (byte)0xAB, (byte)0xBB,
            (byte)0xF0, (byte)0xFD, (byte)0xFE, (byte)0xB1,
            (byte)0xB0, (byte)0x6A, (byte)0x6B, (byte)0x6C,
            (byte)0x6D, (byte)0x6E, (byte)0x6F, (byte)0x70,
            (byte)0x71, (byte)0x72, (byte)0xAA, (byte)0xBA,
            (byte)0xE6, (byte)0xB8, (byte)0xC6, (byte)0xA4,
            (byte)0xB5, (byte)0x7E, (byte)0x73, (byte)0x74,
            (byte)0x75, (byte)0x76, (byte)0x77, (byte)0x78,
            (byte)0x79, (byte)0x7A, (byte)0xA1, (byte)0xBF,
            (byte)0xD0, (byte)0x5B, (byte)0xDE, (byte)0xAE,
            (byte)0xAC, (byte)0xA3, (byte)0xA5, (byte)0xB7,
            (byte)0xA9, (byte)0xA7, (byte)0xB6, (byte)0xBC,
            (byte)0xBD, (byte)0xBE, (byte)0xDD, (byte)0xA8,
            (byte)0xAF, (byte)0x5D, (byte)0xB4, (byte)0xD7,
            (byte)0x7B, (byte)0x41, (byte)0x42, (byte)0x43,
            (byte)0x44, (byte)0x45, (byte)0x46, (byte)0x47,
            (byte)0x48, (byte)0x49, (byte)0xAD, (byte)0xF4,
            (byte)0xF6, (byte)0xF2, (byte)0xF3, (byte)0xF5,
            (byte)0x7D, (byte)0x4A, (byte)0x4B, (byte)0x4C,
            (byte)0x4D, (byte)0x4E, (byte)0x4F, (byte)0x50,
            (byte)0x51, (byte)0x52, (byte)0xB9, (byte)0xFB,
            (byte)0xFC, (byte)0xF9, (byte)0xFA, (byte)0xFF,
            (byte)0x5C, (byte)0xF7, (byte)0x53, (byte)0x54,
            (byte)0x55, (byte)0x56, (byte)0x57, (byte)0x58,
            (byte)0x59, (byte)0x5A, (byte)0xB2, (byte)0xD4,
            (byte)0xD6, (byte)0xD2, (byte)0xD3, (byte)0xD5,
            (byte)0x30, (byte)0x31, (byte)0x32, (byte)0x33,
            (byte)0x34, (byte)0x35, (byte)0x36, (byte)0x37,
            (byte)0x38, (byte)0x39, (byte)0xB3, (byte)0xDB,
            (byte)0xDC, (byte)0xD9, (byte)0xDA, (byte)0x9F
    };
    public static final byte[] ASCII2EBCDIC = new byte[] {
            (byte)0x0,  (byte)0x1,  (byte)0x2,  (byte)0x3,
            (byte)0x37, (byte)0x2D, (byte)0x2E, (byte)0x2F,
            (byte)0x16, (byte)0x5,  (byte)0x15, (byte)0xB,
            (byte)0xC,  (byte)0xD,  (byte)0xE,  (byte)0xF,
            (byte)0x10, (byte)0x11, (byte)0x12, (byte)0x13,
            (byte)0x3C, (byte)0x3D, (byte)0x32, (byte)0x26,
            (byte)0x18, (byte)0x19, (byte)0x3F, (byte)0x27,
            (byte)0x1C, (byte)0x1D, (byte)0x1E, (byte)0x1F,
            (byte)0x40, (byte)0x5A, (byte)0x7F, (byte)0x7B,
            (byte)0x5B, (byte)0x6C, (byte)0x50, (byte)0x7D,
            (byte)0x4D, (byte)0x5D, (byte)0x5C, (byte)0x4E,
            (byte)0x6B, (byte)0x60, (byte)0x4B, (byte)0x61,
            (byte)0xF0, (byte)0xF1, (byte)0xF2, (byte)0xF3,
            (byte)0xF4, (byte)0xF5, (byte)0xF6, (byte)0xF7,
            (byte)0xF8, (byte)0xF9, (byte)0x7A, (byte)0x5E,
            (byte)0x4C, (byte)0x7E, (byte)0x6E, (byte)0x6F,
            (byte)0x7C, (byte)0xC1, (byte)0xC2, (byte)0xC3,
            (byte)0xC4, (byte)0xC5, (byte)0xC6, (byte)0xC7,
            (byte)0xC8, (byte)0xC9, (byte)0xD1, (byte)0xD2,
            (byte)0xD3, (byte)0xD4, (byte)0xD5, (byte)0xD6,
            (byte)0xD7, (byte)0xD8, (byte)0xD9, (byte)0xE2,
            (byte)0xE3, (byte)0xE4, (byte)0xE5, (byte)0xE6,
            (byte)0xE7, (byte)0xE8, (byte)0xE9, (byte)0xAD,
            (byte)0xE0, (byte)0xBD, (byte)0x5F, (byte)0x6D,
            (byte)0x79, (byte)0x81, (byte)0x82, (byte)0x83,
            (byte)0x84, (byte)0x85, (byte)0x86, (byte)0x87,
            (byte)0x88, (byte)0x89, (byte)0x91, (byte)0x92,
            (byte)0x93, (byte)0x94, (byte)0x95, (byte)0x96,
            (byte)0x97, (byte)0x98, (byte)0x99, (byte)0xA2,
            (byte)0xA3, (byte)0xA4, (byte)0xA5, (byte)0xA6,
            (byte)0xA7, (byte)0xA8, (byte)0xA9, (byte)0xC0,
            (byte)0x4F, (byte)0xD0, (byte)0xA1, (byte)0x7,
            (byte)0x20, (byte)0x21, (byte)0x22, (byte)0x23,
            (byte)0x24, (byte)0x25, (byte)0x6,  (byte)0x17,
            (byte)0x28, (byte)0x29, (byte)0x2A, (byte)0x2B,
            (byte)0x2C, (byte)0x9,  (byte)0xA,  (byte)0x1B,
            (byte)0x30, (byte)0x31, (byte)0x1A, (byte)0x33,
            (byte)0x34, (byte)0x35, (byte)0x36, (byte)0x8,
            (byte)0x38, (byte)0x39, (byte)0x3A, (byte)0x3B,
            (byte)0x4,  (byte)0x14, (byte)0x3E, (byte)0xFF,
            (byte)0x41, (byte)0xAA, (byte)0x4A, (byte)0xB1,
            (byte)0x9F, (byte)0xB2, (byte)0x6A, (byte)0xB5,
            (byte)0xBB, (byte)0xB4, (byte)0x9A, (byte)0x8A,
            (byte)0xB0, (byte)0xCA, (byte)0xAF, (byte)0xBC,
            (byte)0x90, (byte)0x8F, (byte)0xEA, (byte)0xFA,
            (byte)0xBE, (byte)0xA0, (byte)0xB6, (byte)0xB3,
            (byte)0x9D, (byte)0xDA, (byte)0x9B, (byte)0x8B,
            (byte)0xB7, (byte)0xB8, (byte)0xB9, (byte)0xAB,
            (byte)0x64, (byte)0x65, (byte)0x62, (byte)0x66,
            (byte)0x63, (byte)0x67, (byte)0x9E, (byte)0x68,
            (byte)0x74, (byte)0x71, (byte)0x72, (byte)0x73,
            (byte)0x78, (byte)0x75, (byte)0x76, (byte)0x77,
            (byte)0xAC, (byte)0x69, (byte)0xED, (byte)0xEE,
            (byte)0xEB, (byte)0xEF, (byte)0xEC, (byte)0xBF,
            (byte)0x80, (byte)0xFD, (byte)0xFE, (byte)0xFB,
            (byte)0xFC, (byte)0xBA, (byte)0xAE, (byte)0x59,
            (byte)0x44, (byte)0x45, (byte)0x42, (byte)0x46,
            (byte)0x43, (byte)0x47, (byte)0x9C, (byte)0x48,
            (byte)0x54, (byte)0x51, (byte)0x52, (byte)0x53,
            (byte)0x58, (byte)0x55, (byte)0x56, (byte)0x57,
            (byte)0x8C, (byte)0x49, (byte)0xCD, (byte)0xCE,
            (byte)0xCB, (byte)0xCF, (byte)0xCC, (byte)0xE1,
            (byte)0x70, (byte)0xDD, (byte)0xDE, (byte)0xDB,
            (byte)0xDC, (byte)0x8D, (byte)0x8E, (byte)0xDF
    };
    public static final byte STX = 0x02;
    public static final byte FS  = 0x1C;
    public static final byte US  = 0x1F;
    public static final byte RS  = 0x1D;
    public static final byte GS  = 0x1E;
    public static final byte ETX = 0x03;

    public static String ebcdicToAscii(byte[] e) {
        return new String (
                ebcdicToAsciiBytes (e, 0, e.length), CHARSET
        );
    }
    public static String ebcdicToAscii(byte[] e, int offset, int len) {
        return new String (
                ebcdicToAsciiBytes (e, offset, len), CHARSET
        );
    }
    public static byte[] ebcdicToAsciiBytes (byte[] e) {
        return ebcdicToAsciiBytes (e, 0, e.length);
    }
    public static byte[] ebcdicToAsciiBytes(byte[] e, int offset, int len) {
        byte[] a = new byte[len];
        for (int i=0; i<len; i++)
            a[i] = EBCDIC2ASCII[e[offset+i]&0xFF];
        return a;
    }
    public static byte[] asciiToEbcdic(String s) {
        int len = s.length();
        byte b[] = new byte[len];
        for (int i = 0; i < len; i++)
            b[i] = ASCII2EBCDIC[s.charAt(i) & 0xFF];
        return b;
    }

    public static byte[] asciiToEbcdic2(String s) {
        return asciiToEbcdic (s.getBytes(CHARSET));
    }

    public static byte[] asciiToEbcdic3(String s) {
        return asciiToEbcdic (s.getBytes());
    }

    public static byte[] asciiToEbcdic(byte[] a) {
        byte[] e = new byte[a.length];
        for (int i=0; i<a.length; i++)
            e[i] = ASCII2EBCDIC[a[i]&0xFF];
        return e;
    }
    public static void asciiToEbcdic(String s, byte[] e, int offset) {
        int len = s.length();
        for (int i=0; i<len; i++)
            e[offset + i] = ASCII2EBCDIC[s.charAt(i)&0xFF];
    }
    public static void asciiToEbcdic(byte[] s, byte[] e, int offset) {
        int len = s.length;
        for (int i=0; i<len; i++)
            e[offset + i] = ASCII2EBCDIC[s[i]];
    }

    /**
     * Converts a byte array into a hex string
     * @param bs source byte array
     * @return
     */
    public static final String byte2hex(byte[] bs) {
        return byte2hex(bs, 0, bs.length);
    }

    /**
     * Converts a byte array into a string of lower case hex chars.
     *
     * @param bs     A byte array
     * @param off    The index of the first byte to read
     * @param length The number of bytes to read.
     * @return the string of hex chars.
     */
    public static final String byte2hex(byte[] bs, int off, int length) {
        if (bs.length <= off || bs.length < off + length)
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length * 2);
        byte2hexAppend(bs, off, length, sb);
        return sb.toString();
    }

    private static final void byte2hexAppend(byte[] bs, int off, int length, StringBuilder sb) {
        if (bs.length <= off || bs.length < off + length)
            throw new IllegalArgumentException();
        sb.ensureCapacity(sb.length() + length * 2);
        for (int i = off; i < off + length; i++) {
            sb.append(Character.forDigit((bs[i] >>> 4) & 0xf, 16));
            sb.append(Character.forDigit(bs[i] & 0xf, 16));
        }
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) {
        String str = "Hello World";
        if (Arrays.equals(asciiToEbcdic(str), asciiToEbcdic2(str))) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
            System.out.println("asciiToEbcdic:");
            System.out.println(Arrays.toString(asciiToEbcdic(str)));
            System.out.println("asciiToEbcdic2:");
            System.out.println(Arrays.toString(asciiToEbcdic2(str)));
            System.out.println("asciiToEbcdic3:");
            System.out.println(Arrays.toString(asciiToEbcdic3(str)));
        }

        for (int c=1; c<256; c++) {
            String s = String.valueOf((char) c);
            String s2 = (Arrays.equals(asciiToEbcdic(s), asciiToEbcdic2(s))) ? "" : "false";
            System.out.println(c + "\t" + (char)c + "\t" + bytesToHex(asciiToEbcdic(s)) + "\t"
                    + bytesToHex(asciiToEbcdic2(s)) + "\t" + s2);
        }
        int count = 0;
        for (int c = 0; c < 256; c++) {
            String s = String.valueOf((char) c);
//            System.out.print(byte2hex(asciiToEbcdic2(s)) + " ");
            System.out.print(byte2hex(s.getBytes(EBCDIC_CHARSET)) + " ");
            count++;
            if (count == 4) {
                System.out.println("\t#" + (c + 1));
                count = 0;
            }
        }
    }
}

