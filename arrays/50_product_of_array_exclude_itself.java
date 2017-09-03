/*
Given an integers array A.
Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Example
For A = [1, 2, 3], return [6, 3, 2].
*/

/*
Thought process:
    1. It is easy to come up with the brute-force solution with nested for loops
       of O(n2) time complexity.
    2. Better solution? To improve the time complexity, we can think about whether it can be solved in O(n) time.
       This can be done via forward-backward traversal. 
       The forward traversal will calculate the multiplication of all elements left to the current element. 
       The backward traversal will calculate the multiplication of all elements right to the current element.
       Multiply them together we can the correct value for the current element.    
*/

//O(n2) time and O(1) space
public class Solution {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if(A == null || A.size() == 0) return result;
        for(int i = 0; i < A.size(); i++) {
            long mul = 1;
            for(int j = 0; j < A.size(); j++) if(i != j) mul *= A.get(j);
            result.add(mul);
        }
        return result;
    }
}

//O(n) time and O(1) space
public class Solution {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        if(A.size() == 0 || A == null) return null;
        ArrayList<Long> res = new ArrayList<Long>();
        Long leftMul = 1L, rightMul = 1L;
        for(int i = 0; i < A.size(); i++) {
            res.add(leftMul);
            leftMul *= A.get(i);
        }
        for(int j = A.size() - 1; j >= 0; j--) {
            res.set(j, res.get(j) * rightMul);
            rightMul *= A.get(j);
        }
        return res;
    }
}
