class Solution {
    public int beautySum(String s) {
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                sum+=helper(s.substring(i, j + 1));
            }
        }
        return sum;
    }
    public int helper(String s){
        int[] freq=new int[26];
        
        for(char ch:s.toCharArray()){
              freq[ch-'a']++;
        }
        int max=0;
        int min=Integer.MAX_VALUE;
       for(int f:freq){
        if(f>0){
             max = Math.max(max, f);
            min = Math.min(min, f);
        }
       }
        return max-min;
    }

}