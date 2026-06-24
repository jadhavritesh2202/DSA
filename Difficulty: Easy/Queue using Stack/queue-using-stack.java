class myQueue {

    // Initialize your data members
    
    Stack<Integer> s1;
    Stack<Integer> s2;

    myQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }


    void enqueue(int x) {
        // Implement enqueue operation
        s1.push(x);
    }

    void dequeue() {
        // Implement dequeue operation
        if (s1.isEmpty() && s2.isEmpty()) {
            return;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.isEmpty()){
            s2.pop();
        }
    }

    int front() {
        // Implement front operation
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        if(s2.isEmpty()) return -1;
        return s2.peek();
        
    }

    int size() {
        // Implement size operation
        return s1.size()+s2.size();
    }
}
