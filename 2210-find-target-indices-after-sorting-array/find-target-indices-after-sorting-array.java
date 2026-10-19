class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=1;i<=n;i++){
            if(nums[i-1]==target){
               list.add(i-1);
            }
        }
        return list;
    }
}