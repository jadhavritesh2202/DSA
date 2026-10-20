class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res=new int[2];
        int n=nums.length;
        int i=0;
        while(i<n){
            int currIdx=nums[i]-1;
            if(nums[i]!=nums[currIdx]){
                swap(i,currIdx,nums);
            }else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(j+1!=nums[j]){
                res[0]=nums[j];
                res[1]=j+1;
            }
        }
        return res;

    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
}