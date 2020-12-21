package 力扣_101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/19.
 * //根据有序链表构造平衡二叉树
 * 注意：不要用构造平衡二叉树的方法去做，会比较复杂
 * 先遍历链表，将数据放入数组。
 * 每次选取数组中间元素作为根节点，然后左右分别递归构造子树
 */
public class Num_109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int nums[] = new int[list.size()];
        for (int i = 0; i < nums.length; i++)
            nums[i] = list.get(i);
        return createTree(nums, 0, nums.length - 1);
    }

    public TreeNode createTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);
        return root;
    }
}
