/* 

11. Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

Example 3:

Input: height = [4,3,2,1,4]
Output: 16

Example 4:

Input: height = [1,2,1]
Output: 2

Constraints:

n == height.length
2 <= n <= 3 * 10^4
0 <= height[i] <= 3 * 10^4

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int maxArea(int[] height) {
        int area = 0, i = 0, j = height.length - 1;
        while(i < j){
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) i++;
            else j--;
        }
        
        return area;
    }
}

/*

The max area is calculated by the following formula:

S = (j - i) * min(ai, aj)

We should choose (i, j) so that S is max. Note that i, j go through the range (1, n) and j > i. That's it.

The simple way is to take all possibilities of (i, j) and compare all obtained S. The time complexity is n * (n-1) / 2

What we gonna do is to choose all possibilities of (i, j) in a wise way. I noticed that many submitted solutions here can't explain why when :

ai < aj we will check the next (i+1, j) (or move i to the right)
ai >= aj we will check the next (i, j-1) (or move j to the left)
Here is the explaination for that:

When ai < aj , we don't need to calculate all (i, j-1), (i, j-2), .... Why? because these max areas are smaller than our S at (i, j)
Proof: Assume at (i, j-1) we have S'= (j-1-i) * min(ai, aj-1)
S'<= (j-1-i) * ai < (j-i) * ai = S, and when S'<S, we don't need to calculate
Similar at (i, j-2), (i, j-3), etc.

So, that's why when ai < aj, we should check the next at (i+1, j) (or move i to the right)

When ai >= aj, the same thing, all (i+1, j), (i+2, j), .... are not needed to calculate.

Link: https://leetcode.com/problems/container-with-most-water/discuss/200246/Proof-by-formula

*/