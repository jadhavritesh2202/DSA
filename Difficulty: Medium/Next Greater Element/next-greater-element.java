class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stk=new Stack<>();
        
        int[] nextGret=new int[arr.length];
        
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!stk.isEmpty() && arr[stk.peek()]<= arr[i])
            {
                stk.pop();
            }
            if(stk.isEmpty())
            {
                nextGret[i]=-1;
            }else
            {
                nextGret[i]=arr[stk.peek()];
            }
            stk.push(i);
        }
        
        ArrayList<Integer> list=new ArrayList<>();
         for(int v:nextGret)
         {
             list.add(v);
         }
        return list;
    }
}