class Solution {
    int res=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
         int n=cookies.length;
         int[] list=new int[k];
         helper(0,cookies,k,list);
         return res;
    }
    public void helper(int idx,int[] arr,int k,int[] list){

        if(idx==arr.length){
             int max=Integer.MIN_VALUE;
            for(int num:list){
                 max=Math.max(max,num);
            }
            res=Math.min(res,max);
            return;
        }
        
        for(int i=0;i<k;i++){
             list[i]+=arr[idx];
             helper(idx+1,arr,k,list);
             list[i]-=arr[idx];
             
        }
    }
}