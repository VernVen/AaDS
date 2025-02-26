import java.util.Stack;

class MyQueue1 {
    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outputStack = new Stack<>();
    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }

    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
