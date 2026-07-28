class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int[] freq=new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        char[] arr=new char[n];
        int left=0;
        int right=n-1;
        for(int i=0;i<26;i++){
            while(freq[i]>=2){
              arr[left++]=(char)('a'+i);
              arr[right--]=(char)('a'+i);
              freq[i]-=2;
            }
        }

        //if odd nmber
        for(int i=0;i<26;i++){
            if(freq[i]==1){
                arr[n/2]=(char)('a'+i);
                break;
            }
        }
        return new String(arr);
    }
}