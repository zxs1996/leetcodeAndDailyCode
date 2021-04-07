package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_124 {

    //记录最大值，初始为Integer的最小值
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        lastOrder(root);
        return max;
    }

    public int lastOrder(TreeNode root){
        if(root==null)
            return 0;
        //计算左右子树返回给该节点的最大值
        int leftMax=lastOrder(root.left);
        int rightMax=lastOrder(root.right);

        //更新以当前节点为根节点的树路径长度最大值
        int curMax=root.val+leftMax+rightMax;
        max=Math.max(curMax,max);

        //给父节点返回一个较大值
        int returnMax=root.val+Math.max(leftMax,rightMax);
        //在returnMax和0之间返回一个最大值。如果是0，说明这棵树的路径和是负数，负增益，就不选他
        return  Math.max(returnMax,0);

    }

}
