package jianzhiOffer;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/11 16:17
 */
public class Num_30 {
    class MinStack {

        Stack<Integer> stack1;//存放栈数据
        Stack<Integer> stack2;//存放最小值

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        //如果当前值小于等于stack2栈顶值，那么该元素放入stack2
        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || stack2.peek() >= x)
                stack2.push(x);
        }

        //如果出栈元素等于stack2栈顶元素，那么stack2出栈
        public void pop() {
            int res = stack1.pop();
            if (res == stack2.peek())
                stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
