class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // code here
         int count=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int val=arr[i]%k;
            int c=(k-val)%k;
            if(hm.containsKey(c)){
                count+=hm.get(c);
            }
            if(!hm.containsKey(val)){
                hm.put(val,1);
            }
            else{
                hm.put(val,hm.get(val)+1);
            }
        }
       
        return count;

    }
}