//package amino;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import junit.framework.Assert;
//
//public class IPtoNumberTest {
//    IPtoNumber ipToNumber;
//    String ip1 = "";
//    String ip2 = null;
//    String ip3 = "999.999.999.999";
//    String ip4 = "0.0.0.0";
//    String ip5 = "255.255.255.255";
//    String ip6 = "172.168.5.1";
//    String ip7 = "172 . 168.5.1";
//    String ip8 = "1 72.168.5.1";
//    String ip9 = " 172 .       168 . 5 . 1  ";
//    String ip10 = " 17 2.16 8. 5.1 ";
//
//    @Before
//    public void setUp() throws Exception {
//        ipToNumber = new IPtoNumber();
//    }
//
//    @Test
//    public void test() {
//        assertEquals(IPtoNumber.INVALID_INPUT, ipToNumber.ip2Number(ip1));
//        assertEquals(IPtoNumber.INVALID_INPUT, ipToNumber.ip2Number(ip2));
//        assertEquals(IPtoNumber.INVALID_INPUT, ipToNumber.ip2Number(ip3));
//        assertEquals(0l, ipToNumber.ip2Number(ip4));
//        assertEquals(4294967295l, ipToNumber.ip2Number(ip5));
//        assertEquals(2896692481l, ipToNumber.ip2Number(ip6));
//        assertEquals(2896692481l, ipToNumber.ip2Number(ip7));
//        assertEquals(IPtoNumber.INVALID_INPUT, ipToNumber.ip2Number(ip8));
//        assertEquals(2896692481l, ipToNumber.ip2Number(ip9));
//        assertEquals(IPtoNumber.INVALID_INPUT, ipToNumber.ip2Number(ip10));
//    }
//
//}
