
import java.util.*;

class Solution {

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();

        // Custom sorting
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = nums[i];
        }

        Arrays.sort(order, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });

        // Map each number to its correct index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(order[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            while (map.get(sorted[i]) != i) {
                int correctIndex = map.get(sorted[i]);

                int temp = sorted[i];
                sorted[i] = sorted[correctIndex];
                sorted[correctIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }
}
