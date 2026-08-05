class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                list.add(-1);
            }else{
                list.add(stk.peek());
            }
           stk.push(arr[i]);
        }
        return list;
        
    }
}