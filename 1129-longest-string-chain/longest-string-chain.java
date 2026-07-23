class Solution {
    public boolean Compare(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        if((n-m)!=1) return false;

        int i=0;
        int j=0;
        while(i<n){
            if(j<m && s1.charAt(i)==s2.charAt(j)){
                i++;j++;
            }else{
                i++;
            }
        }
        if(i==n && j==m) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(Compare(words[i],words[j]) && dp[j]+1 > dp[i]){
                    dp[i]=1+dp[j];

                }
            }
        }
        for(int num:dp){
            max=Math.max(max,num);
        }
        return max;
    }
}