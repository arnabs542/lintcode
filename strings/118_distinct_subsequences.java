/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
    Given S = "rabbbit", T = "rabbit", return 3.

Challenge
    Do it in O(n2) time and O(n) memory.
    O(n2) memory is also acceptable if you do not know how to optimize memory.
*/

/*
Thought process:

*/

// O(n^2) time and O(n^2) space
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) return 0;
        int[][] dp = new int[S.length()+1][T.length()+1];
        for (int i = 0; i <= S.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}

// O(n^2) time and O(n) space
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) return 0;
        int[] dp = new int[T.length()+1];
        dp[0] = 1;
        for (int j = 1; j <= S.length(); j++) {
            for (int i = T.length(); i >= 1; i--) {  
                dp[i] = dp[i] + (T.charAt(i-1) == S.charAt(j-1) ? dp[i-1] : 0);
            }
        }
        return dp[T.length()];
    }
}
