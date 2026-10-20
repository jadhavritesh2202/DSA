class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int cnt=1;
        for(int i=0;i<n;i++){
           if(cnt==nums[i]){
            cnt++;
           }else{
            continue;
           }
        }
        return cnt;
    }
}