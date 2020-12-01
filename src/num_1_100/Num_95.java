package num_1_100;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/18.
 *
 *思路：将每一个数作为根节点，这个数左边的生成一些树，右边的生成一些树，然后左边的树和右边的树一一组合
 * 左边的树再递归的往下去做，递归结束标志start>end
 */
public class Num_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int start, int end) {

        //定义返回结点
        List<TreeNode> res = new ArrayList<>();
        //如果start>end，那么往里面添加一个null，返回res
        if (start > end) {
            res.add(null);
            return res;
        }
        //循环，每次从start-end选取一个节点做根节点
        for (int i = start; i <= end; i++) {
            //递归生成这个节点的左子树list
            List<TreeNode> leftTree = generateTree(start, i - 1);
            //递归生成这个节点的右子树list
            List<TreeNode> rightTree = generateTree(i + 1, end);

            //遍历左右子树，生成以i为根节点的子树放入res
            for (TreeNode l : leftTree)
                for (TreeNode r : rightTree) {
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = l;
                    currentRoot.right = r;
                    res.add(currentRoot);
                }
        }
        return res;
    }
}
