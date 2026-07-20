class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;
        k = k % len;
        int k1 = len - k;

        reverse(0, k1 - 1, grid, grid[0].length);
        reverse(k1, len - 1, grid, grid[0].length);
        reverse(0, len - 1, grid, grid[0].length);

        for (int[] row : grid) {
            List<Integer> temp = new ArrayList<>();
            for (int num : row) {
                temp.add(num);
            }
            list.add(temp);
        }
        return list;

    }

    public void reverse(int i, int j, int[][] grid, int cols) {
        while (i < j) {
            int temp = grid[i / cols][i % cols];
            grid[i / cols][i % cols] = grid[j / cols][j % cols];
            grid[j / cols][j % cols] = temp;

            i++;
            j--;
        }
    }
}