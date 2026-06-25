class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        
        ArrayList<Integer> list=new ArrayList<>();
        if(n>9) return list;
        if(n==1){
            for(int i=0;i<=9;i++){
               list.add(i);
            }
            return list;
        }
        
        backtrack(list,new ArrayList<>(),1,n);
        return list;
        
        
    }
    public static void backtrack(ArrayList<Integer> res,ArrayList<Integer> list,int start,int n){
      
        //base case
        if(list.size()==n){
            int num=0;
            for(int d:list){
                num=num*10+d;
            }
            res.add(num);
            return;
        }
        for(int i=start;i<=9;i++){
            list.add(i);
            backtrack(res,list,i+1,n);
            list.remove(list.size()-1);
        }
    }
}
