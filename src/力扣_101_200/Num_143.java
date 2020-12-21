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

        //2、找链表中间节点,这里需要处理一下中间节点的位置，如果
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
}
