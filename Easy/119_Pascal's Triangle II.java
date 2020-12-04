/* 

119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.

Notice that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Follow up:

Could you optimize your algorithm to use only O(k) extra space?

 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]


Example 2:

Input: rowIndex = 0
Output: [1]


Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for(int i = 0; i <= rowIndex; i++){
            for(int j = res.size() - 1; j > 0; j--){
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }
        
        return res;
    }
}

