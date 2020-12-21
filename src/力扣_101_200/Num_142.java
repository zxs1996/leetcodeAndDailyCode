package 力扣_101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxs666 on 2020/7/23.
 */
public class Num_142 {
    //双指针不适用额外空间
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        //至少有两个节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        //找入环点
        ListNode fast = newHead.next.next;
        ListNode slow = newHead.next;
        while (fast != slow) {
            //如果有null，说明无环，返回null
            if (fast == null || fast.next == null || fast.next.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        //当两个指针相遇时，慢指针走了nb，a+nb是入口节点
        //定义一个指针p从头开始，让p和slow一直走，当他们相遇时
        //说明走了a长度，这时候就是a+nb，也就是入环处
        ListNode p = newHead;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }


    //使用额外空间
    public ListNode detectCycle2(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p))
                return p;
            map.put(p, 1);
            p = p.next;
        }
        return null;
    }
}
