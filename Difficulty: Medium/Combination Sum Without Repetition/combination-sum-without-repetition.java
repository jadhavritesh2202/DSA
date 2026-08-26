class Solution {
    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        helper(0, target, arr, list, ans);

        return ans;
    }

    public void helper(int idx, int target, int[] arr,
                       ArrayList<Integer> list,
                       ArrayList<ArrayList<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            // Skip duplicates at the same level
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }

            // Array is sorted
            if (arr[i] > target) {
                break;
            }

            list.add(arr[i]);

            // Each element can be used only once
            helper(i + 1, target - arr[i], arr, list, ans);

            list.remove(list.size() - 1);
        }
    }
}