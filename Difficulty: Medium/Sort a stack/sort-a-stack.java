class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()) return;
        int top=st.pop();
        sortStack(st);
        
        InsertIntoStk(st,top);
    }
    public void InsertIntoStk(Stack<Integer> stk,int x){
        
        if(stk.isEmpty() || stk.peek()<=x){
            stk.push(x);
            return;
        }
        
        int temp=stk.pop();
        
        InsertIntoStk(stk,x);
        
        stk.push(temp);
        
        
    }
}