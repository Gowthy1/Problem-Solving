/**
 * Given an integer array nums, return all the different possible
 * non-decreasing subsequences of the given array with at least two elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 *  Example 2:
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 *
 * Constraints:
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */

/**
 * Algorithm:
 * - Add current element
 *      - If the list is empty
 *      - If already element present in the list and that element should be greater than or equal to the last element in the list
 * - Remove current added element and move to the next element
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_491_NonDecreasingSubsequences {
    private static int N;
    private static void helper(int ind, int[] nums, ArrayList<Integer> aList, HashSet<List<Integer>> list){
        if(aList.size()>1) list.add(new ArrayList<>(aList));
        
        if(ind == N) return;

        if(aList.isEmpty() || nums[ind] >= aList.get(aList.size()-1) ){
            aList.add(nums[ind]);             // Adding current element to the list
            helper(ind+1, nums, aList, list);
            aList.remove(aList.size()-1);     // Removing the added element to the list
        }
        helper(ind+1, nums, aList, list);     // Skipping current element
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        N = nums.length;
        if(N==1) return new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        helper(0, nums, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums)); // Expected output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
    }
}

