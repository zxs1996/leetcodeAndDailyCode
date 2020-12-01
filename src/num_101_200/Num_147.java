package num_101_200;

import java.util.List;

/**
 * Created by zxs666 on 2020/7/28.
 */
public class Num_147 {

    //归并排序,递归算法,先递归划分之后，再使用归并算法，归并可参考leetocde 22题
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        //再往下递归划分，得到两个有序链表
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        //将两个链表归并排序
        return mergeTwoLists(left, right);
    }

    //合并两个升序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l2;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode next = l1.next;
                l1.next = null;
                p.next = l1;
                l1 = next;
            } else {
                ListNode next = l2.next;
                l2.next = null;
                p.next = l2;
                l2 = next;
            }
            p = p.next;
        }
        if (l1 != null)
            p.next = l1;
        else
            p.next = l2;
        return res.next;
    }

}
