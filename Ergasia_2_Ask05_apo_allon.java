import java.util.EmptyStackException;

public class MyStack {
    private int[] stackArray;
    private int maxSize;
    private int top;

    // Constructor
    public MyStack(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Invalid maxSize. Must be a positive integer.");
        }
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    // Method to push an element onto the stack
    public void push(int item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Cannot push element.");
        } else {
            top++;
            stackArray[top] = item;
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            return -1; // Επιστροφή -1 όταν η στοίβα είναι άδεια
        } else {
            int poppedItem = stackArray[top];
            top--;
            return poppedItem;
        }
    }

    // Method to check if the stack is full
    private boolean isFull() {
        return top == maxSize - 1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}