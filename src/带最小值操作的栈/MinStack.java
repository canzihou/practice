package 带最小值操作的栈;

import java.util.Stack;

public class MinStack {

    Stack<Integer> m_stack = new Stack<>();
    Stack<Integer> d_stack = new Stack<>();

    public MinStack() {
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        if (m_stack.empty() || number <= m_stack.peek()) {
            m_stack.push(number);
        }
        d_stack.push(number);
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int pop() {
        if (d_stack.peek().equals(m_stack.peek())) {
            m_stack.pop();
        }
        return d_stack.pop();
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int min() {
        return m_stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
    }
}
