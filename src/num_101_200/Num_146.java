package num_101_200;

import javafx.scene.shape.VLineTo;
import org.junit.Test;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * Created by zxs666 on 2020/7/28.
 */
public class Num_146 {

    @Test
    public void test() {
        LRUCache3 cache = new LRUCache3(3);
        System.out.println(cache.get(1));
        ;
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(1));
        ;
        System.out.println(cache.get(2));
        ;
        System.out.println(cache.get(3));
        ;
        System.out.println(cache.get(4));
        ;
    }


    //使用单链表实现
    class LRUCache {
        class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Node head = new Node(0, 0);//创建头结点
        int usedNum;
        int maxSize;

        public LRUCache(int capacity) {
            maxSize = capacity;
            usedNum = 0;
        }

        public int get(int key) {
            Node pre = head;
            Node p = head.next;
            for (int i = 1; i <= usedNum; pre = pre.next, p = p.next, i++) {
                //如果访问到，那么放到头部去
                if (p.key == key) {
                    pre.next = p.next;
                    p.next = head.next;
                    head.next = p;
                    return p.value;
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            Node pre = head;
            Node p = head.next;
            for (int i = 1; i <= usedNum; pre = pre.next, p = p.next, i++) {
                //如果访问到，那么放到头部去
                if (p.key == key) {
                    p.value = value;
                    pre.next = p.next;
                    p.next = head.next;
                    head.next = p;
                    return;
                }
            }
            //否则没有在cache里面找到
            //如果到达最大容量
            if (usedNum == maxSize) {
                pre.next = null;//删除最后一个p
            } else
                usedNum++;//usedNum++
            Node put = new Node(key, value);
            put.next = head.next;
            head.next = put;
        }
    }


    //使用linkedhashMap linkedHashMap
    class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override //是否移除最早元素
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

    }

    //使用hashMap+双链表实现
    // map key存关键值，value存node节点，每次根据key直接定位node，将node放到链表头部
    class LRUCache3 {
        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private int usedSize;
        //维护双向链表
        private Node head;
        private Node rear;
        private Map<Integer, Node> map;

        public LRUCache3(int capacity) {
            this.capacity = capacity;
            usedSize = 0;
            head = new Node(0, 0);
            rear = new Node(0, 0);
            head.next = rear;
            rear.pre = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            //如果不包含key
            if (!map.containsKey(key))
                return -1;
            Node node = map.get(key);
            //将node从链表上取出
            node.pre.next = node.next;
            node.next.pre = node.pre;
            //头插到最前面
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
            return node.value;
        }

        public void put(int key, int value) {
            Node node;
            //如果包含这个节点
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                //将node从链表上取出
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            //不包含这个节点
            else {
                node = new Node(key, value);
                map.put(key, node);
                //如果容量已满，那么删除最后一个节点
                if (usedSize == capacity) {
                    map.remove(rear.pre.key);//移除
                    rear.pre = rear.pre.pre;
                    rear.pre.next = rear;

                } else//
                    usedSize++;
            }
            //将node插入到头部去
            //头插到最前面
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
        }
    }
}
