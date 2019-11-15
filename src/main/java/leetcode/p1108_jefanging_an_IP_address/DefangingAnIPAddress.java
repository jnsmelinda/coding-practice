package leetcode.p1108_jefanging_an_IP_address;

public class DefangingAnIPAddress {
    /**
     * Given a valid (IPv4) IP address, return a defanged version of that IP address.
     * A defanged IP address replaces every period "." with "[.]".
     * Example 1:
     * Input: address = "1.1.1.1"
     * Output: "1[.]1[.]1[.]1"
     * Example 2:
     * Input: address = "255.100.50.0"
     * Output: "255[.]100[.]50[.]0"
     * Constraints:
     * The given address is a valid IPv4 address.
     */

    public static String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                result.append("[.]");
            }
            else{
                result.append(address.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }

}
