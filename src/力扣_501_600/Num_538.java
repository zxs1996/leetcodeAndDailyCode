package 力扣_501_600;

/**
 * @author zxs666
 * @date 2021/1/2 23:37
 */
public class Num_538 {
    public TreeNode convertBST(TreeNode root) {
        lastOrder(root,0);
        return root;
    }
    //传入参数val表示右子树的和
    public int lastOrder(TreeNode root,int val){

        //注意为null的时候，返回val，不要错误的返回0。
        if(root==null)
            return val;

        //先去右边
        int right=lastOrder(root.right,val);
        //计算当前根等于root.val+右边的值
        root.val=root.val+right;
        //计算左边，传入根及其右边的和，然后将值返回给上一层
        return lastOrder(root.left,root.val);
    }
}
