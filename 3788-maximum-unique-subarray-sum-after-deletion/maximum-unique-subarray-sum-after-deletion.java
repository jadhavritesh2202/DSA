class Solution {
    public int maxSum(int[] nums) {
        //for unique
      HashSet<Integer> set=new HashSet<>();
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
            if(num>0 && !set.contains(num)){
                set.add(num);
                sum+=num;
            }
        }
        return sum>0?sum:max;
    }
}