package 力扣_301_400;

/**
 * @author zxs666
 * @date 2020/11/13 18:59
 */
public class Num_328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode p = oddHead, q = evenHead;
        boolean flag = true;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (flag) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            flag = !flag;
            head = next;
        }
        p.next=evenHead.next;
        return oddHead.next;
    }
}
