/**
346. Moving Average from Data Stream
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */



class MovingAverage {
    Queue<Integer> q = new LinkedList();
    int q_size_limit;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q_size_limit = size;
    }
    
    public double next(int val) {
        
        sum+=val;
        
        // check limit
        if(q.size() < q_size_limit){
            q.offer(val);
        }else{
            q.offer(val);
            int pop_out = q.poll();
            sum-=pop_out;
        }
        
        
        return sum/(double)q.size();
    }
    
//     public double next(int val) {
      
//         // check limit
//         if(q.size() < q_size_limit){
//             q.offer(val);
//         }else{
//             q.offer(val);
//             q.poll();
//         }
        
//         //return avaerage value
//         int cur_size = q.size();
//         int temp=0;
//         int ans=0;
//         for(int i=0; i<cur_size; i++){
//             // pop out
//             temp = q.poll();
//             ans+=temp;
//             //add back
//             q.offer(temp);
//         }
//         return ans/(double)cur_size;
//     }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */