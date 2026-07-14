class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);

        int sum = 0;

        for (int getcoins = n - 2;
             getcoins > (n - 3) / 3;
             getcoins -= 2) {

            sum += piles[getcoins];
        }

        return sum;
    }
}