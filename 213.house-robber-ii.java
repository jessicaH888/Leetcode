/*
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (34.60%)
 * Total Accepted:    74.3K
 * Total Submissions: 214.7K
 * Testcase Example:  '[]'
 *
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This
 * time, all houses at this place are arranged in a circle. That means the
 * first house is the neighbor of the last one. Meanwhile, the security system
 * for these houses remain the same as for those in the previous street. 
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        if(nums.length == 1) {
        	return nums[0];
        }
        if(nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(0, nums.length - 2, nums), helper(1, nums.length - 1, nums));
    }

    private int helper(int start, int end, int[] nums) {
    	//dp[i] means the max value at index i
    	int[] dp = new int[nums.length];
    	if(start == end) {
    		return nums[end];
    	}
    	if(start + 1 == end) {
    		return Math.max(nums[start], nums[end]);
    	}
    	dp[start] = nums[start];
    	dp[start + 1] = Math.max(nums[start], nums[start + 1]);
    	for(int i = start + 2; i <= end; i++) {
    		dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    	}
    	return dp[end];
    }
}
