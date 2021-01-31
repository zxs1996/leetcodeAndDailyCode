package 力扣_101_200;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/22 14:16
 */
public class Num_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int flag = 1;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if ((flag & 1) == 1) {
                res.add(new ArrayList<>(tmp));
            } else {
                List<Integer> list = new LinkedList<>();

                for (int num : tmp)
                    list.add(0, num);
                res.add(list);
            }
            flag++;
        }
        return res;
    }
}
