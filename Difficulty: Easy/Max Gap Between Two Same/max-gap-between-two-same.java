class Solution {
    public int maxCharGap(String s) {
        // code here
        int n=s.length();
        int[] first=new int[26];
         for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }
        int res = -1;
        
        for(int i=0;i<n;i++){
              char ch=s.charAt(i);
              if(first[ch-'a']!=-1){
                  res=Math.max(res,i-(first[ch-'a'])-1);
              }else{
              first[ch-'a']=i;
              }
             
        }
        return res;
        
    }
};