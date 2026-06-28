class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> deque=new ArrayDeque<>();
        
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && arr[deque.peekLast()]<=arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        list.add(arr[deque.peekFirst()]);
        
        for(int i=k;i<n;i++){
            //first remove from window
              if(deque.peekFirst()<= i-k){
                deque.removeFirst();
            }

             while(!deque.isEmpty() && arr[deque.peekLast()]<= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            list.add(arr[deque.peekFirst()]);
        }
        return list;
        
    }
}