package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxs666
 * @date 2021/3/12 16:17
 */
public class Num_35 {

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

    public Node copyRandomList(Node head) {
        Map<Node, List<Node>> map = new HashMap();
        Map<Node, Node> pairMap = new HashMap<>();
        Node newHead = new Node(0);
        Node pre = newHead;
        while (head != null) {
            Node random = head.random;
            Node newNode = new Node(head.val);
            pre.next = newNode;
            pairMap.put(head, newNode);
            //random如果在前面
            if (pairMap.containsKey(random)) {
                newNode.random = pairMap.get(random);
            }

            //random在后面
            else {
                List<Node> list;
                if (map.containsKey(random))
                    list = map.get(random);
                else
                    list = new ArrayList();

                list.add(newNode);
                map.put(random, list);
            }


            if (map.containsKey(head)) {
                List<Node> temp = map.get(head);
                for (Node node1 : temp)
                    node1.random = newNode;
            }
            head = head.next;
            pre = pre.next;
        }
        return newHead.next;
    }
}
