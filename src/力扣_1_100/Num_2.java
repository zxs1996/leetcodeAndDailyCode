package 力扣_1_100;

/**
 * @author zxs666
 * @date 2021/1/29 15:39
 */
public class Num_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        ListNode p = l1, q = l2;
        while (p != null) {
            n1++;
            p = p.next;
        }
        while (q != null) {
            n2++;
            q = q.next;
        }

        //如果l1长度小于l2，那么交换，保证l1是较长的链表
        if (n1 < n2) {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        int carry = 0;
        p = l1;
        q = l2;
        ListNode pre = null;//记录前一个，有可能进位
        //两个链表做累加
        while (q != null) {
            p.val += q.val + carry;
            carry = p.val / 10;
            p.val = p.val % 10;
            pre = p;
            p = p.next;
            q = q.next;
        }
        //较短链表已经加完了，处理进位
        while (carry != 0 && p != null) {
            p.val += carry;
            carry = p.val / 10;
            p.val = p.val % 10;
            pre = p;
            p = p.next;
        }
        if (p == null && carry == 1)
            pre.next = new ListNode(1);
        return l1;
    }
}
