package num_101_200;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/28.
 */
public class Num_155 {

    class MinStack {
        Deque<Integer> list;
        Map<Integer, Integer> map;//用treeMap记录最小值

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayDeque();
            map = new TreeMap<>();
        }

        public void push(int x) {
            list.add(x);
            if (map.containsKey(x)) {
                map.replace(x, map.get(x) + 1);
            } else
                map.put(x, 1);
        }

        public void pop() {
            int res = list.removeLast();
            int count = map.get(res);
            if (count == 1)
                map.remove(res);
            else
                map.replace(res, count - 1);
        }

        public int top() {
            return list.getLast();
        }

        public int getMin() {
            for (Integer key : map.keySet())
                return key;
            return 0;
        }
    }
}
