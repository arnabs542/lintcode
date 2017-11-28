/*
Given a sequence of integers, find the longest increasing subsequence (LIS).
You code should return the length of the LIS.

Clarification
    What's the definition of longest increasing subsequence?
        The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
        https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
    For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
    For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

Challenge
    Time complexity O(n^2) or O(nlogn)
*/

// binary search
public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int i = 0, j = len;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < n) {
                    i = m + 1;
                } else {
                    j = m;
		}
            }
            tails[i] = n;
            if (i == len) {
		len++;
	    }
        }
        return len;
    }
}

// DP
public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int i = Arrays.binarySearch(dp, 0, len, n);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = n;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
