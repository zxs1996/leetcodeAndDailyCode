package 力扣_201_300;

import java.util.Iterator;

/**
 * @author zxs666
 * @date 2020/9/29 13:20
 */
public class Num_284 {
    class PeekingIterator implements Iterator<Integer> {
        public Iterator<Integer> iterator;
        public Integer cur;//缓存当前元素

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            cur = null;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (cur != null)
                return cur;
            cur = iterator.next();
            return cur;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            //如果缓存值不为空，那么直接返回，并且把缓存值设置为null，这样下次就会去获取一个新的cur
            if (cur != null) {
                Integer res = cur;//将当前元素保存起来
                cur = null;//cur设置为null
                return res;//返回res
            }
            //如果缓存值为空，说明这个值没有被peek过，那么直接iterator.next()即可
            return iterator.next();


        }

        @Override
        public boolean hasNext() {
            return cur != null || iterator.hasNext();
        }
    }
}
