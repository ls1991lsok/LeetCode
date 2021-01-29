/* 

59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]
 
Constraints:

1 <= n <= 20

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int count = 0;
        
        while(count < n * n){
            for(int i = left; i <= right && count < n * n; i++) res[up][i] = ++count;
            for(int i = up + 1; i <= down - 1 && count < n * n; i++) res[i][right] = ++count;
            for(int i = right; i >= left && count < n * n; i--) res[down][i] = ++count;
            for(int i = down - 1; i >= up + 1 && count < n * n; i--) res[i][left] = ++count;
            
            left++; right--; up++; down--;
        }
        
        return res;
    }
}