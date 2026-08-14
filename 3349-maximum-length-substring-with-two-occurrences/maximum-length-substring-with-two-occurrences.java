class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int[] freq=new int[26];
        int len=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<n){
            char ch=s.charAt(j);
            freq[ch-'a']++;
            if(freq[ch-'a']<=2){
                len=Math.max(len,j-i+1);

            }else{
                while(freq[ch-'a']>2 && i<j){
                      freq[s.charAt(i)-'a']--;
                      i++;
                }
            }
            j++;
        }
        return len;

    }
}