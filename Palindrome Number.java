/*
Determine whether an integer is a palindrome. Do this without extra space.
*/



class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int value =0;
        while(x > value){
            value = x%10 + value*10;
            x=x/10;    
        }
        if (x == value || x == value/10){
            return true;
        }
        return false;
            
    }
}

/*
比如 1234321；
每次通过除以10和对10取余来保存下前半部分x和后半部分v，比如 x = 123432, v=1;
直到x=123，v=1234的时候，循环结束，再通过 v/10 == x，来判断数是不是回环的。
*/