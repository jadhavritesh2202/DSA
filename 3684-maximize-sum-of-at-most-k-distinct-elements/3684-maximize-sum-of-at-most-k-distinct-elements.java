class Solution {
    public int[] maxKDistinct(int[] nums, int k) {

        Set<Integer> set =
            new TreeSet<>(Collections.reverseOrder());

        for (int num : nums) {
            set.add(num);
        }

        int size = Math.min(k, set.size());
        int[] res = new int[size];

        int i = 0;

        for (int num : set) {
            if (i == size) break;
            res[i++] = num;
        }

        return res;
    }
}