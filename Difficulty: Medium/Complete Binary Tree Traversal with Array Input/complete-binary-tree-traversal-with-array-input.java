class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
       int idx=0;
       int levelSize=1;
       while(idx < n){
           
           ArrayList<Integer> list=new ArrayList<>();
           for(int i=0;i<levelSize && idx<n ;i++){
               pq.add(arr[idx]);
               idx++;
           }
           
           //store into list
           while(!pq.isEmpty()){
               list.add(pq.remove());
           }
           res.add(list);
           levelSize*=2;
       }
       return res;
    }
}