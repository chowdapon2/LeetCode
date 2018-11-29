/**
170. Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false
 */

 //第一個解236 ms
 class TwoSum {

    List<Integer> array;
    /** Initialize your data structure here. */
    public TwoSum() {
        array = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        array.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        // use  two sum I solution    
        // ArrayList沒有length!!!  只有size() !!!!
        if (array == null || array.size() <= 1) {
        	return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // ArrayList沒有length!!!  只有size() !!!!
        for (int i = 0; i < array.size(); i++) {
            // ArrayList沒有ArrayList[i] 只有ArrayList.get(i)
        	int remaining = value - array.get(i);
        	if (!map.containsKey(remaining)) {
        		map.put(array.get(i), i);
        	} else {
        		return true;
        	}
        }
        return false;
    }
}

//第二個解  用hashMAP

    HashMap<Integer, Integer> table;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        table = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int input) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int num = entry.getKey();
            int remain = value - num;
            if (remain == num) {
                // For duplicates, ensure there are at least two individual numbers.
                if (entry.getValue() >= 2) return true;
            } else if (table.containsKey(remain)) {
                    return true;
                } 
        }
        return false;
    }
}


// 92ms的
class TwoSum {
    Map<Integer,Integer> map= new HashMap<Integer,Integer>();
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
       int val= map.getOrDefault(number,0);
        map.put(number,val+1);
        min=Math.min(min,number);
        max=Math.max(max,number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(min*2>value||max*2<value) return false;
        for(int e:map.keySet()){
            int key=value-e;
            if(key==e&&map.get(key)>1) return true;
            if(key!=e&&map.containsKey(key)) return true;
            
        }
               return false;
    }
}
