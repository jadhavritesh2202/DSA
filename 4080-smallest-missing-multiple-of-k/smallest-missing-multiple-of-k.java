class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int num=k;
        int ans=0;
        while(true){
           if(!set.contains(num)){
               ans=num;
               break;
           }
           num+=k;
        }
        return ans;



    }
}