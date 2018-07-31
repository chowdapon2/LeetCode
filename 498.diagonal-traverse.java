/*
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (44.63%)
 * Total Accepted:    23.2K
 * Total Submissions: 51.9K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image. 
 * 
 * 
 * Example:
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 * 
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)   return new int[0];

        // find M x N length
        int m = matrix.length, n = matrix[0].length;
        int index_r = 0;
        int index_c = 0;
        int result[] = new int[m*n];
        // two kinds of pattern
        // 1.up M-1/N+1 until someone reach limit
        // 2.down M+1/N-1 until someone reach limit
        // But how to know next round is going up/down?
        // Ans: (index_m+index_n)%2 == 0 goes up !!

        for(int i = 0; i<result.length; i++){
            result[i] = matrix[index_r][index_c];
            if((index_r+index_c)%2 == 0){ //up
                if(index_c == n-1){
                    index_r++;
                }else if(index_r== 0){
                    index_c++;
                }else{
                    index_r--;
                    index_c++;
                }
            }else{ //down
                if(index_r== m-1){
                    index_c++;
                }else if(index_c == 0){
                    index_r++;
                }else{
                    index_r++;
                    index_c--;
                }
            }

        }
        return result;
    }
}


/*
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)   return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        
        for (int layer = 0, i = 0; layer < m+n-1; layer++) {
            int upperBoundx = Math.min(layer, m-1);
            int lowerBoundx = Math.max(0, layer - n + 1);
            
            if (layer % 2 != 0) {
                for (int x = lowerBoundx; x <= upperBoundx; x++) {
                    res[i++] = matrix[x][layer-x];
                }
            } else {
                
                for (int x = upperBoundx; x >= lowerBoundx; x--) {
                    res[i++] = matrix[x][layer-x];
                }
            }
        }
        return res;
    }
}



*/