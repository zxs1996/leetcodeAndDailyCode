package middle.TreeAndGraph;

import java.util.*;

/**
 * Created by zxs666 on 2019/12/26.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
    }


    //next节点
    public Node connect(Node root) {
        if (root == null) return null;
        //如果左孩子存在
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    int flag[][];
    int length;
    int rowlength;
    int x[] = new int[]{0, 0, 1, -1};
    int y[] = new int[]{1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        length = grid.length;
        if (length == 0)
            return 0;
        rowlength = grid[0].length;
        flag = new int[length][rowlength];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < rowlength; j++)
                flag[i][j] = grid[i][j] - '0';
        int islandCount = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < rowlength; j++) {
                if (flag[i][j] == 1) {
                    islandCount++;
                    DFS(i, j);
                }
            }
        return islandCount;
    }
    void DFS(int i, int j) {
        flag[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int xx = i + x[k];
            int yy = j + y[k];
            if (xx>=0&&xx<length&&yy>=0&&yy<rowlength&&flag[xx][yy]==1)
                    DFS(xx,yy);
        }
    }

    int count = 1;
    //找第K小的元素
    public int kthSmallest(TreeNode root, int k) {
        if (root.left != null) {
            int leftCount = kthSmallest(root.left, k);
            if (leftCount != -1)
                return leftCount;
        }
        if (count++ == k)
            return root.val;
        if (root.right != null) {
            int rightCount = kthSmallest(root.right, k);
            if (rightCount != -1)
                return rightCount;
        }
        return -1;
    }

    //根据前序和中序构建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    //根据前序和中序构建二叉树
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;
        else if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);

        TreeNode root = new TreeNode(preorder[preStart]);
        int i, count = 0;
        for (i = inStart; i < inEnd; i++, count++)
            if (inorder[i] == preorder[preStart])
                break;
        root.left = myBuildTree(preorder, inorder, preStart + 1, preStart + count, inStart, inStart + count);
        root.right = myBuildTree(preorder, inorder, preStart + count + 1, preEnd, inStart + count + 1, inEnd);
        return root;
    }

    //Z字型遍历（从左到右，在从右到左，一直循环往复）
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curreentList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        if (root == null)
            return list;
        queue.add(root);
        int curFloor = 1;//第一层有一个元素
        int nextFloor = 0;
        int flag = 0;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            curreentList.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
                nextFloor++;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextFloor++;
            }
            //当前层遍历完了
            if (--curFloor == 0) {
                if (flag % 2 == 1) {
                    int size = curreentList.size();
                    System.out.println("flag" + size + "," + Arrays.toString(curreentList.toArray()));
                    //逆置
                    for (int i = 0; i < size; i++)
                        stack.push(curreentList.get(i));
                    curreentList = new ArrayList<>();
                    for (int i = 0; i < size; i++)
                        curreentList.add(stack.pop());

                    System.out.println("flag" + size + "," + Arrays.toString(curreentList.toArray()));
                }
                flag++;
                list.add(curreentList);
                curreentList = new ArrayList<>();
                curFloor = nextFloor;
                nextFloor = 0;
            }
        }
        return list;
    }


    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }


}
