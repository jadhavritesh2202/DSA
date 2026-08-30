class Solution {
    int n;
    int maxCnt;
    public int maxUniqueSplit(String s) {
         n=s.length();
        Set<String> set=new HashSet<>();
         solve(0,s,set,0);
         return maxCnt;
    }
    public void solve(int idx,String s,Set<String> set,int currCnt){
        if(idx>=s.length()){
            maxCnt=Math.max(maxCnt,currCnt);
            return;
        }

        for(int j=idx;j<s.length();j++){
            String str=s.substring(idx,j+1);
            if(!set.contains(str)){
                set.add(str);
                solve(j+1,s,set,currCnt+1);
                set.remove(str);
            }
        }
    }
}