package 力扣_1_100;

/**
 * Created by zxs666 on 2020/6/24.
 */
public class Num_24 {

    //链表节点定义
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }


    //非递归解法1
    public ListNode swapPairs(ListNode head) {
        //如果只有0个或者1个节点，那么直接返回
        if (head == null || head.next == null)
            return head;

        //保存后节点
        ListNode doubleNext = head.next.next;

        //定义返回头结点
        ListNode ansHead = head.next;
        ansHead.next = head;
        ListNode ansNext = ansHead.next;
        head = doubleNext;
        while (head != null) {
            //如果只有一个节点
            if (head.next == null) {
                ansNext.next = head;
                ansNext = ansNext.next;
                head = head.next;
            }
            //如果有两个节点
            else {
                //先保存后节点
                doubleNext = head.next.next;

                ansNext.next = head.next;
                ansNext.next.next = head;
                ansNext = ansNext.next.next;
                head = doubleNext;
            }
        }
        ansNext.next = null;
        return ansHead;
    }

    //非递归解法2，添加一个头结点
    public ListNode swapPairs2(ListNode head) {
        //创建一个头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;//记录头结点
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            first.next = second.next;
            temp.next = second;
            second.next = first;
            temp=first;
        }
        return pre.next;
    }

    //递归解法
    public ListNode swapPairs3(ListNode head) {
        //如果只有0个或者1个节点，那么直接返回
        if (head == null || head.next == null)
            return head;
        //下节点,交换之后，变成头结点返回
        ListNode next = head.next;
        //头结点，变成第二节点，头结点的后面应该是跟的下下节点。
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
