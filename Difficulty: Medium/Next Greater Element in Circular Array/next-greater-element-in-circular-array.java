class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        Stack<Integer> stk=new Stack<>();
        int n=arr.length;
        int[] res=new int[n];
        
        for(int i=2*n-1;i>=0;i--){
            int curr=arr[i % n];
            while(!stk.isEmpty() && stk.peek()<=curr){
                stk.pop();
            }
            
            if(i<n){
                if(stk.isEmpty()){
                    res[i]=-1;
                }else{
                    res[i]=stk.peek();
                }
            }
        stk.push(arr[i % n]);    
        }
          ArrayList<Integer> list=new ArrayList<>();
         for(int v:res)
         {
             list.add(v);
         }
        return list;
        
    }
}