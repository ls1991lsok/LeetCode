/* 

292. Nim Game

You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.

Example 1:

Input: n = 4
Output: false
Explanation: These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.

Example 2:

Input: n = 1
Output: true
Example 3:

Input: n = 2
Output: true
 

Constraints:

1 <= n <= 2^31 - 1

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public boolean canWinNim(int n) {
        return ((n & 3) != 0);
    }
}

/*
According to the hint, we know that if n = 4, no matter how many stones I remove, I lose. If n = 5, I can remove one stone and there are 4 stones for another player. Thus, I win. Similarly, if n = 6 or 7, I can remove 2 or 3 stones and i win finally.
If n = 8, no matter how many stones I remove, there are 7 or 6 or 5 stones for another player, s/he can remove stones as we said before and then wins.
If n = 9 or 10 or 11, I can leave 8 stones to another player, then I win.
If n = 12, I can leave 9, 10 or 11 stones to another player. Then, s/he can leave 8 stones to me, then I lose.
......
The rule is: if (n % 4 == 0) then I lose.

Link:https://leetcode.com/problems/nim-game/discuss/73809/Simple-java-solution-with-explanation
*/

/****************************************************

Solution 2 --- DP

****************************************************/

class Solution {
    public boolean canWinNim(int n) {
        if(n < 4) return true;
        
        boolean[] check = new boolean[n + 1];
        check[0] = true;
        check[1] = true;
        check[2] = true;
        check[3] = true;
        for(int i = 4; i <= n; i++){
            check[i] = !(check[i - 1] && check[i - 2] && check[i - 3]);
        }
        
        return check[n];
    }
}

