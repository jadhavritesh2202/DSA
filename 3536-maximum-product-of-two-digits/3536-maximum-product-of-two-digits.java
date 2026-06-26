class Solution {
    public int maxProduct(int n) {
        int[] arr=new int[10];
        int num=n;
        int k=0;
        while(num>0){
            int rem=num % 10;
              arr[k++]=rem;
              num=num/10;
        }
        
        int maxProduct=0;
        for(int i=0;i<k;i++){
            for(int j=i+1;j<k;j++){
               maxProduct=Math.max(arr[i]*arr[j],maxProduct);
            }
        }
        return maxProduct;
    }
}