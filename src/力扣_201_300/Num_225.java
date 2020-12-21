package 力扣_201_300;

import java.util.ArrayList;
import java.util.List;

public class Num_225 {


    class MyStack {

        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            list = new ArrayList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            list.add(0, x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return list.remove(0);
        }

        /**
         * Get the top element.
         */
        public int top() {
            return list.get(0);
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return list.size() == 0;
        }
    }
}
