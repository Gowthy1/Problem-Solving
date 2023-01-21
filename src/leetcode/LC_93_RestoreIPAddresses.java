/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 * 
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * 
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * Constraints:
 * 1 <= s.length <= 20
 * s consists of digits only.
 */

/**
 * Used backtracking to solve this
 */

TODO: Write cleam and moduler code

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_93_RestoreIPAddresses {
    private int N;

    private boolean isValidZero(String s){
        if(s.length()==2 && Integer.parseInt(s) < 10)
            return false;
        else if(s.length()==3 && Integer.parseInt(s)<100)
            return false;
        else if(s.length()>3)
            return false;
        return true;
    }
  
    private void dfs(int start, int end, int count, String s, String curr, ArrayList<String> res) {
        if(end == s.length()){
            int val = Integer.parseInt(s.substring(start, end));
            if(count == 3
            && isValidZero(s.substring(start, end))
            && val >=0 && val <=255 ) {
                curr = curr+s.substring(start,end);
                res.add(curr);
            }
            return;
        }
        if( end <=s.length() && count < 3
            && (end - start <= 3)
            && isValidZero(s.substring(start, end))
            && Integer.parseInt(s.substring(start, end)) <= 255
            && Integer.parseInt(s.substring(start, end)) >= 0 ) {

            curr = curr + s.substring(start, end)+".";
            for(int ind =1;ind<=3; ind++) {
                dfs(end, end+ind, count+1, s, curr, res);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        N = s.length();
        ArrayList<String> res =  new ArrayList<>();
        if( N < 4 || N >12)
            return res;
        for(int i=1; i<=3; i++) {
            dfs(0, i, 0, s, "", res);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_93_RestoreIPAddresses ob = new LC_93_RestoreIPAddresses();
        System.out.println(ob.restoreIpAddresses("25525511135")); // Output: ["255.255.11.135","255.255.111.35"]
        System.out.println(ob.restoreIpAddresses("101023"));      // Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        System.out.println(ob.restoreIpAddresses("0000"));        // Output: [0.0.0.0]
        System.out.println(ob.restoreIpAddresses("12345"));       // Output: [1.2.3.45, 1.2.34.5, 1.23.4.5, 12.3.4.5]
    }
}
