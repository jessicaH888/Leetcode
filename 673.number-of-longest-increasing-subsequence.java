/*
 * [673] Number of Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (31.64%)
 * Total Accepted:    14.3K
 * Total Submissions: 45.3K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * 
 * Given an unsorted array of integers, find the number of longest increasing
 * subsequence.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1,
 * 3, 5, 7].
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 * 
 * 
 * 
 * Note:
 * Length of the given array will be not exceed 2000 and the answer is
 * guaranteed to be fit in 32-bit signed int.
 * 
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        
        int max = 0;
        for(int i = 0; i < n; i++) {
        	length[i] = 1;
        	count[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(nums[j] < nums[i]) {
        			if(length[j] >= length[i]) {
        				length[i] = length[j] + 1;
        				count[i] = count[j];
        			}else if(length[j] + 1 == length[i]) {
        				count[i] += count[j];
        			}

        		}
        	}
        	max = Math.max(max, length[i]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
        	if(length[i] == max) {
        		ans += count[i];
        	}
        }
        return ans;
    }
}
