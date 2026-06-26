class Solution {
    public int[] minCosts(int[] cost) {
        int n=cost.length;
        
        for(int i=1;i<n;i++){
            cost[i]=Math.min(cost[i],cost[i-1]);
        }
        return cost;
    }
}