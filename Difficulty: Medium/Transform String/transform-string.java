class Solution {
    int transform(String s1, String s2) {
        // code here
         int n=s1.length();
         int m=s2.length();
         if(n!=m) return -1;
        int[] freq = new int[128];

        for (char ch : s1.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : s2.toCharArray()) {
            freq[ch]--;
        }
        
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                return -1;
            }
        }
         int i=n-1;
         int j=m-1;
         int cnt=0;
         while(i>=0 && j>=0){
             if(s1.charAt(i)==s2.charAt(j)){
                 i--;
                 j--;
             }else{
                 i--;
                 cnt++;
             }
         }
         return cnt;
    }
}