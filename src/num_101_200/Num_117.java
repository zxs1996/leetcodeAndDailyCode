package num_101_200;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0) {
            //获得当前层元素个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1)
                    node.next = queue.peek();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

   /* public void preOrder(Node root) {
        if (root == null)
            return;
        //左右子树都为空
        if (root.left == null && root.right == null)
            return;
            //左右子树都不为空
        else if (root.left != null && root.right != null) {
            root.left.next = root.right;
            Node temp = root.next;
            while (temp != null) {
                if (temp.left != null) {
                    root.right.next = temp.left;
                    break;
                } else if (temp.right != null) {
                    root.right.next = temp.right;
                    break;
                }
                temp = temp.next;
            }
        }
        //左子树为空,右子树不为空
        else if (root.left == null && root.right != null) {
            Node temp = root.next;
            while (temp != null) {
                if (temp.left != null) {
                    root.right.next = temp.left;
                    break;
                } else if (temp.right != null) {
                    root.right.next = temp.right;
                    break;
                }
                temp = temp.next;
            }
        }
        //左子树不为空，右子树为空
        else {
            Node temp = root.next;
            while (temp != null) {
                if (temp.left != null) {
                    root.left.next = temp.left;
                    break;
                } else if (temp.right != null) {
                    root.left.next = temp.right;
                    break;
                }
                temp = temp.next;
            }
        }
        preOrder(root.left);
        preOrder(root.right);
    }*/
}
