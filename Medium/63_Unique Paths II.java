/* 

63. Unique Paths II

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

Example 1:

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 
Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.

 */

/****************************************************

Solution 1 --- DP

****************************************************/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) break;
            else map[i][0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1) break;
            else map[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1) map[i][j] = 0;
                else map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        
        return map[m - 1][n - 1];
        
    }
}

/****************************************************

Solution 2 --- DP Optimization

****************************************************/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for(int[] row : obstacleGrid){
            for(int i = 0; i < row.length; i++){
                if(row[i] == 1) dp[i] = 0;
                else if(i > 0) dp[i] += dp[i - 1];
            }
        }
        
        return dp[obstacleGrid[0].length - 1];
    }
}