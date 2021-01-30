/* 

64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100

 */

/****************************************************

Solution 1 --- DP

****************************************************/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] map = new int[m][n];
        map[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) map[i][0] = map[i - 1][0] + grid[i][0];
        for(int i = 1; i < n; i++) map[0][i] = map[0][i - 1] + grid[0][i];
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + grid[i][j];
            }
        }
        
        return map[m - 1][n - 1];
    }
}

/****************************************************

Solution 2 --- DP Optimization

****************************************************/

class Solution {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int[] dp = new int[width];
        for(int i = 1; i < width; i++) dp[i] = Integer.MAX_VALUE;
        
        for(int[] row: grid){
            for(int i = 0; i < width; i++){
                if(i == 0) dp[i] += row[i];
                else dp[i] = Math.min(dp[i], dp[i - 1]) + row[i];
            }
        }
        
        return dp[width - 1];
    }
}