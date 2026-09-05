class Solution {
    int factorial(int n) {
        // code here
        int res=1;
        for(int i=n;i>0;i--){
            res*=i;
        }
        return res;
    }
}
