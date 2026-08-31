class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int pos = 2;

        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;

        while (next != null) {

            // Critical point
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    // First critical point
                    first = pos;
                } else {
                    // Distance from previous critical point
                    minDist = Math.min(minDist, pos - last);
                }

                last = pos;
            }

            prev = curr;
            curr = next;
            next = next.next;
            pos++;
        }

        // Less than 2 critical points
        if (first == -1 || first == last) {
            return ans;
        }

        ans[0] = minDist;
        ans[1] = last - first;

        return ans;
    }
}