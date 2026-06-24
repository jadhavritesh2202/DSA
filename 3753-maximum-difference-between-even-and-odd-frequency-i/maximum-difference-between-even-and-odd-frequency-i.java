class Solution {
    public int maxDifference(String s) {
        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        int odd=0;
        int even=Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++){
            if (freq[i] == 0) continue;

            if(freq[i]%2!=0){
                odd=Math.max(odd,freq[i]);
            }else{
                even=Math.min(even,freq[i]);
            }
        }
        return odd-even;
    }
}