/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (24.37%)
 * Total Accepted:    389.3K
 * Total Submissions: 1.6M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123
 * Output:  321
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only hold integers
 * within the 32-bit signed integer range. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0) {
        	int tmp = ans * 10 + x % 10;
        	x = x / 10;
        	if(tmp / 10 != ans) {
        		ans = 0;
        		break;
        	}
        	ans = tmp;
        }
        return ans;
    }
}
