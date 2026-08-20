class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int j=2;
        while(j<n){
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)){
                arr1.add(nums[j]);
            }else{
                arr2.add(nums[j]);
            }
            j++;
        }
        int k=0;
        for(int ele:arr1){
             nums[k++]=ele;
        }
         for(int ele:arr2){
             nums[k++]=ele;
        }
        return nums;

    }
}