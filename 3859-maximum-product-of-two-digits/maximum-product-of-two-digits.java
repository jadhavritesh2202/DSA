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

        // String s = String.valueOf(n);
        // int maxProduct = 0;
        // int i = 0;
        // int j = 0;
        // int product = 1;
        // while (j < 2) {
        //     product *= (s.charAt(j) - '0');
        //     maxProduct = Math.max(maxProduct, product);
        //     j++;
        // }
        // while (j < s.length()) {
        //     int left = s.charAt(i) - '0';
        //     int right = s.charAt(j) - '0';

        //     // Only works safely if left != 0
        //     product = (product / left) * right;

        //     maxProduct = Math.max(maxProduct, product);

        //     i++;
        //     j++;
        // }

        return maxProduct;
    }
}