class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=9;i++){
            if(i<=n){
            dfs(i,n,list);
            }
        }
        return list;
    }
    public void dfs(int curr,int n,List<Integer> list){
        list.add(curr);

        for(int i=0;i<=9;i++){
            int next=curr*10+i;
            if(next>n) break;

            dfs(next,n,list);
        }
    }
}