class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != 0)
                list1.add(nums[i]);
            if (i != n - 1)
                list2.add(nums[i]);
        }
        return Math.max(rob1(list1), rob1(list2));

    }

    // House Robber 1
    public int rob1(ArrayList<Integer> list) {
        int size = list.size();

        if (size == 0)
            return 0;
        if (size == 1)
            return list.get(0);

        int prev = list.get(0);
        int prev2 = 0;

        for (int i = 1; i < size; i++) {
            int pick = list.get(i);
            if (i > 1) {
                pick += prev2;
            }

            int notPick = prev;

            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}