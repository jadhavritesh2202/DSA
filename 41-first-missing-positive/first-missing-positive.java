class Solution {
    public int firstMissingPositive(int[] nums) {
        //int n=nums.length;
        // Arrays.sort(nums);
        // int cnt=1;
        // for(int i=0;i<n;i++){
        //    if(cnt==nums[i]){
        //     cnt++;
        //    }else{
        //     continue;
        //    }
        // }
        // return cnt;

        int n = nums.length;
        int i = 0;
        while (i < n) {
            int currIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[currIdx]) {
                swap(i, currIdx, nums);
            } else {
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;


    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}