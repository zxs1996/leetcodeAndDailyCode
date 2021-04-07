package LRU;


import java.util.*;

/**
 * @author zxs666
 * @date 2021/4/4 23:51
 */
public class LRU2<K, V> {

    int size = 0;
    int capacity;

    private class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }


    Node head;
    Node tail;

    Map<K, Node> map;


    public LRU2() {
    }

    public LRU2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = head;
        head.next = tail;
        tail.pre = head;
    }


    public V get(K key) {
        //如果不包含，那么直接返回null
        if (!map.containsKey(key))
            return null;
        //将这个点拿出来放到头部去
        Node node = map.get(key);
        //维护node的前后
        node.pre.next=node.next;
        node.next.pre=node.pre;

        headInsert(node);
        return (V) node.value;
    }

    public void put(K key, V value) {

        //如果包含这个元素,那么更新他的值，然后调用一次get方法，会把他放到前面去。
        if (map.containsKey(key)) {
            map.get(key).value = value;
            get(key);//调用一次get方法，把他放到前面去
            return;
        }
        //否则创建新元素
        Node newNode;
        //如果满了，修改最后一个node的key和val
        if (size == capacity) {
            newNode = tail;
            //从map移除
            map.remove(newNode.key);
            //修改这个node的key和value
            newNode.key = key;
            newNode.value = value;


            //将这个元素从后面断开
            tail.pre.next = null;
            tail = tail.pre;
        } else {
            size++;
            newNode = new Node(key, value);
        }

        map.put(key, newNode);
        headInsert(newNode);
    }

    /**
     * 将一个节点头插到head后
     *
     * @param node
     */
    public void headInsert(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public static void main(String[] args) {
        LRU2<Integer, Integer> lru2 = new LRU2<>(3);
        for (int i = 0; i < 5; i++)
            lru2.put(i + 1, i + 2);
        lru2.put(3, 303);
        for (int i = 2; i < 5; i++)
            System.out.println(lru2.get(i + 1));
    }


}
