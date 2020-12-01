package num_101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_107 {
    public static void main(String[] args) {
        Queue<TreeNode> queue = new ArrayDeque<>();

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int count = 1;//当前层的元素个数
        int tempCount = 0;//下一层的元素个数
        queue.offer(root);//根元素入队
        List<Integer> list = new ArrayList<>();
        while (queue.size()>0) {
            //取出一个元素
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                tempCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                tempCount++;
            }
            count--;
            //如果当前层为0，那么表示结束
            if (count == 0) {
                res.add(list);
                list = new ArrayList<>();
                count = tempCount;
                tempCount = 0;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--)
            ans.add(res.get(i));
        return ans;
    }
}
