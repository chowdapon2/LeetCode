/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

[0]  => [1]
[3,2,5,4] => [3,2,5,5]
[9,9,9] => [1,0,0,0]
*/


class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return new int[0];
        }

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        //if all the way out the for loop, it means its the 999* case
        //so we generate new array and set first digit 1
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
        
        
        
        
        /*     fail try in [9,8,7,6,5,4,3,2,1,0] int會爆炸
        if(0==digits.length) return digits;
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<digits.length;i++){
            sb.append(digits[i]);
        }
        int temp = Integer.parseInt(sb.toString())+1;
        
        //int into array
        String temp2 =Integer.toString(temp);
        int len =temp2.length();
        
        //generate array
		int[] result = new int[len];
		for(int j=0; j<len;j++){
			result[j]=Character.getNumericValue(temp2.charAt(j));
		}
		return result;
        */
    }
}