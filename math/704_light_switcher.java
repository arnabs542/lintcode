/*
There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
    You can flip all the lights.
    You can flip lights with even numbers.
    You can flip lights with odd numbers.
    You can flip lights with (3k + 1) numbers, k = 0, 1, 2, ...

Example
    Given n = 1, m = 1.
    return 2 // Status can be: [on], [off]
    Given n = 2, m = 1.
    return 3 // Status can be: [on, off], [off, on], [off, off]
*/

public class Solution {
    public int flipLights(int n, int m) {
        if (n <= 0 || m < 0) return 0;
        if (m == 0) return 1;
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return (m == 1) ? 3 : 4;
        } else {
            return (m == 1) ? 4 : ((m == 2) ? 7 : 8);
        }
    }
}
