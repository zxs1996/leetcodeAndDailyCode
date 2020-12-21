package 力扣_201_300;

//找二叉树中两个节点的最近公共祖先

public class Num_236 {
    boolean flag = false;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        //分别看左右子树是否有p q的公共父节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //如果flag为true，说明在左边找到了祖先节点，那么直接返回左边找到的这个祖先节点
        if (flag)
            return left;

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果flag为true，说明在右边找到了祖先节点，那么直接返回右边找到的这个祖先节点
        if (flag)
            return right;

        //如果左右子树中分别找到了p q，那么返回root
        if ((left == p && right == q) || (left == q && right == p)) {
            flag = true;
            return root;
        }


        //如果当前节点root为p，并且在子树当中找到了q，那么返回当前节点root
        if (root == p && (left == q || right == q)) {
            flag = true;
            return root;
        }
        //如果当前节点root为q，并且在子树当中找到了p，那么返回当前节点root
        if (root == q && (left == p || right == p)) {
            flag = true;
            return root;
        }
        //如果只在左边找到了
        if (left != null)
            return left;
        //如果只在右边找到了
        else if (right != null)
            return right;
        //如果左右都没找到，但是root==p或者root==q
        else if (p == root || q == root)
            return root;
        return null;
    }

}
