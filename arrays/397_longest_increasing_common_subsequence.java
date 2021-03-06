/*
Give an integer array，find the longest increasing continuous subsequence in this array.
An increasing continuous subsequence:
    Can be from right to left or from left to right.
    Indices of the integers in the subsequence should be continuous.

Notice
    O(n) time and O(1) extra space.

Example
    For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
    For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
*/

/*
Thought process:
    1. Two passes: iterate the array from left and right respectively.
       If the latter element is greater than the previous, increment count by one. 
       Otherwise (it is non-increasing), set count to default (one). Update max length at each step.
    2. One pass: iterate the array only once. Keep two counters, one increasing order count, one decreasing order count.
       If the latter element is greater than the previous, increment increasing count by one, meanwhile set decreasing order to default.
       If the latter element is smaller than the previous, increment decreasing count by one, meanwhile set increasing order to default.
       Otherwise (the latter equals the previous), set both counters to default. Update the max count at each step.
       How does this work? It is because we can treat the decreasing order count as the increasing order count from backward. 
       So in one pass, we count both forward and backward traversal.
*/

// two passes
public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int result = 0, leftCount = 1, rightCount = 1;
        // forward traversal
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i+1]) {
                left++;
            } else {
                left = 1;
	    }
            if (left > result) {
		result = left;
	    }
        }
        // backward traversal
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] < A[i-1]) {
                right++;
            } else {
                right = 1;
	    }
            if (right > result) {
		result = right;
	    }
        }
        return result;
    }
}

// one pass
public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int result = 0, leftCount = 1, rightCount = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i+1]) {
                leftCount++;
                rightCount = 1;
            } else if (A[i] > A[i+1]) {
                rightCount++;
                leftCount = 1;
            } else {
                leftCount = rightCount = 1;
            }
            result = Math.max(result, Math.max(leftCount, rightCount));
        }
        return result;
    }
}
