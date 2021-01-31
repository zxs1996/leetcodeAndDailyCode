package 周赛.no_223;


import org.junit.Test;

import java.util.List;

/**
 * @author zxs666
 * @date 2021/1/10 10:41
 */
public class Num_5632 {

    @Test
    public void test(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode res=swapNodes(head,2);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = head;

        for (int i = 1; i < k; i++)
            p1 = p1.next;
        ListNode last = p1;
        ListNode p2 = head;
        while (last.next != null) {
            last = last.next;
            p2 = p2.next;
        }

        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
        return head;
    }
}
