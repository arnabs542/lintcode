/*
Write an algorithm to determine if a number is happy.
A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example
    19 is a happy number
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
*/

/*
Thought process:
    1. Use a hashset to store square sum at each step, once any number occurs twice, it is not a happy number.
    2. Floyd Cycle detection algorithm:
           Observe that non-happy number's square sum always reach a cycle, e.g.
           Given 11, 
           1^2 + 1^2 = 2
           2^2 = 4
           4^2 = 16
           1^2 + 6^2 = 37
           3^2 + 7^2 = 58
           5^2 + 8^2 = 89
           8^2 + 9^2 = 145
           1^2 + 4^2 + 5^2 = 42
           4^2 + 2^2 = 20
           2^2 + 0^2 = 4
           where 4 occurs twice, and the following sequence will repeat. Thus we can tell 11 is not a happy number.
           We can use two pointers, one slow runner calculating square sum once at each step, 
           one fast runnner calculating square sum twice at each step. When slow equals fast, 
           it is a happy number if the square sum is 1, otherwise it is not a happy number.
*/

// 
public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        while(true) {
            int sum = 0;
            while(n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            // decide if it is a happy number
            if(sum == 1) break;
            // check if square sum occurs twice. If so, it is not a happy number; if not, add it to the set
            if(set.contains(sum)) 
                return false;
            else 
                set.add(sum);
            // update n for next round
            n = sum;
        }
        return true;
    }
}

// two pointers
public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while(slow != fast);
        return slow == 1;
    }
    
    private int squareSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    } 
}
