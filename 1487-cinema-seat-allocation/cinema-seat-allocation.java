class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    
        for (int[] num : reservedSeats) {
            int key = num[0]; // row
            int val = num[1]; // seat

            map.putIfAbsent(key, new HashSet<>());
            map.get(key).add(val);
        }
        int res = (n - map.size()) * 2;

        //traverse on map
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            HashSet<Integer> seats = entry.getValue();

            boolean grpA = !seats.contains(2) &&
                    !seats.contains(3) &&
                    !seats.contains(4) &&
                    !seats.contains(5);

            boolean grpB = !seats.contains(4) &&
                    !seats.contains(5) &&
                    !seats.contains(6) &&
                    !seats.contains(7);

            boolean grpC = !seats.contains(6) &&
                    !seats.contains(7) &&
                    !seats.contains(8) &&
                    !seats.contains(9);

            if (grpA && grpC) {
                res += 2;
            } else if (grpA || grpB || grpC) {
                res += 1;

            }

        }
        return res;
    }
}