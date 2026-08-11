class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            set.add(num);
        }

        int last = nums[0];
        int sum = nums[0];

        for (int i = 1; i < n; i++) {

            if (nums[i] == last + 1) {
                last = nums[i];
                sum += nums[i];
            } else {
                break;
            }
        }

        int x = sum;

        while (set.contains(x)) {
            x++;
        }
        return x;
    }
}