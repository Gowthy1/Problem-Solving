package leetcode;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class LC_540_SingleElementInASortedArray {

    // Clean and simple conditions

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (l == r) return nums[l];
        while (l < r) {
            int mid = (l + r) >> 1; // Divided by 2

            // XOR - If number is odd, then XOR of 1 subracts number by 1
            //     - If number is even, then XOR of 1 adds nnumber by 1
            //
            // Example: mid = odd
            // => mid=3 =  0011 (XOR)
            //             0001
            //            -------
            //          => 0010 (i.e., subracts by one)

            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
    
    // Long conditions solutions

    public int singleNonDuplicate1(int[] nums) {
        int l =0;
        int r= nums.length-1;
        if(l==r) return nums[l];
        while(l<=r){
            int mid = l + (r-l)/2;

            if((mid==0 && nums[mid]!= nums[mid+1])
                    || (mid==nums.length-1 && nums[mid] != nums[mid-1])
                    || ( nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])) {
                return nums[mid];
            }

            if(mid%2 == 0){
                if(nums[mid] == nums[mid+1]) {
                    l = mid + 2;
                } else if(nums[mid]==nums[mid-1]){
                    r = mid-2;
                }
            }else{
                if( nums[mid] == nums[mid-1]){
                    l = mid+1;
                }else if(nums[mid] == nums[mid+1]){
                    r = mid-1;
                }
            }
        }
        return nums[l];
    }
}
