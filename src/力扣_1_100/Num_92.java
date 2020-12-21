package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/17.
 */
public class Num_92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);

        Num_92 solution = new Num_92();
        //solution.show(head);
        solution.reverseBetween(head, 2, 4);
        solution.show(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode newHead = new ListNode(0);//创建头结点
        newHead.next = head;
        ListNode p = newHead.next;
        ListNode start = newHead;
        //找第m-1个节点
        for (int i = 0; i < m - 1; i++) {
            start = p;
            p = p.next;
        }
        ListNode pre = p;//p节点,第m节点
        p = p.next;
        //执行头插，做n-m次
        for (int i = 0; i < n - m; i++) {
            //将p的next保存，将p断开
            ListNode next = p.next;
            pre.next = p.next;
            //将p插入到start后面
            p.next = start.next;
            start.next = p;
            //p指向next
            p = next;
            //如果start==pre，那么pre往后移动一位
           /* if (start == pre)
                pre = pre.next;*/
        }
        return newHead.next;
    }

    public void show(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "  ");
            p = p.next;
        }

        System.out.println();
    }

}
