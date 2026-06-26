class CustomStack {
   int[] stk;
   int top;
    public CustomStack(int maxSize) {
        stk=new int[maxSize];
        top=-1;
    }
    
    public void push(int x) {
        if(top==stk.length-1){
            return;
        }
        stk[++top]=x;
    }
    
    public int pop() {
        if(top==-1) return -1;
        return stk[top--];
        
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k,stk.length);i++){
            stk[i]=stk[i]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */