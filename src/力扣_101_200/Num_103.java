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


    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);
        int flag = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (flag == 1)
                res.add(temp);
            else {
                List<Integer> temp2 = new ArrayList<>();
                for (int i = temp.size() - 1; i >= 0; i--)
                    temp2.add(temp.get(i));
                res.add(temp2);
            }
            flag *= -1;
        }
        return res;
    }
}
