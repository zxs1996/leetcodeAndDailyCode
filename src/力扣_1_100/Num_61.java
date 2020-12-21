package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/9.
 */
public class Num_61 {
    public ListNode rotateRight(ListNode head, int k) {
        //先遍历一次，记录长度。
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        if(n==0)
            return head;
        k = k % n;
        if (k == 0)
            return head;
        //找到中间n-k节点，然后断开
        p = head;
        ListNode beforeHead = head;
        for (int i = 0; i < n - k - 1; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        p.next = null;//断开
        head = q;
        while (q.next != null)
            q = q.next;
        q.next = beforeHead;
        return head;
    }
}
