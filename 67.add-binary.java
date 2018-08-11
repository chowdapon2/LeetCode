/*
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (35.27%)
 * Total Accepted:    221.3K
 * Total Submissions: 627.5K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0 ){
            return b;
        }else if(b.length() == 0){
            return a;
        }

        StringBuilder res = new StringBuilder();
        int carry = 0;
        int aByte = 0;
        int bByte = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--,j--){
            if( !(i<0) ){
                //use '0' to turn char into interger
                aByte = a.charAt(i) - '0';
            }else{
                aByte = 0;
            }

            if( !(j<0) ){
                bByte = b.charAt(j) - '0';
            }else{
                bByte = 0;
            }

            int temp = aByte + bByte + carry;
            res.insert(0, temp%2);
            carry = temp/2;
        }

        if (carry==1){
            res.insert(0,'1');
        }
    return res.toString();
    }
}

/**
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            carry = sum/2;
        }
        if(carry != 0){sb.append(carry);}
        return sb.reverse().toString();
    }
}

 */
// StringBuilder str_a = new StringBuilder(a);
// StringBuilder str_b = new StringBuilder(b);
// char[] char_a = a.toCharArray();
// char[] char_b = b.toCharArray();
// System.out.println("a length = " + str_a.length());
// System.out.println("char a length = " + char_a.length);