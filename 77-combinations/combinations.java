class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(1,k,n,list,res);
        return res;
    }
    public void helper(int start,int k,int n,List<Integer> list, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(start>n) return;

        list.add(start);
        helper(start+1,k-1,n,list,res);
        list.remove(list.size()-1);
        helper(start+1,k,n,list,res);
    }
}