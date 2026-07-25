class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        //base case if(idx==n) --> cap and buy van be anything
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[n][buy][cap] = 0;
            }
        }
        //base case if(cap==0) -> idx and buy can be anything
        for (int idx = 0; idx <= n; idx++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[idx][buy][0] = 0;
            }
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy==1) {
                        //for buy
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap], dp[idx + 1][1][cap]);
                    } else {
                        //for sell
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap-1], dp[idx + 1][0][cap]);

                    }
                }
            }
        }
        return dp[0][1][2];
    }
}