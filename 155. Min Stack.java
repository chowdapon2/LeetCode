/**
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

// class MinStack {
//     Stack<Integer> stack;
//     // use this keep track on current min
//     Stack<Integer> min_stack;
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack< >();
//         min_stack = new Stack< >();
//     }
    
//     public void push(int x) {
//         if( min_stack.isEmpty() || min_stack.peek()>x){
//             min_stack.push(x);
//         }else{
//             min_stack.push(min_stack.peek());
//         }
        
//         stack.push(x);
        
//     }
    
//     public void pop() {      
//         stack.pop();
//         min_stack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return min_stack.peek();
//     }
// }


class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}


 */