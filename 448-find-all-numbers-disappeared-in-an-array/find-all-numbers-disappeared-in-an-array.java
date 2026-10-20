class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        int i=0;
        while(i<n){
            int curr=nums[i]-1;
            if(nums[i]!=nums[curr]){
                swap(i,curr,nums);
            }else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(j+1!=nums[j]){
                  list.add(j+1);
            }
        }
        return list;
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}