class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> stk=new Stack<>();
        int lb = Integer.MIN_VALUE;
        for(Integer num:arr){
            if(num < lb) return false;
           while(!stk.isEmpty() && num > stk.peek()){
                lb=stk.pop();
            }
            stk.push(num);
        }
        return true;
    }
}