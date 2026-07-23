class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        int lastIndex = 0;
        int[] hash=new int[n];
        hash[0]=0;
        for(int i=1;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && dp[j]+1 > dp[i]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
             if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();

        while (hash[lastIndex] != lastIndex) {
            lis.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }

        lis.add(arr[lastIndex]);

        Collections.reverse(lis);

        return lis;
        

    }
}