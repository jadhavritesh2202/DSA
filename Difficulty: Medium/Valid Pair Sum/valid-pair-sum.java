class Solution {
    static long ValidPair(int a[], int n) {
        // Your code goes here
        Arrays.sort(a);
        int l=0,r=n-1;
        long cnt=0;
        while(l<r){
            if(a[l]+a[r]>0){
                cnt+=r-l;
                r--;
            }else{
                l++;
            }
        }
        return cnt;
    }
}
