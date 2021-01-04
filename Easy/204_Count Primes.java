/* 

204. Count Primes

Count the number of prime numbers less than a non-negative number, n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 10^6

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int countPrimes(int n) {
        if(n < 3) return 0;
        
        boolean[] notPrime = new boolean[n];
        int res = n / 2;
        for(int i = 3; i * i < n; i += 2){
            if(notPrime[i]) continue;
            for(int j = i * i; j < n; j += 2 * i){
                if(!notPrime[j]){
                    notPrime[j] = true;
                    res--; 
                }

            }
        }
        
        return res;
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        
        boolean[] notPrime = new boolean[n];
        int res = 0;     
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                res++;
                for(int j = 2; i * j < n; j++) notPrime[i * j] = true;
            }
        }
        
        return res;
    }
}