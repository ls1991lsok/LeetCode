/* 

118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if(numRows < 1) return res;
        
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i + 1);
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) row.add(1);
                else row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(row);
        }
        
        return res;
    }
}

