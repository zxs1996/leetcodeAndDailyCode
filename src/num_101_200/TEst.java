package num_101_200;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class TEst {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode[] temp=new TreeNode[1];
        new TEst().change(root,temp);
        System.out.println(temp[0].val);

    }
    public void change(TreeNode root,TreeNode[] temp){
        temp[0]=root;

    }
}
