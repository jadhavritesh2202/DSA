class Solution {
   
    public static int[] lcmAndGcd(int a, int b) {
        // code here
       int[] ans=new int[2];
        ans[1]=gcd(a,b);
        
        ans[0]=lcm(a,b);
        return ans;
    }
    public static int gcd(int a,int b){
        while(b!=0){
                   int temp=b;
                   b=a%b;
                   a=temp;
               }
             return a;
    }
    public static int lcm(int a,int b){
         return (a/gcd(a,b))*b;
    }
    
}