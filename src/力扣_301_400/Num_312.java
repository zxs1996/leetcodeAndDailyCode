package 力扣_301_400;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/11/13 22:16
 */
public class Num_312 {

    @Test
    public void test() {
        int res = maxCoins(new int[]{9,76,64,21,97,60});
        System.out.println(res);
    }

    private class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int maxCoins(int[] nums) {

        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            node.pre = p;
            p.next = node;
            p = p.next;
        }

        //创建一个尾节点
        ListNode tail = new ListNode(1);
        tail.pre = p;
        p.next = tail;
        int res = 0;
        int count = nums.length;
        while (count > 0) {
            ListNode minNode = head.next;
            p = minNode;
            //找当前最小的节点
            for (; p != tail; p = p.next) {
                if (p.val < minNode.val)
                    minNode = p;
            }
            //如果不为0或1，去中间找一个较小的值
            if (minNode.val > 1) {
                //如果大于2，去找一个中间值
                if (count > 2) {
                    p = minNode = head.next.next;
                    //找当前最小的节点
                    for (; p != tail.pre; p = p.next) {
                        if (p.val < minNode.val)
                            minNode = p;
                    }
                }
            }
            res+=minNode.pre.val*minNode.next.val*1*minNode.val;
            //System.out.println("minValue:"+minNode.val);
            ListNode before = minNode.pre;
            ListNode after = minNode.next;
            before.next = after;
            after.pre = before;
            //System.out.println(minNode.val + "-" + res);
            count--;
        }
        return res;

    }
}
