package 力扣_101_200;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2021/2/6 15:02
 */
public class Num_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode cur = new TreeNode(preorder[preStart]);

        //找分割点
        int count = 0;
        while (inorder[count + inStart] != preorder[preStart])
            count++;
        cur.left = buildTree(preorder, preStart + 1, preStart + count, inorder, inStart, inStart + count-1);
        cur.right = buildTree(preorder, preStart + 1 + count, preEnd, inorder, inStart + count + 1, inEnd);
        return cur;

    }


    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = Arrays.copyOfRange(nums, 1, 3);
        System.out.println(Arrays.toString(nums2));
    }


}
