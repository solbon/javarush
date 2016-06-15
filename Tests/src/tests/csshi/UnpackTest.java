package tests.csshi;

import java.util.List;
import java.util.Set;
import org.jpos.iso.ISOComponent;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOFieldPackager;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.LogEvent;

/**
 * Created by sdaribazaron on 2016-04-28.
 */
public class UnpackTest {


    private static final String COMPL_PARTIALLY_RCODE = "4004";

    /**
     * Cardholder Authentication Method - PIN verified on-line or off-line
     */
    private static final char CHAUTH_METH_PIN           = '1';

    /**
     * Path to xml file containg definiction of CSSHI packager.
     */
    private static final String  CSSHI_PACKAGER_PATH     = "jar:cfg/packager/iso93csshi.xml";

    /**
     * Packager of ISO8583v93 CSSHI format.
     */
    private static ISOPackager CSSHI_PACKAGER;

    /**
     * Pack subfields in data element.
     *
     * <p>
     * CSSHI packager is used.
     *
     * @param msg ISOMessage containing data element to pack
     * @param field number of data element to pack
     * @param subfields subfields of data element to pack
     * @param evt log event
     * @return packed bytes
     */
    public static byte[] packDE(ISOMsg msg, int field, List<Integer> subfields, LogEvent evt) {
        if (CSSHI_PACKAGER == null)
            try {
                CSSHI_PACKAGER = new GenericPackager(CSSHI_PACKAGER_PATH);
            } catch (ISOException ex) {
                if (evt != null)
                    evt.addMessage("warn", "Cannot create CSSHI packager. " + ex.getMessage());
                return null;
            }

        ISOFieldPackager fp = ((GenericPackager)CSSHI_PACKAGER).getFieldPackager(field);
        if (fp == null)
            return null;

        if (subfields == null || subfields.isEmpty())
            return null;

        ISOComponent c = msg.getComponent(field);
        if (!(c instanceof ISOMsg))
            return null;

        ISOMsg f = (ISOMsg)((ISOMsg)c).clone();

        Set<Integer> rm = f.getChildren().keySet();
        rm.removeAll(subfields);

        for (Integer r : rm)
            f.unset(r);

        try {
            return fp.pack(f);
        } catch (ISOException ex) {
            if (evt != null)
                evt.addMessage("warn", String.format("Cannot pack data element %d. %s"
                        ,field, ex.getMessage()));
            return null;
        }
    }

    public static void main(String[] args) throws ISOException {
        CSSHI_PACKAGER = new GenericPackager(CSSHI_PACKAGER_PATH);
//        ISOFieldPackager fp = ((GenericPackager)CSSHI_PACKAGER).getFieldPackager(123);
        ISOMsg msg = new ISOMsg("1200");
        msg.setPackager(CSSHI_PACKAGER);
        msg.set(2, "56675487664343337");
        msg.set(4, "000000014999");
        msg.set(7, "0428153144");
        msg.set(49, "985");

//        ISOMsg f123 = new ISOMsg(123);
//        msg.set(f123);
//        f123.set("10.1", "a");
//        f123.set("10.2", "1234");

        msg.set("123.8", "Kot");
        msg.set("123.10.1", "a");
        msg.set("123.10.2", "1234");

        byte[] bytes = msg.pack();
        System.out.println(new String(bytes, ISOUtil.CHARSET));
        System.out.println();
        System.out.println(ISOUtil.hexString(bytes));
        System.out.println();
        System.out.println(ISOUtil.hexdump(bytes));

        bytes = ISOUtil.hex2byte("31323030D2000000000080000000000000000020313735363637353438373636343334333333373030303030303031343939393034323831353331343439383530353430383030334B6F74313030343161313233342020202020202020202020202020202020202020202020202020");
        ISOMsg m2 = new ISOMsg();
        m2.setPackager(CSSHI_PACKAGER);

        m2.unpack(bytes);
        m2.dump(System.out, ">>>");

//        ISOMsg msg2 = new ISOMsg(123);
//        byte [] bytes2 = "01704004abcd03003123".getBytes();
//        int length = fp.unpack(msg2, bytes, 0);
//        System.out.println(length);
//
//        msg2.dump(System.out, "");

    }
}
