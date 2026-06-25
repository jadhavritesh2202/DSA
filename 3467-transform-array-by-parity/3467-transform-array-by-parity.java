class Solution {
    public int[] transformArray(int[] nums) {
        int oc=0,ec=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                ec++;
            }
            else oc++;
        }
        for(int i =0;i<ec;i++){
            nums[i]=0;
        }
        for(int i =ec;i<nums.length;i++){
            nums[i]=1;
        }
        return nums;
    }
}