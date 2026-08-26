class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
      //  List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
       

        List<Integer> list = new ArrayList<>();
        helper(0, nums, list, set);
        return new ArrayList<>(set);
    }

    public void helper(int idx, int[] nums, List<Integer> list, Set<List<Integer>> set) {

        //base case
        if (idx == nums.length) {
            if (list.size() >= 2) {
                set.add(new ArrayList<>(list));
            }
            return;
        }

        // if(list.get(list.size()-1)>nums[idx]){
        //     return;
        // }
        if (list.isEmpty() || list.get(list.size() - 1) <= nums[idx]) {
            list.add(nums[idx]);
            helper(idx + 1, nums, list, set);
            list.remove(list.size() - 1);
        }
        helper(idx + 1, nums, list, set);
    }
}