class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack= new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (x <= min){
            stack.push(min);//push min-value last time
            min = x;
        }
		stack.push(x);
    }
    
    public void pop() {
        if(stack.peek()==min){
            stack.pop(); 
            min=stack.pop(); 
        }
        else stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}



