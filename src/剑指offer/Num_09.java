package 剑指offer;

import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/11/14 22:05
 */
public class Num_09 {

    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();//放元素的
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty())
                return -1;

            swap(stack1,stack2);
            int res=stack2.pop();
            swap(stack2,stack1);
            return res;
        }

        //将a的数据全部放入b
        public void swap(Stack a, Stack b) {
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
    }
}
