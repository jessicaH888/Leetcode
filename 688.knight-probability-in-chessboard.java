/*
 * [688] Knight Probability in Chessboard
 *
 * https://leetcode.com/problems/knight-probability-in-chessboard/description/
 *
 * algorithms
 * Medium (39.99%)
 * Total Accepted:    6.8K
 * Total Submissions: 17.1K
 * Testcase Example:  '3\n2\n0\n0'
 *
 * 
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and
 * attempts to make exactly K moves.  The rows and columns are 0 indexed, so
 * the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * 
 * 
 * 
 * A chess knight has 8 possible moves it can make, as illustrated below.  Each
 * move is two squares in a cardinal direction, then one square in an
 * orthogonal direction.
 * 
 * 
 * 
 * 
 * 
 * Each time the knight is to move, it chooses one of eight possible moves
 * uniformly at random (even if the piece would go off the chessboard) and
 * moves there.
 * 
 * 
 * 
 * The knight continues moving until it has made exactly K moves or has moved
 * off the chessboard.  Return the probability that the knight remains on the
 * board after it has stopped moving.
 * 
 * 
 * Example:
 * 
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight
 * on the board.
 * From each of those positions, there are also two moves that will keep the
 * knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * 
 * 
 * 
 * Note:
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 * 
 */
class Solution {
	public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        int[] dirX = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dirY = {-1, 1, -2, 2, -2, 2, -1, 1};
        for(int move = 0; move < K; move++) {
        	double[][] tmp = new double[N][N];
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			for(int k = 0; k < 8; k++) {
        				int nextX = i + dirX[k], nextY = j + dirY[k];
        				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
        					tmp[nextX][nextY] += dp[i][j] * 1 / 8;
        				}
        			}
        		}
        	}
        	dp = tmp;
        }
        double ans = 0;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		ans += dp[i][j];
        	}
        }
        return ans;
	}

	
	/*
	//BFS method
    public double knightProbability(int N, int K, int r, int c) {
        if(K == 0) {
        	return 1;
        }
        if(N == 0 || r > N - 1 || c > N - 1) {
        	return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        double[][] prob = new double[N][N];
        prob[r][c] = 1;
        int[] dirX = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dirY = {-1, 1, -2, 2, -2, 2, -1, 1};
        double ans = 0;
        while(K > 0) {
        	// System.out.println("K is " + K);
        	int size = queue.size();
        	// System.out.println("Size is " + size);
        	for(int i = 0; i < size; i++) {
        		int[] cur = queue.poll();
        		for(int j = 0; j < 8; j++) {
        			int nextX = cur[0] + dirX[j], nextY = cur[1] + dirY[j];
        			// System.out.println(nextX + " " + nextY);
        			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
        				prob[nextX][nextY] = prob[cur[0]][cur[1]] * 1 / 8;
        				// System.out.println(prob[nextX][nextY]);
        				if(K == 1) {
        					ans += prob[nextX][nextY];
        				}
        				queue.offer(new int[]{nextX, nextY});
        			}
        		}
        	}
        	K--;
        }
        return ans;
    }
    */
}
