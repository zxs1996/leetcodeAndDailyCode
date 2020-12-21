package 力扣_201_300;

/**
 * Created by zxs666 on 2020/8/1.
 */
public class Num_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = head;
        while (p != null) {
            if (p.val == val){
                ListNode next=p.next;
                pre.next = p.next;
                p.next=null;
                p = next;
            }
            else{
                pre=p;
                p=p.next;
            }
        }
        return newHead.next;
    }
}
