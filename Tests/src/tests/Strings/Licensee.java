package tests.Strings;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.jpos.q2.Q2;
import org.jpos.util.PGPHelper;

/**
 * Created by sdaribazaron on 2016-04-07.
 */
public class Licensee {
    public static final String LICENSEE = "C:\\tmp\\LICENSEE-CRLF.asc";
    public static final String PUBRING = "C:\\tmp\\pubring.asc";
    private static final String SIGNER = "license@jpos.org";
    private static final String LIC_COPY = "C:\\tmp\\LIC_COPY-CRLF.asc";

    public static String getLicensee() throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(LICENSEE));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (is != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintStream p = new PrintStream(baos);
            p.println();
            p.println();
            try {
                while (br.ready())
                    p.println(br.readLine());
            } catch (Exception ignored) {
                // NOPMD ignore error
            }
        }
        return baos.toString();
    }

    public static int checkLicense() {
        int rc = 0x80000;
        System.out.println("int rc = 0x80000: " + rc);
        boolean newl = false;
        int ch;

        try {
            InputStream in = new FileInputStream(new File(LICENSEE));
            InputStream ks = new FileInputStream(new File(PUBRING));
            PGPPublicKey pk = PGPHelper.readPublicKey(ks, SIGNER);
            ArmoredInputStream ain = new ArmoredInputStream(in, true);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ain));
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(pk.getFingerprint(), "HmacSHA256"));

            while ((ch = ain.read()) >= 0 && ain.isClearText()) {
                if (newl) {
                    out.write((byte) '\n');
                    newl = false;
                }
                if (ch == '\r' || ch == '\n') {
                    newl = true;
                    continue;
                }
                out.write((byte) ch);
            }
            String line;
//            while ((line = br.readLine()) != null) {
//                out.write(line.getBytes(Charset.forName("UTF-8")));
//                out.write('\n');
//            }

//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            if (ain != null) {
//                br = new BufferedReader(new InputStreamReader(ain));
//                PrintStream p = new PrintStream(baos);
//                p.println();
//                p.println();
//                try {
//                    while (br.ready() && ain.isClearText())
//                        p.println(br.readLine());
//                } catch (Exception ignored) {
//                    // NOPMD ignore error
//                }
//            }
            PGPObjectFactory pgpf = new PGPObjectFactory(ain, new BcKeyFingerprintCalculator());
            Object o = pgpf.nextObject();
            if (o instanceof PGPSignatureList) {
                PGPSignatureList list = (PGPSignatureList) o;
                if (list.size() > 0) {
                    PGPSignature sig = list.get(0);
                    sig.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), pk);
                    while ((ch = ain.read()) >= 0 && ain.isClearText()) {
                        if (newl) {
                            out.write((byte) '\n');
                            newl = false;
                        }
                        if ( ch == '\n') {
                            newl = true;
                            continue;
                        }
                        out.write((byte) ch);
                    }
//                    while ((line = br.readLine()) != null) {
//                        out.write(line.getBytes());
//                        out.write('\n');
//                    }
                    sig.update(out.toByteArray());
                    if (sig.verify()) {
                        rc &= 0x7FFFF;
                        System.out.println("sig.verify(): " + rc);
                        ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
                        String s;
                        Pattern p1 = Pattern.compile("\\s(valid through:)\\s(\\d\\d\\d\\d-\\d\\d-\\d\\d)?", Pattern.CASE_INSENSITIVE);
                        Pattern p2 = Pattern.compile("\\s(instances:)\\s([\\d]{0,4})?", Pattern.CASE_INSENSITIVE);
                        while ((s = reader.readLine()) != null) {
                            Matcher matcher = p1.matcher(s);
                            if (matcher.find() && matcher.groupCount() == 2) {
                                String lDate = matcher.group(2);
                                if (lDate.compareTo(Q2.getBuildTimestamp().substring(0, 10)) < 0) {
                                    rc |= 0x40000;
                                    System.out.println("rc |= 0x40000: " + rc);
                                }
                            }
                            matcher = p2.matcher(s);
                            if (matcher.find() && matcher.groupCount() == 2) {
                                rc |= Integer.parseInt(matcher.group(2));
                                System.out.println("rc |= Integer.parseInt(matcher.group(2)): " + rc);
                            }
                        }
                    }
                }
                if (!Arrays.equals(Q2.PUBKEYHASH, mac.doFinal(pk.getEncoded()))) {
                    rc |= 0x20000;
                    System.out.println("rc |= 0x20000: " + rc);
                }

            }
        } catch (Exception ignored) {
            // NOPMD: signature isn't good
        }
        return rc;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int l = checkLicense();
        System.err.println(l + " " + (l & 0xE0000));
        if ((l & 0xE0000) > 0) {
            throw new IllegalAccessError();
        }
        PrintWriter writer = new PrintWriter(new File(LIC_COPY));
        writer.print(getLicensee());
        writer.close();
    }
}
