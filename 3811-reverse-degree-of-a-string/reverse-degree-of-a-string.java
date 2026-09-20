class Solution {
    public int reverseDegree(String s) {
         int sum=0;
         for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                int x=(ch-'a');
                int product=(i+1)*(26-x);
                sum+=product;
         }
         return sum;

    }
}