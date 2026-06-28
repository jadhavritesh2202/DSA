class SpecialStack {
	Stack<Integer> stk1;
	Stack<Integer> min;
	int getMin;
	public SpecialStack() {
		// Define Stack
		stk1 = new Stack<>();
		min = new Stack<>();
		
		getMin = Integer.MAX_VALUE;
		
	}
	
	public void push(int x) {
		// Add an element to the top of Stack
		if (min.isEmpty() || min.peek() >= x) {
			min.push(x);
		}
		stk1.push(x);
	}
	
	public void pop() {
		// Remove the top element from the Stack
		if (stk1.isEmpty())
			return;
		int removed = stk1.pop();
		
		if (removed == min.peek()) {
			min.pop();
		}
	}
	
	public int peek() {
		// Returns top element of the Stack
		if (stk1.isEmpty())
			return - 1;
		return stk1.peek();
	}
	
	boolean isEmpty() {
		// Check if the stack is empty
		return stk1.isEmpty();
	}
	
	public int getMin() {
		// Finds minimum element of Stack
		if (min.isEmpty())
			return - 1;
		return min.peek();
	}
}
