package 力扣_101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zxs666 on 2020/7/25.
 */
public class Num_145 {
    //后续遍历递归算法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;

    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    //后续遍历非递归算法
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        //当stack不为空的时候或者node不为null时
        while (!stack.isEmpty() || p != null) {
            //如果p不为空,往左走
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            //否则往右走
            else {
                TreeNode temp = stack.peek();
                //如果右节点不为空，并且前一个访问的节点不是右节点，说明右节点没有被访问过
                if (temp.right != null && pre != temp.right) {
                    p = temp.right;//走到右节点
                    stack.push(p);//右节点入栈
                    p = p.left;//右孩子节点继续往左走
                }
                //访问当前根节点
                else {
                    p = stack.pop();
                    res.add(p.val);
                    pre = p;//前一个访问节点设为p
                    p = null;//设置为null，往上面退
                }
            }
        }
        return res;
    }
}
