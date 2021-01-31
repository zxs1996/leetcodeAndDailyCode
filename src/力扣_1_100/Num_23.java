package 力扣_1_100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zxs666 on 2020/6/24.
 */
public class Num_23 {

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


    /**
     * 朴素算法，每次求K个链表中的最小值，时间复杂度O(N*K)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode next = null;
        ListNode head = next;
        while (true) {
            int min = Integer.MAX_VALUE;
            int location = -1;
            for (int i = 0; i < lists.length; i++)
                if (lists[i] != null && lists[i].val <= min) {
                    min = lists[i].val;
                    location = i;
                }
            //如果遍历所有链表都找不到比min小的数，说明链表全为空,返回
            if (location == -1)
                return head;
            //把节点取下来
            ListNode currMinNode = lists[location];
            lists[location] = currMinNode.next;
            if (head == null) {
                head = currMinNode;
                next = head;
            } else {
                next.next = currMinNode;
                next = next.next;
            }

        }
    }


    /**
     * 使用优先队列来对K个链表排序
     * 每次入队出队时间复杂度为logK
     * 总的时间复杂度为O(N*logK)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            ListNode next = cur.next;
            cur.next = null;
            p.next = cur;
            p = p.next;
            if (next != null)
                pq.add(next);
        }
        return head.next;
    }


    /**
     * 二分合并，迭代
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {

        List<ListNode> arrayList1 = new ArrayList<>();
        List<ListNode> arrayList2 = new ArrayList<>();
        for (ListNode node : lists)
            arrayList1.add(node);
        while (arrayList1.size() > 1) {
            for (int i = 0; i < arrayList1.size(); i += 2) {
                if (i == arrayList1.size() - 1) {
                    arrayList2.add(arrayList1.get(i));
                } else
                    arrayList2.add(mergeTwoList(arrayList1.get(i), arrayList1.get(i + 1)));
            }
            arrayList1 = new ArrayList<>(arrayList2);
            arrayList2.clear();
        }

        return arrayList1.get(0);
    }

    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            ListNode cur;
            if (l1.val < l2.val) {
                cur = l1;
                l1 = l1.next;
            } else {
                cur = l2;
                l2 = l2.next;

            }
            cur.next = null;
            p.next = cur;
            p = p.next;
        }

        if (l1 == null)
            p.next = l2;
        else
            p.next = l1;
        return head.next;
    }
}
