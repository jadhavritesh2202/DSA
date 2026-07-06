class Solution {
    public int removeCoveredIntervals(int[][] arr) {
       Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int c=-1;
        int d=-1;
        int cnt=0;

        for(int i=0;i<arr.length;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            if(a>=c && b<=d){
                continue;
            }
            cnt++;
            c=a;
            d=b;

        }
        return cnt;
    }
}