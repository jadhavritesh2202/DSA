class Solution {
  
    static int countWays(int n) {
        // add your code here
        
        return solve(n);
        
    }
    static int solve(int idx){
         if(idx<0) return 0;
        if(idx==0) {
            
            return 1;
        }
    return countWays(idx-1) + countWays(idx-2) + countWays(idx-3);
    
    }
}
