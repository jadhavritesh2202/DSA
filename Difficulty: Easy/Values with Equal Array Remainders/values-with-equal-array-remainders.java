class Solution {
    public int sameMod(int[] arr) {
        // code here
        int gcdVal=0;
        
        for(int i=1;i<arr.length;i++){
            gcdVal=gcd(gcdVal,Math.abs(arr[0]-arr[i]));
        }
        if(gcdVal==0) return -1;
        int cnt=0;
        for(int i=1;i<=gcdVal;i++){
            if(gcdVal % i==0){
                cnt++;
            }
        }
        return cnt;
        
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}