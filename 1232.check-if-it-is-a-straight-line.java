/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // find the slope y = ax +b
        int[] A1 = coordinates[0];
        int[] A2 = coordinates[1];
        int a = 0;
        if( (A1[0]-A2[0]) != 0){
            a = (A1[1]-A2[1])/(A1[0]-A2[0]);
        }
        
        int b = A1[1]-(a*A1[0]);

        int x = 0;
        int y = 0;
        for(int i=0; i<coordinates.length; i++){
            x = coordinates[i][0];
            y = coordinates[i][1];
            if(y != (a*x+b)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

