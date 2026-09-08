class Solution {
    public int countCommas(int n) {
        int cnt=0;
        int num=n;
        while(num>0){
            num=num/10;
            cnt++;
        }
        if(cnt<4) return 0;
        return Math.abs(1000-n)+1;
    }
}