package 力扣_101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxs666 on 2020/7/23.
 * 克隆链表，跟思路跟前面的克隆图一样的，使用map,key存源节点 value存克隆节点
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Num_138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();//前面存源节点，后面存克隆节点
        Node cloneHead = new Node(head.val);//克隆头结点
        map.put(head, cloneHead);//放入map
        while (head != null) {
            //如果这个节点没有被克隆过
            if (!map.containsKey(head))
                map.put(head, new Node(head.val));
            //如果下节点存在
            if (head.next != null) {
                if (!map.containsKey(head.next))
                    map.put(head.next, new Node(head.next.val));
                map.get(head).next = map.get(head.next);
            }
            //如果随机节点存在
            if (head.random != null) {
                if (!map.containsKey(head.random))
                    map.put(head.random, new Node(head.random.val));
                map.get(head).random = map.get(head.random);
            }
            head = head.next;
        }
        return cloneHead;
    }
}
