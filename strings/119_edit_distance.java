/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

Example
    Given word1 = "mart" and word2 = "karma", return 3.
*/

/*
Thought process:
    DP: For exmple word1 = "azced", and word2 = "abcdef" 
             ""    "a"    "b"    "c"    "d"    "e"    "f"
        ""   0      1      2      3      4      5      6
        "a"  1      0      2      3      4      5      6
        "z"  2      1      1      2      3      4      5
        "c"  3      2      2      1      2      3      4
        "e"  4      3      3      2      3      2      3
        "d"  5      4      4      3      2      3      3

        Using the characters in word2 as the columns, the characters in word1 as the rows. Add an extra row and column which represent empty strings.
        For example, row 2 and column 5 (which is 4) represents converting "a" to "abcd".
        First row means converting an empty string (by inserting characters) to a string represented by column characters.
        First columns means converting a string (by deleting characters) to an empty string.  
        There are two cases: 
            1) The current character is different from the converted (insert, delete, replace are all possible operations)
               To delete, dp[i][j] = dp[i][j-1]+1. To insert, dp[i][j] = dp[i-1][j]+1. To replace, dp[i][j] = dp[i-1][j-1]+1.
               We pick whichever is minimal as the current cell value.
            2) The current character is the same as the converted (nothing needs to be done), the result is just the same as the shorter string without the new character dp[i][j] = dp[i-1][j-1].
*/

// O(n^2) time and O(n^2) space
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }
}

// O(n^2) time and O(n) space
