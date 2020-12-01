package num_1_100;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return visit(p, q);
    }

    public boolean visit(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q != null)
            return p.val == q.val && visit(p.left, q.left) && visit(p.right, q.right);
        else
            return false;

    }
}
