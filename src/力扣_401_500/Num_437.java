package 力扣_401_500;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/12/19 23:43
 */
public class Num_437 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        //map(i,j) 记录的是前缀和为i的路径有j条
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        inorder(root,map,0,sum);
        return res;
    }

    public void inorder(TreeNode root, Map<Integer, Integer> map, int curSum, int sum) {
        if (root == null)
            return;
        curSum += root.val;

        //如果map包含curSum-sum这个key，就是两个前缀和的差值为sum,那么
        if (map.containsKey(curSum - sum))
            res += map.get(curSum - sum);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        inorder(root.left, map, curSum, sum);
        inorder(root.right, map, curSum, sum);
        map.put(curSum, map.get(curSum) - 1);
    }
}
