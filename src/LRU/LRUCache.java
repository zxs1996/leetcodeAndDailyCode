package LRU;

import javafx.scene.shape.VLineTo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2021/1/29 18:03
 * 通过HashMap+双链表 来实现O(1)时间复杂度的LRU缓存
 */
public class LRUCache {

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


    Map<Integer, Node> map;
    int capacity;
    int used;
    Node head;
    Node rear;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        used = 0;
        head = new Node(0, 0);
        rear = new Node(0, 0);
        head.next = rear;
        rear.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        //将该节点头插到head后面
        headInsert(node);
        return node.value;

    }

    public void put(int key, int value) {

        Node node;
        //1、如果这个key已经存在了，那么修改它的值
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            //将这个节点头插到head后面
            headInsert(node);
        } else {

            //判断还有没有空间，需不需要删除node

            //如果没有空间了，那么把最后一个节点的值替换
            if (used == capacity) {
                node = rear.pre;
                //维护map
                map.remove(node.key);
                map.put(key, node);
                node.key = key;
                node.value = value;
                //将这个节点头插到head后面
                headInsert(node);
            } else {
                used++;
                node = new Node(key, value);
                //注意要维护map
                map.put(key, node);
                //将这个孤立节点直接插到head后面,注意这里不要调用headInsert，因为那个方法针对非孤立节点
                node.next = head.next;
                node.next.pre = node;
                node.pre = head;
                head.next = node;
            }
        }


    }


    //将node节点头插到head后面
    public void headInsert(Node node) {
        //1、先将该节点取下来
        node.next.pre = node.pre;
        node.pre.next = node.next;

        //2、将该节点头插到head后
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}
