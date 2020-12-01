package num_1_100;

import java.util.List;
import java.util.Scanner;

/**
 * Created by zxs666 on 2020/7/15.
 * 分割链表
 */
public class Num_86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(2);
        Num_86 solution = new Num_86();
        solution.show(head);
        Scanner sc = new Scanner(System.in);
        //sc.next();
        ListNode newHead = solution.partition(head, 2);
        solution.show(newHead);
    }

    //思路，设置一个trail节点，每个小于x的元素，查到trail后面
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead.next;
        ListNode pre = newHead;//前一个节点
        ListNode trail = newHead;//记录当前最后一个小于的节点，后续每一个小于x的节点都查到他后面
        while (p != null) {
            //如果p.val小于x，那么取下来插入到pre之后
            if (p.val < x) {
                System.out.println(p.val + " -移动pre-  " + pre.val);
                //将这个节点取下来,保留p的后节点
                ListNode next = p.next;
                ListNode temp = p;
                pre.next = p.next;
                //插入到taril之后
                temp.next = trail.next;
                trail.next = temp;
                //当前一个节点和尾结点相同时，pre也要移动
                if (pre == trail)
                    pre = pre.next;
                p = next;
                trail = trail.next;

            }
            //如果大于等于，那么往后移动
            else {
                pre = p;
                p = p.next;
            }
            show(newHead);
        }
        return newHead.next;
    }

    //思路2，开辟两个链表，一个是小于x的元素，一个是大于x的元素。
    public ListNode partition2(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = next;
        }

        p1.next = l2.next;
        return l1.next;
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
