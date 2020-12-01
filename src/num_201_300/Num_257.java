package num_201_300;

import java.util.ArrayList;
import java.util.List;

public class Num_257 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        inOrder(root, new StringBuffer(""));
        return res;
    }

    public void inOrder(TreeNode root, StringBuffer sb) {
        if (root == null)
            return;
        //如果是第一个
        if (sb.length() == 0)
            sb.append(root.val + "");
            //否则不是第一个
        else
            sb.append("->" + root.val);
        if (root.left == null && root.right == null)
            res.add(sb.toString());
        StringBuffer s2=new StringBuffer(sb);
        inOrder(root.left, sb);
        inOrder(root.right, s2);
    }
}
