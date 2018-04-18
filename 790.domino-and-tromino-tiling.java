/*
 * [806] Domino and Tromino Tiling
 *
 * https://leetcode.com/problems/domino-and-tromino-tiling/description/
 *
 * algorithms
 * Medium (32.21%)
 * Total Accepted:    2.6K
 * Total Submissions: 8.1K
 * Testcase Example:  '3'
 *
 * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape.
 * These shapes may be rotated.
 * 
 * 
 * XX  <- domino
 * 
 * XX  <- "L" tromino
 * X
 * 
 * 
 * Given N, how many ways are there to tile a 2 x N board? Return your answer
 * modulo 10^9 + 7.
 * 
 * (In a tiling, every square must be covered by a tile. Two tilings are
 * different if and only if there are two 4-directionally adjacent cells on the
 * board such that exactly one of the tilings has both squares occupied by a
 * tile.)
 * 
 * 
 * 
 * Example:
 * Input: 3
 * Output: 5
 * Explanation: 
 * The five different ways are listed below, different letters indicates
 * different tiles:
 * XYZ XXZ XYY XXY XYY
 * XYZ YYZ XZZ XYY XXY
 * 
 * Note:
 * 
 * 
 * N  will be in range [1, 1000].
 * 
 * 
 * 
 */
class Solution {
    public int numTilings(int N) {
        /*
        dp[0] means 0 rows filled which comes from have 0 rows filled and have a vertical domino, or have both rows filled
        dp[1] means first row is filled which comes from have last row filled and have a horizontal domino, or have 0 rows filled and 'L' shape tromino
        dp[2] means last row is filled which comes from have first row filled and have a horizontal domino, or have 0 rows filled and 'L' shape tromino
        dp[3] means both rows filled which comes from 0 rows filled and have 2 horizontal dominos, or have 1 row filled and 'L' shape tromino (two cases)
        */
        int mod = 1000000007;
        long[] dp = new long[]{1, 0, 0, 0};
        for(int i = 0; i < N; i++) {
        	long[] tmp = new long[4];
        	tmp[0b00] = (dp[0b00] + dp[0b11]) % mod;
        	tmp[0b01] = (dp[0b00] + dp[0b10]) % mod;
        	tmp[0b10] = (dp[0b00] + dp[0b01]) % mod;
        	tmp[0b11] = (dp[0b00] + dp[0b01] + dp[0b10]) % mod;
        	dp = tmp;
        }
        return (int) dp[0];
    }
}
