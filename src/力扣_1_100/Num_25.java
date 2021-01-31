package 力扣_1_100;

/**
 * Created by zxs666 on 2020/6/24.
 * K个一组翻转链表
 */
public class Num_25 {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode temp = list;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);

        ListNode anslist = new Num_25().reverseKGroup2(list, 3);
        while (anslist != null) {
            System.out.println(anslist.val + " ");
            anslist = anslist.next;
        }

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        //特殊情况直接返回
        if (k == 1)
            return head;
        //创建一个头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (true) {
            ListNode kNode = temp.next;
            //先判断是否有k个节点可以翻转，如果没有那么直接返回
            for (int i = 0; i < k; i++, kNode = kNode.next)
                if (kNode == null)
                    return pre.next;
            //进行翻转
            kNode = temp.next.next;
            ListNode end = temp.next;
            //头插法执行k-1次
            for (int i = 1; i < k; i++) {
                ListNode next = kNode.next;
                end.next = next;
                kNode.next = temp.next;
                temp.next = kNode;
                kNode = next;
            }
            for (int i = 0; i < k; i++)
                temp = temp.next;
        }

    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 0 || k == 1 || head == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;//
        while (true) {
            ListNode q = pre.next;
            //找k个节点,如果不足K个节点，那么返回
            for (int i = 0; i < k; i++, q = q.next)
                if (q == null)
                    return newHead.next;


            ListNode p = pre.next;
            //头插法，插K次
            for (int i = 0; i < k; i++) {
                ListNode next = p.next;
                p.next = pre.next;
                pre.next = p;
                p = next;
            }
            //pre往后移动K个位置,
            for (int i = 0; i < k; i++)
                pre = pre.next;

            //让pre指向q，也就是下一轮的第一个节点
            pre.next = q;
        }
    }
}
