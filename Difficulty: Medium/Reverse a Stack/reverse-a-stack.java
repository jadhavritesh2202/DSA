class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }
        int temp=st.pop();
        reverseStack(st);
        insertAtEnd(st,temp);
        
        
    }
    public static void insertAtEnd(Stack<Integer> st,int ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        int top=st.pop();
        insertAtEnd(st,ele);
        st.push(top);
    }
}
