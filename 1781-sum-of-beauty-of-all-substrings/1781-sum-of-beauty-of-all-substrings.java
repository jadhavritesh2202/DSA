class Solution {
    public int beautySum(String s) {

        int sum=0;
        char[] cs = s.toCharArray();
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[cs[j] - 'a']++;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}