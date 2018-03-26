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
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        if(numRows == 0){
            return triangle;
        }
        
        //can't use new ArrayList<Integer>(1); 
        //it may cause error
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(1);
        triangle.add(sub);
        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> prevRow = triangle.get(i-1);//拿上一個row, 整行拿
            
            //beginning
            row.add(1);
            
            for(int j = 1; j<i ; j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            //end
            row.add(1);
            
            triangle.add(row);
        }
        
        return triangle;
    }
}