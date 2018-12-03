/**
63. Unique Paths II
Medium
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2

 */

 class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // always down or right
        // Amn = A[m-1][n] + A[m][n-1]
        // A[m][0]= A[0][n] = 1
        int m= obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        
        obstacleGrid[0][0] = 1;
        // for first row of obstacleGrid
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        // for first column of obstacleGrid
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        
        // Starting from cell(1,1) fill up the values
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        
        return obstacleGrid[m-1][n-1];
    }
}