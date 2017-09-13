/*
Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle.
Given two vectors A and B with the same size, calculate the cosine similarity.
Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).

Example
    Given A = [1, 2, 3], B = [2, 3 ,4].
    Return 0.9926.
    Given A = [0], B = [0].
    Return 2.0000
*/

class Solution {
    public double cosineSimilarity(int[] A, int[] B) {
        if(A.length != B.length || A.length == 0 || B.length == 0) return 2.0;        
        double dotProd = 0.0;
        double lengthA = 0.0;
        double lengthB = 0.0;
        for(int i = 0; i < A.length; i++) {
            dotProd += A[i] * B[i];
            lengthA += A[i] * A[i];
            lengthB += B[i] * B[i];
        }
        if(lengthA == 0 || lengthB == 0) return 2.0;
        return dotProd / (Math.sqrt(lengthA) * Math.sqrt(lengthB));
    }
}
