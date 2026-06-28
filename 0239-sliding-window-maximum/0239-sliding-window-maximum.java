class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;

        Deque<Integer> deque=new ArrayDeque<>();
        int[] res=new int[n-k+1];

        for(int i=0;i<k;i++){

            while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

        }

        res[0]=nums[deque.peekFirst()];
        //from k to last
        for(int i=k;i<n;i++){
            if(deque.peekFirst()<= i-k){
                deque.removeFirst();
            }

             while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            res[i-k+1]=nums[deque.peekFirst()];

        }
        return res;
    }
}