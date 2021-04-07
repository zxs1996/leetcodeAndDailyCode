package 力扣_101_200;

import org.junit.Test;

import java.lang.invoke.LambdaConversionException;
import java.util.HashMap;
import java.util.List;

/**
 * @author zxs666
 * @date 2021/3/19 21:19
 */
public class Num_146_2 {
    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));

        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        ;
    }
}

class LRUCache {


    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    int curSize = 0;//当前容量
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        headInsert(node);
        return node.value;
    }

    public void put(int key, int value) {

        Node newNode;
        //如果map包含了这个key
        if (map.containsKey(key)) {
            newNode = map.get(key);
            newNode.value = value;
            //将这个节点头插到head后面
            headInsert(newNode);
        }
        //不包含，有两种情况，直接插入和置换。
        else {
            newNode = new Node(key, value);
            map.put(key, newNode);
            //如果已经满了，删除最后一个node
            if (curSize == capacity) {
                Node removeNode = tail.pre;
                map.remove(removeNode.key);
                tail.pre = removeNode.pre;
                tail.pre.next = tail;
            }
            //否则没有满，curSize++
            else {
                curSize++;
            }
            //将newNode放到head后面
            newNode.next = head.next;
            newNode.pre = head;
            newNode.next.pre = newNode;
            head.next = newNode;

        }

    }

    //将node插入到head后面
    public void headInsert(Node node) {

        //将该节点断开
        node.next.pre = node.pre;
        node.pre.next = node.next;


        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}