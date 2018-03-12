/*
概念: 要找x的開根號 如果有小數點, 就只回傳整數數值
用二分法來開尻
把mid當成開根號的值
mid的平方 = x
但因為只回傳整數值, 所以改尻成
mid的平方 <= x
(同時除上mid)
mid <= x/mid
將上述算式當成判斷式來移動left 跟right
 left =mid+1; +1的原因是為了讓他會跳出while loop
 如果是left = mid跟戳= mid  最後會無窮迴圈, 會死人的呢
*/

===41ms===
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 0, right = x;
            while (left < right) {
                int mid = left + (right-left)/2;
                if(mid <= x/mid){
                    left =mid+1;
                }else{
                    right = mid;
                }
            }
        return left-1;
        }
}



====2ms=========
class Solution {
    public int mySqrt(int x) {
         if (x == 0)
        return 0;
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
           
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                ans = mid;  
                left = mid + 1;
            }
        }
        return ans ;
    }
}