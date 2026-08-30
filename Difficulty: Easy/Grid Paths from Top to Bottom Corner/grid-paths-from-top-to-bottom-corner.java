class Solution {
    public ArrayList<ArrayList<Integer>> allPaths(int[][] mat) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        solve(0, 0, res, list, mat);

        return res;
    }

    public void solve(int i, int j,
                      ArrayList<ArrayList<Integer>> res,
                      ArrayList<Integer> list,
                      int[][] mat) {

        // Out of bounds
        if (i >= mat.length || j >= mat[0].length) {
            return;
        }

        // Add current cell
        list.add(mat[i][j]);

        // Destination
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        // Move Right
        solve(i, j + 1, res, list, mat);

        // Move Down
        solve(i + 1, j, res, list, mat);

        // Backtrack
        list.remove(list.size() - 1);
    }
}