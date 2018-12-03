/**
62. Unique Paths
Medium
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Input: m = 7, n = 3
Output: 28

 */


 class Solution {
    public int uniquePaths(int m, int n) {
        // always down or right
        // Amn = A[m-1][n] + A[m][n-1]
        // A[m][0]= A[0][n] = 1
        int[][] A = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(i == 0 || j==0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = A[i-1][j] + A[i][j-1];
                }
            }
        }
        return A[m-1][n-1];
    }
}