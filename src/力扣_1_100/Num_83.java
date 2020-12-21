package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/14.
 */
public class Num_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if (p == null)
            return head;
        while (p.next != null) {
            if (p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;


    }
}
