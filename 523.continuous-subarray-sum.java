/*
 * [523] Continuous Subarray Sum
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * algorithms
 * Medium (23.34%)
 * Total Accepted:    32.5K
 * Total Submissions: 139.2K
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 * 
 * Given a list of non-negative numbers and a target integer k, write a
 * function to check if the array has a continuous subarray of size at least 2
 * that sums up to the multiple of k, that is, sums up to n*k where n is also
 * an integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up
 * to 6.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5
 * and sums up to 42.
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit
 * integer.
 * 
 * 
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
        	return false;
        }
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++) {
        	sum[i] = sum[i - 1] + nums[i];
        }
        
        for(int i = 0; i < n - 1; i++) {
        	for(int j = i + 1; j < n; j++) {
        		int subsum = sum[j] - sum[i] + nums[i];
        		if(subsum == k || (k != 0 && subsum % k == 0)) {
        			return true;
        		}
        	}
        }
        return false;
    }
}
