class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int correct = nums[i];

            if (nums[i] < n && nums[i] != nums[correct]) {
                swap(i, correct, nums);
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        return n;
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}