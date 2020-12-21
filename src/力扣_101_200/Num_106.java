package 力扣_101_200;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_106 {
    public static void main(String[] args) {
        int nums1[] = {9, 3, 15, 20, 7};
        int nums2[] = {9, 15, 7, 20, 3};
        System.out.println("aaa" + Arrays.toString(Arrays.copyOfRange(nums1, 0, 0)));
        TreeNode root = new Num_106().buildTree(nums1, nums2);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return generateTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode generateTree(int[] inorder, int s1, int end1, int[] postorder, int s2, int end2) {

        if (s1 > end1)
            return null;
        int i = s1;
        //找当前根节点
        while (inorder[i] != postorder[end2])
            i++;

        //创建根节点
        TreeNode root = new TreeNode(inorder[i]);
        int leftCount = i - s1;

        //创建左子树
        root.left = generateTree(inorder, s1, i - 1, postorder, s2, s2 + leftCount - 1);
        //创建右子树
        root.right = generateTree(inorder, i + 1, end1, postorder, s2 + leftCount, end2 - 1);
        return root;
    }

    {
      /*  if (inorder.length == 0)
            return null;
        int i;
        int postLength = postorder.length;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postLength - 1]) {
                break;
            }
        }
        //创建根节点
        TreeNode root = new TreeNode(inorder[i]);

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
        int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
        int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        //创建左子树
        root.left = buildTree(inorderLeft, postorderLeft);
        //创建右子树
        root.right = buildTree(inorderRight, postorderRight);
        return root;*/
    }

}
