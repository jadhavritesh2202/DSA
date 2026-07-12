class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
       HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map.containsKey(i-j)){
                   map.get(i - j).add(mat[i][j]);
                }else{
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(mat[i][j]);
                    map.put(i - j, pq);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=map.get(i-j).poll();
            }
        }
        return mat;


    }
}