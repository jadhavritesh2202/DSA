class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int n1=target.length;
        int j=0;
        for(int i=1;i<=n && j < n1;i++){
             res.add("Push");
            if(i == target[j]){
                j++;
            }else{
                res.add("Pop");
            }
        }
        return res;
    }
}