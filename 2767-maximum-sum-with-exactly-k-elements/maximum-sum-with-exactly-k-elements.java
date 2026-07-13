class Solution {
    public int maximizeSum(int[] nums, int k) {
        //   int n=nums.length;
        //   PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        //   for(int num:nums){
        //     pq.add(num);
        //   }
        //   int sum=0;
        //   int i=0;
        //   while(i<k){
        //      int val=pq.remove();
        //      sum+=val;
        //      pq.add(val+1);
        //      i++;
        //   }
        //   return sum;

        int ans = 0;
        int n = 0;

        for(int x: nums)
        {
            if(x> n) n=x;
        }

        while(k-- >0)
        {
            ans += n;
            n++;
        }

        return ans;
        
    }
}

    