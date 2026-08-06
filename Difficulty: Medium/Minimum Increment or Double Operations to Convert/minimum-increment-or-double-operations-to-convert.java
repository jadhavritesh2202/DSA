class Solution {
    public int countMinOperations(int arr[]) {
        // code here
        int decCnt=0;
        int maxDev=0;
        for(int num:arr){
            int divideCnt=0;
            while(num>0){
                if(num%2==1){
                    //odd
                    decCnt++;
                    num--;
                }else{
                    divideCnt++;
                    num=num/2;
                }
            }
            maxDev=Math.max(maxDev,divideCnt);
            
        }
        return maxDev+decCnt;
    }
}