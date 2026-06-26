class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for(int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[curr]) {
                stack.pop();
                curr++;
            }
        }
        return stack.isEmpty();
    }
}