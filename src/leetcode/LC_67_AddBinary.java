package leetcode;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class LC_67_AddBinary {
    public String addBinaryUsingBuiltInFunctions(String a, String b) {
        return Integer.toString( Integer.parseInt(a,2) + Integer.parseInt(b,2), 2);
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length();
        int j = b.length();
        int carry =0;
        while(i >=0 || j >=0){
            int sum = carry;
            if(--i >=0) sum += a.charAt(i)-'0';
            if(--j >=0) sum += b.charAt(j)-'0';
            res.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LC_67_AddBinary ob = new LC_67_AddBinary();
        // TestCase 1
        System.out.println(ob.addBinary("1010", "1011"));
        // TestCase 2
        System.out.println(ob.addBinary("11", "1"));
        // TestCase 3
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(ob.addBinary(a,b));
    }
}
