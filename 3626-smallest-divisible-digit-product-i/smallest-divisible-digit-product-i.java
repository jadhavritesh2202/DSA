class Solution {
    public int smallestNumber(int n, int t) {
        
        int num=n;
        while(true){
            if(helper(num)%t==0){
                break;
            }
            num++;
        }
        return num;
    }
    public int helper(int num){
        int product=1;
        int x=num;
        while(x>0){
            int rem=x%10;
             product*=rem;
            x=x/10;

        }
        return product;
    }
}