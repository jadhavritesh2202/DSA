class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(k>=n) {
            swap(arr,0,n-1);
            return;
        }
        
        int i=0;
        while(i < n){
            int end=Math.min(i+(k-1),n-1);
            swap(arr,i,end);
            i=i+k;
        }
        
    }
    public void swap(int[] arr,int i,int j){
        int a=i;
        int b=j;
        while(a<b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
            a++;b--;
        }
    }
}