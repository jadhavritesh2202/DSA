class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length;
        int cnt=0;
        for (int num : nums) {
            cnt += solve(num, digit);
        }
        return cnt;

    }

    public int solve(int num, int k) {
        int temp = num;
        int cnt = 0;
        while (temp > 0) {
            int rem = temp % 10;
            if (rem == k) {
                cnt++;
            }
            temp = temp / 10;

        }
        return cnt;
    }

}