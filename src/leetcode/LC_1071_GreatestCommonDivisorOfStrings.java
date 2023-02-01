package LeetCode;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Constraints:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class LC_1071_GreatestCommonDivisorOfStrings {
    private int len1, len2;
    private boolean isValid(String str1, String str2, int k){
        if(len1%k>0 || len2%k>0)
            return false;
        String base = str1.substring(0,k);
        return str1.replace(base, "").isEmpty()
                && str2.replace(base,"").isEmpty();
    }

    // Time complexity: O(min(m,n)⋅(m+n))
    // Space complexity:O(min(m,n))
    public String gcdOfStrings(String str1, String str2) {
        len1 = str1.length();
        len2 = str2.length();
        if(len1%len2 ==0 || len2%len1 ==0) {
            for (int i = Math.min(len1, len2); i >= 1; i--) {
                if (isValid(str1, str2, i)) {
                    return str1.substring(0, i);
                }
            }
        }
        return "";
    }

    private int gcd(int x, int y){
        if(y==0)
            return x;
        else
            return gcd(y, x%y);
    }

    // Time complexity: O(m+n) + O(log(m.n))
    // Space complexity: O(m+n)
    public String gcdOfStringsUsingGCD(String str1, String str2) {
        len1 = str1.length();
        len2 = str2.length();
        if((str1 + str2).equals(str2 + str1)) {
            int len = gcd(len1, len2);
            return str1.substring(0,len);
        }
        return "";
    }

    public static void main(String[] args) {
        LC_1071_GreatestCommonDivisorOfStrings ob = new LC_1071_GreatestCommonDivisorOfStrings();
        System.out.println(ob.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(ob.gcdOfStrings("ABABAB", "AB"));
        System.out.println(ob.gcdOfStrings("ABCABD", "ABC"));
        System.out.println(ob.gcdOfStrings("AAAAA",  "AA"));
        
        System.out.println(ob.gcdOfStringsUsingGCD("ABCABC", "ABC"));
        System.out.println(ob.gcdOfStringsUsingGCD("ABABAB", "AB"));
        System.out.println(ob.gcdOfStringsUsingGCD("ABCABD", "ABC"));
        System.out.println(ob.gcdOfStringsUsingGCD("AAAAA",  "AA"));
    }
}
