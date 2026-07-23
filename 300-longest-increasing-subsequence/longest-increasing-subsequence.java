class Solution {
    public int lengthOfLIS(int[] arr) {
         // code here
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        list.add(arr[0]);
        
        for(int i=1;i<n;i++){
            if(list.isEmpty() || arr[i]>list.get(list.size()-1)){
                list.add(arr[i]);
            }else{
                int idx=LowerBound(list,arr[i]);
                list.set(idx,arr[i]);
            }
        }
        
        return list.size();
    }
    public int LowerBound(List<Integer> list,int key){
            int l=0;
            int h=list.size();
            while(l<h){
                int mid=l+(h-l)/2;
                
                if(list.get(mid)>=key){
                    h=mid;
                }else{
                    l=mid+1;
                }
            }
            return l;
    }
}