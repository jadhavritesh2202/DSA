class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int cnt=0;
        for(int num:nums){
            cnt+=max-num;
        }
        return cnt;
    }
}