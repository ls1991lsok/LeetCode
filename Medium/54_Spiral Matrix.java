/* 

54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;
        
        while(res.size() < m * n){
            for(int i = left; i <= right && res.size() < m * n; i++) res.add(matrix[up][i]);
            for(int i = up + 1; i <= down - 1 && res.size() < m * n; i++) res.add(matrix[i][right]);
            for(int i = right; i >= left && res.size() < m * n; i--) res.add(matrix[down][i]);
            for(int i = down - 1; i >= up + 1 && res.size() < m * n; i--) res.add(matrix[i][left]);
            
            left++; right--; up++; down--;
        }
        
        return res;
    }
}