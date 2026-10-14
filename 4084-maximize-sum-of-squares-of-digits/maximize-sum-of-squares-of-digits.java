class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num || sum==0) return "";

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<num;i++){
            int rem=Math.min(sum,9);
            sb.append(rem);
            sum=sum-rem;
        }
        return sb.toString();

    }
}