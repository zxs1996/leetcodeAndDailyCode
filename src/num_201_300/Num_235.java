package num_201_300;

/**
 * @author zxs666
 * @date 2020/9/26 11:12
 */
//找二叉搜索树中两个节点的最近公共祖先，
//充分利用儿茶搜索树的特点，每一个根节点左边的元素都小于根节点，右边的元素都大于根节点
public class Num_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int rootValue = root.val;

        //如果当前的root等于其中的一个p或者q，那么剩下的一个一定在root下面，root就是最近的公共祖先,直接返回root
        if (rootValue == p.val || rootValue == q.val)
            return root;

        //如果root是p和q的分界线，那么root是最近的根节点
        if (rootValue > p.val && rootValue < q.val)
            return root;

            //如果root是p和q的分界线，那么root是最近的根节点
        else if (rootValue < p.val && rootValue > q.val)
            return root;

            //如果p q都在root的左边，那么往下递归
        else if (rootValue > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        else if (rootValue < p.val && rootValue < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}
