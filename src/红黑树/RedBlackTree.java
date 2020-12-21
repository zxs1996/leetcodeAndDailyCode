package 红黑树;

/**
 * @author zxs666
 * @date 2020/11/4 15:19
 * 红黑树
 */
public class RedBlackTree {
    private static int RED_COLOR = 1;
    private static int BLACK_COLOR = 2;

    //定义树节点
    private class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        int color;

        TreeNode(int val, int color) {
            this.val = val;
            this.color = color;
        }
    }

    //定义NIL节点
    private TreeNode nil;

    //定义根节点
    private TreeNode root;

    public RedBlackTree() {
        //创建NIL节点
        nil = new TreeNode(-1, BLACK_COLOR);
        //刚开始没有元素，root就是根节点
        root = nil;
    }


    /**
     * @param val 步骤1：按照二叉树的方式插入
     *            步骤2：对二茶树进行调色和旋转
     */
    public void RBInsert(int val) {
        //如果已经存在了，那么直接返回
        if (RBSearch(val))
            return;
        //创建节点，颜色初始为红色
        TreeNode newNode = new TreeNode(val, RED_COLOR);
        TreeNode x = root;
        TreeNode y = nil;//记录父节点,初始化为nil，保证空树的时候不异常
        while (x != nil) {
            y = x;
            //如果x大于新节点的值，那么去左边
            if (newNode.val < x.val)
                x = x.left;
                //否则去右边
            else
                x = x.right;
        }

        //newNode的父节点指向y，两个孩子指针指向nil
        newNode.parent = y;
        newNode.left = newNode.right = nil;
        //如果y等于nil，说明树为空，那么newNode为根节点
        if (y == nil)
            root = newNode;
            //y不为nil
        else {
            if (newNode.val < y.val)
                y.left = newNode;
            else
                y.right = newNode;
            //父指针指向y
        }
        //调整
        RBInsertFixUp(newNode);
    }

    /**
     * 在红黑树中进行查找，如果找到那么返回，如果找不到，那么添加到红黑树中
     *
     * @param val
     */
    public boolean RBSearch(int val) {
        return binarySearch(root, val);
    }

    /**
     * 二分搜索
     *
     * @param node
     * @param val
     * @return
     */
    private boolean binarySearch(TreeNode node, int val) {
        if (node == nil)
            return false;
        if (node.val == val)
            return true;
        if (val < node.val)
            return binarySearch(node.left, val);
        else
            return binarySearch(node.right, val);
    }

    /**
     * 对红黑树进行旋转和调色
     *
     * @param newNode
     */
    private void RBInsertFixUp(TreeNode newNode) {
        //newNode本身是红色，如果newNode的父节点也是红色，那么就需要往上调整
        while (newNode.parent.color == RED_COLOR) {
            //如果newNode的父节点是它爷爷节点的左孩子，对应case1 case2 case3
            if (newNode.parent == newNode.parent.parent.left) {
                TreeNode uncleNode = newNode.parent.parent.right;
                //case 1:如果叔叔是红色
                if (uncleNode.color == RED_COLOR) {
                    //叔叔节点和父节点设置为黑色，爷爷节点设置为红色，
                    // 这时候问题变成了爷爷节点为红色，再对爷爷节点进行一个调整
                    newNode.parent.color = BLACK_COLOR;
                    uncleNode.color = BLACK_COLOR;
                    newNode.parent.parent.color = RED_COLOR;
                    newNode = newNode.parent.parent;
                }

                //case2 或者case3 叔叔节点为黑色
                else {
                    //case2 当前节点是右孩子，那么需要左旋转换成case3
                    if (newNode == newNode.parent.right) {
                        newNode = newNode.parent;
                        leftRotate(newNode);
                    }
                    //case2左旋之后成为case3
                    //将newNode设置为黑，父节点设置为红，然后以当前节点newNode右旋
                    newNode.parent.color = BLACK_COLOR;
                    newNode.parent.parent.color = RED_COLOR;
                    rightRotate(newNode.parent.parent);
                }
            }
            //如果newNode的父节点是它爷爷节点的右孩子 对应case4 case5 case6
            else {
                TreeNode uncleNode = newNode.parent.parent.left;
                //case 4:如果叔叔节点是红色
                if (uncleNode.color == RED_COLOR) {
                    //叔叔节点和父节点设置为黑色，爷爷节点设置为红色，
                    // 这时候问题变成了爷爷节点为红色，再对爷爷节点进行一个调整
                    newNode.parent.color = BLACK_COLOR;
                    uncleNode.color = BLACK_COLOR;
                    newNode.parent.parent.color = RED_COLOR;
                    newNode = newNode.parent.parent;
                }

                //case5 或者case6 叔叔节点为黑色
                else {
                    //case2 当前节点是左孩子，那么需要右旋
                    if (newNode == newNode.parent.left) {
                        newNode = newNode.parent;
                        rightRotate(newNode);
                    }
                    //case5左旋之后成为case6
                    //将newNode设置为黑，父节点设置为红，然后以当前节点newNode左旋
                    newNode.parent.color = BLACK_COLOR;
                    newNode.parent.parent.color = RED_COLOR;
                    leftRotate(newNode.parent.parent);
                }
            }

        }

        //将根节点上黑色
        root.color = BLACK_COLOR;
    }

    /**
     * 左旋
     *
     * @param x
     */
    private void leftRotate(TreeNode x) {

        //x的右孩子节点和双亲节点
        TreeNode rightChildNode = x.right;
        TreeNode parentNode = x.parent;

        //第一条链：x的右指针指向child的左孩子,
        x.right = rightChildNode.left;

        rightChildNode.left.parent = x;

        //第二条链：child的父指针指向x的复指针。这里要考虑x为根节点的边界情况
        rightChildNode.parent = parentNode;
        //如果x的父节点为nil，说明x是根节点，那么y设为根节点
        if (parentNode == nil)
            root = rightChildNode;

            //如果x是他父亲的左孩子
        else if (x == parentNode.left)
            parentNode.left = rightChildNode;

            //如果x是他父亲的右孩子
        else if (x == parentNode.right)
            parentNode.right = rightChildNode;


        //第三条链：child和x父子互换
        rightChildNode.left = x;
        x.parent = rightChildNode;
    }

    /**
     * 右旋
     *
     * @param x
     */
    private void rightRotate(TreeNode x) {

        //x的左孩子节点和双亲节点
        TreeNode leftChildNode = x.left;
        TreeNode parentNode = x.parent;

        //第一条链：x的左指针指向左孩子的右节点
        leftChildNode.right.parent = x;
        x.left = leftChildNode.right;

        //第二条链：左孩子的父指针指向x的父节点，主要考虑边界情况
        leftChildNode.parent = parentNode;
        //如果x为根节点
        if (parentNode == nil)
            root = leftChildNode;
            //如果x是它父亲的左孩子
        else if (x == parentNode.left)
            parentNode.left = leftChildNode;
        else if (x == parentNode.right)
            parentNode.right = leftChildNode;

        //第三条链：父子交换
        leftChildNode.right = x;
        x.parent = leftChildNode;
    }


    /**
     * 按照树结构打印二叉树
     */
    public void RBShow() {
        if (root == nil) {
            System.out.println("EMPTY!");
            return;
        }

        // 得到树的深度
        int treeHeight = getTreeHigh(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeHeight * 2 - 1;
        int arrayWidth = (2 << (treeHeight - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeHeight);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 辅助打印二叉树
     *
     * @param currNode
     * @param rowIndex
     * @param columnIndex
     * @param res
     * @param treeDepth
     */
    private void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == nil) return;
        // 先将当前节点保存到二维数组中，根据颜色
        String str=null;
        if(currNode.color==RED_COLOR)
            str=  "\033[31;4m" + currNode.val + "\033[0m";
        else
            str=  currNode.val+"";
        res[rowIndex][columnIndex] = str;

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != nil) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != nil) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    /**
     * 获取树层数
     *
     * @param node
     * @return
     */
    private int getTreeHigh(TreeNode node) {
        if (node == nil)
            return 0;
        return Math.max(getTreeHigh(node.left), getTreeHigh(node.right)) + 1;
    }


    /**
     *  返回先序序列
     */
    public String getNLRString() {
        StringBuilder sb = new StringBuilder("");
        preOrder(root, sb);
        return sb.toString();
    }

    /**
     * 先序遍历
     * @param node
     * @param sb
     */
    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == nil)
            return;
        String append = node.val + "," + (node.color == RED_COLOR ? "red" : "black") + "\n";
        sb.append(append);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    /**
     * 返回中序序列
     * @return
     */
    public String getLNRString() {
        StringBuilder sb = new StringBuilder("");
        inOrder(root, sb);
        return sb.toString();
    }

    /**
     * 先序遍历
     * @param node
     * @param sb
     */
    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == nil)
            return;
        String append = node.val + "," + (node.color == RED_COLOR ? "red" : "black") + "\n";
        inOrder(node.left, sb);
        sb.append(append);
        inOrder(node.right, sb);
    }

}
