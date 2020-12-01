package num_1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_99 {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inFirst(root, list);
        int num1, num2;
        int i = 0;
        while (list.get(i) < list.get(i + 1))
            i++;
        num1 = list.get(i);
        i = list.size() - 1;
        while (list.get(i) > num1)
            i--;
        num2 = list.get(i);
        change(root, num1, num2);
    }

    public void inFirst(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inFirst(root.left, list);
        list.add(root.val);
        inFirst(root.right, list);
    }

    public void change(TreeNode root, int num1, int num2) {
        if (root == null)
            return;
        if (root.val == num1)
            root.val = num2;
        else if (root.val == num2)
            root.val = num1;
        change(root.left, num1, num2);
        change(root.right, num1, num2);
    }
}
