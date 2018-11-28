/**
286. Walls and Gates

You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

 */

 // class Solution {
//     public void wallsAndGates(int[][] rooms) {
//         if (rooms.length == 0) return;
//         int INF = 2147483647;
//         int m = rooms.length;
//         int n = rooms[0].length;
        
//         // step 1 : find all 0 as root
//         Queue<int[]> queue = new LinkedList();
//         for (int i = 0; i<m ; i++){
//             for(int j =0; j<n; j++){
//                 if(rooms[i][j] ==  0){
//                     queue.offer(new int[]{i, j});
//                 }
//             }
            
//         }
//         // step 2 : BFS form all 0
//         while(!queue.isEmpty()){
//             int[] room = queue.poll();
//             // find it's neighbour 
//             // if neighbour's value bigger than current value +1
//             // set it's neighbour to current value +1 
//             // than add to queue for next round BFS
//             int row = room[0];
//             int col = room[1];
//             // up
//             if(row >0 && rooms[row-1][col] != -1){
//                 if(rooms[row-1][col] > rooms[row][col]+1){
//                     rooms[row-1][col]= rooms[row][col]+1;
//                     queue.offer(new int[]{row-1, col});
//                 }
//             }
//             // down
//             if(row <m-1 && rooms[row+1][col] != -1){
//                 if(rooms[row+1][col] > rooms[row][col]+1){
//                     rooms[row+1][col]= rooms[row][col]+1;
//                     queue.offer(new int[]{row+1, col});
//                 }
//             }
//             // left
//             if(col >0 && rooms[row][col-1] != -1){
//                 if(rooms[row][col-1] > rooms[row][col]+1){
//                     rooms[row][col-1]= rooms[row][col]+1;
//                     queue.offer(new int[]{row, col-1});
//                 }
//             }
//             //right
//             if(col <n-1 && rooms[row][col+1] != -1){
//                 if(rooms[row][col+1] > rooms[row][col]+1){
//                     rooms[row][col+1]= rooms[row][col]+1;
//                     queue.offer(new int[]{row, col+1});
//                 }
//             }
            
            
//         }
//     }
// }

// sample 3 ms submission
class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        for(int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    explore(rooms, i, j, 0);
                }
            }
        }
        
    }
    
    public void explore(int[][] rooms, int row, int col, int d) {
        
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || (rooms[row][col] <= d && d != 0)) return;
        
        rooms[row][col] = d;
        
        explore(rooms, row - 1, col, d + 1);
        explore(rooms, row, col + 1, d + 1);
        explore(rooms, row, col - 1, d + 1);
        explore(rooms, row + 1, col, d + 1);

    }
}
