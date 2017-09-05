/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

*/



class Solution {
    public int reverse(int x) {
        int output = 0;
        boolean positive = (x>0);
        while (x != 0){
            if (positive && output > Integer.MAX_VALUE/10)
                return 0;
            if (!positive && output < Integer.MIN_VALUE/10)
                return 0;
            output = output*10 + (x%10);
            x = x /10;
        }
        return output;
    }
}