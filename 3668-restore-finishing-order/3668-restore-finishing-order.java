class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n=friends.length;
        Set<Integer> set=new HashSet<>();
        for(int num:friends){
            set.add(num);
        }
        int[] arr=new int[n];
         int k=0;
        for(int i=0;i<order.length;i++){
            if(set.contains(order[i])){
                arr[k++]=order[i];
            }
        }
        return arr;

    }
}