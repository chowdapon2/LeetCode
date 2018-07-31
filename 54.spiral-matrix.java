/*
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (27.84%)
 * Total Accepted:    158K
 * Total Submissions: 567.6K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList();
        if (matrix == null || matrix.length == 0)   return result;

        // find M x N length
        int m = matrix.length, n = matrix[0].length;
        int row = 0;
        int col = 0;
        // int result[] = new int[m*n];
        
        boolean[][] visited = new boolean[m][n];
        // direction{row,col}
        //{0,1}:rignt   {1,0}:down  {0,-1}:left  {-1,0}:up
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;

        for(int i=0; i<m*n; i++){
            result.add(matrix[row][col]);
            visited[row][col] = true;
            int temp_r = row + dr[dir];
            int temp_c = col + dc[dir];
            if(temp_r < m && temp_c <n && temp_c>=0 && temp_r>=0 && !visited[temp_r][temp_c]){
                row = temp_r;
                col = temp_c;
            }else{
                dir = (dir+1)%4;
                row += dr[dir];
                col += dc[dir];
            }
        }
        return result;
    }
}
