class Solution {
    public int earliestTime(int[][] tasks) {
        int n=tasks.length;
        int m=tasks[0].length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
             
                int finish = tasks[i][0] + tasks[i][1];
                min=Math.min(min,finish);
         }
        return min;
    }
}