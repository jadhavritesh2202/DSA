class Solution {
    public int thirdLargest(List<Integer> arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.offer(num);

            if (pq.size() > 3) {
                pq.poll();
            }
        }

        return pq.size() < 3 ? -1 : pq.peek();
    }
}