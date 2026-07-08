class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        boolean armstrNo = false;
        int num = n;
        
        double sum = 0;
        
        while(num>0)
        {
            int digit = num%10;
            
            int cube = digit*digit*digit;
            
            sum += cube;
            
            num = num/10;
        }
        
        if(n==sum)
        {
            armstrNo = true;
        }
        
        return armstrNo;
    }
}

