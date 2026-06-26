class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        // code here
        int mid=s.size()/2;
        RemoveMid(s,mid);
    }
    public void RemoveMid(Stack<Integer> stk,int k){
        if(k==0){
            stk.pop();
            return;
        }
        int top=stk.pop();
        RemoveMid(stk,k-1);
        stk.push(top);
    }
}