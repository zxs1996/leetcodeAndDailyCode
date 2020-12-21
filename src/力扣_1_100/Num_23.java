package 力扣_1_100;

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
            if(head==null){
                head=currMinNode;
                next=head;
            }

            else{
                next.next=currMinNode;
                next=next.next;
            }

        }
    }
}
