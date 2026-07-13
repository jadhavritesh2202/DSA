class Solution {
    public int maximizeSum(int[] nums, int k) {
          int n=nums.length;
          PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
          for(int num:nums){
            pq.add(num);
          }
          int sum=0;
          int i=0;
          while(i<k){
             int val=pq.remove();
             sum+=val;
             pq.add(val+1);
             i++;
          }
          return sum;

    }
}