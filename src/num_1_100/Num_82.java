package num_1_100;

import java.util.List;

/**
 * Created by zxs666 on 2020/7/15.
 */
public class Num_82 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        //创建一个头结点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = pre.next;
        Integer deleteNum = null;
        while (p != null) {
            //如果deleteNum不为空
            if (deleteNum != null) {
                //如果p元素和被删除元素相等，那么删除，p往后移动
                if (deleteNum == p.val) {
                    pre.next = p.next;
                    p = pre.next;
                }
                //p元素和被删除元素不等
                else {
                    //如果下一个元素仍然是重复元素，那么更新deleteNum
                    if (p.next != null && p.next.val == p.val)
                        deleteNum = p.val;
                    else {
                        deleteNum = null;
                        pre = pre.next;
                        p = p.next;
                    }
                }
            }
            //如果deleteNum为空
            else {
                //满足删除条件
                if (p.next != null && p.next.val == p.val)
                    deleteNum = p.next.val;
                    //不满足，往后移动
                else {
                    pre = pre.next;
                    p = p.next;
                }

            }
        }
        return newHead.next;
    }
}
