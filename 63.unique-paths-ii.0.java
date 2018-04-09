/*
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (32.15%)
 * Total Accepted:    133K
 * Total Submissions: 413.7K
 * Testcase Example:  '[[0]]'
 *
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 * ⁠ [0,0,0],
 * ⁠ [0,1,0],
 * ⁠ [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
        	return 0;
        }
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		}else {
        			if(i == 0 && j == 0) {
        				dp[i][j] = 1;
        			}else if(i == 0 && j > 0) {
        				dp[i][j] = dp[i][j - 1];
        			}else if(j == 0 && i > 0) {
        				dp[i][j] = dp[i - 1][j];
        			}else {
        				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        			}
        			
        		}
        	}
        }
        return dp[n - 1][m - 1];
    }
}
