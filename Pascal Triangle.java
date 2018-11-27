/*
118. Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        //要用ArrayList建造  不然會GG
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // A[x][y] = 1 in start and end
        // A[x][y] = A[x-1][y-1]+ A[x-1][y]
        
        if(numRows ==0) return result;
        
        //can't use new ArrayList<Integer>(1); 
        //it may cause error
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(1);
        result.add(sub);
        
        // every row's element's number = it's row number
        for(int i =1; i< numRows; i++){
            // take upper row
            // to get upper row use .get() function!!
            List<Integer> upper_row = result.get(i-1);
            
            List<Integer> cur_row = new ArrayList<Integer>();
            
            // add one at first
            cur_row.add(1);
            
            // every row's element's number = it's row number
            //i<j also can use j<upper_row.size()-1 but slower
            for(int j =1 ;j<i; j++ ){
                cur_row.add(upper_row.get(j-1)+upper_row.get(j));
            }
            
            // add one at the end
            cur_row.add(1);
            
            result.add(cur_row);
            
        }
        
        return result;
        
        
    }
}