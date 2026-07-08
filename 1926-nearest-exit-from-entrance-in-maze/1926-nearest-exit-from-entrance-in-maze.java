class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Up, Left, Right, Down
    int[] dr = { -1, 0, 0, 1 };
    int[] dc = { 0, -1, 1, 0 };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int steps = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0], entrance[1]));
         maze[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Pair p = q.remove();
                int r = p.first;
                int c = p.second;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                   
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        // Process cell (nr, nc)
                        if(maze[nr][nc]=='+') continue;

                        if(nr==0 || nr==m-1 || nc==0 || nc==n-1) return steps;
                         
                         maze[nr][nc]='+';
                         q.add(new Pair(nr,nc));




                    }
                }
            }

        }
        return -1;
    }
}