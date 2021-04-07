package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/23.
 */
public class Num_143 {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode p = head;
        //1、计算链表长度
        int n = 0;
        for (; p != null; p = p.next, n++) ;
        p = head;

        //2、找链表中间节点,这里需要处理一下中间节点的位置，保证前半段长于后半段
        for (int i = 1; i < (n + 1) / 2; i++)
            p = p.next;
        ListNode head2 = p.next;
        p.next = null;
        //将后半部分链表逆序
        ListNode headNode = new ListNode(0);
        ListNode q = head2;
        while (q != null) {
            ListNode next = q.next;
            q.next = headNode.next;
            headNode.next = q;
            q = next;
        }
        p = head;
        q = headNode.next;
        while (p != null && q != null) {
            ListNode next = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = next;
        }
    }


    public void reorderList2(ListNode head) {
        if (head == null)
            return;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        ListNode mid = head;
        for (int i = 0; i < (n + 1) / 2 - 1; i++)
            mid = mid.next;
        ListNode head2 = mid.next;
        mid.next = null;

        //让后半段逆序
        ListNode q = head2;
        head2 = new ListNode(0);

        while (q != null) {
            ListNode next = q.next;
            q.next = head2.next;
            head2.next = q;
            q = next;
        }

        p = head;
        q = head2.next;
        while (p != null) {
            ListNode next = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = next;
        }
    }
}
