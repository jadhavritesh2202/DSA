class twoStacks {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    twoStacks() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        stk1.push(x);
        
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        
        // code here
        stk2.push(x);
    }

    // Function to remove an element from top of the stack1.
        
    int pop1() {
        // code here
              if(!stk1.isEmpty()){
                   return stk1.pop();
        }
        return -1;
    }

        
    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
                if(!stk2.isEmpty()){
                    return stk2.pop();
        }
        return -1;
    }
}