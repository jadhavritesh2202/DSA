class Solution {
    public static int gcd(int a, int b) {
        // code here
        
        // int gcd=0;
        // for(int i=Math.min(a,b);i>0;i--){
        //     if(a % i==0 && b % i==0){
        //         gcd=i;
        //         break;
        //     }
        // }
        // return gcd;
        
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
