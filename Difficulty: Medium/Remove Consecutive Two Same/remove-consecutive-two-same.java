class Solution {
    public String removePair(String s) {
        // code here
        Stack<Character> stk=new Stack<>();
        
       for(char ch:s.toCharArray()){
            if(!stk.isEmpty() && stk.peek()==ch){
                stk.pop();
            }else{
            stk.push(ch);
            }
        }
        String ans=" ";
        if(stk.isEmpty()) return "-1";
         while(!stk.isEmpty())    ans = stk.pop() + ans;
        return ans;
    }
}