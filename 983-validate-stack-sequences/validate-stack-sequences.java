class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int m=pushed.length;
        int n=popped.length;
        if(m!=n) return false;
        Stack<Integer> stk=new Stack<>();
           int i=0;
        for(int num:pushed){
            stk.push(num);
            
            while(!stk.isEmpty() && i<n && stk.peek()==popped[i]){
                stk.pop();
                i++;
            }
        }
        return stk.isEmpty();
    }
}