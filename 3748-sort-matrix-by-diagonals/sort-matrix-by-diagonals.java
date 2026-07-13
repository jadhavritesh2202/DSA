class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(i - j)) {
                    map.get(i - j).add(grid[i][j]);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(grid[i][j]);
                    map.put(i - j, list);
                }
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            ArrayList<Integer> list = entry.getValue();
            if (key >= 0) {
                list.sort(Collections.reverseOrder());
            } else {
                Collections.sort(list);
            }

        }
       //to store idx of list 
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int key = i - j;

                int idx = index.getOrDefault(key, 0);

                grid[i][j] = map.get(key).get(idx);

                index.put(key, idx + 1);
            }
        }

        return grid;

    }
}