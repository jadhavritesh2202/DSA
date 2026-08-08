class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>();

        for (String s : deadends) {
            dead.add(s);
        }

        // Starting point is blocked
        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add("0000");
        visited.add("0000");

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                String curr = q.poll();

                if (curr.equals(target)) {
                    return moves;
                }

                for (int i = 0; i < 4; i++) {

                    // INCREMENT
                    char[] arr = curr.toCharArray();

                    int digit = arr[i] - '0';
                    digit = (digit + 1) % 10;

                    arr[i] = (char) (digit + '0');

                    String next = new String(arr);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }

                    // DECREMENT
                    arr = curr.toCharArray();

                    digit = arr[i] - '0';
                    digit = (digit + 9) % 10;

                    arr[i] = (char) (digit + '0');

                    String prev = new String(arr);

                    if (!dead.contains(prev) && !visited.contains(prev)) {
                        visited.add(prev);
                        q.add(prev);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}