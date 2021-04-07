package 剑指offer;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zxs666
 * @date 2021/3/12 17:45
 */
public class Num_36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        Stack<Node> stack=new Stack();

        Node p=root;
        Node head=new Node(0);
        Node pre=head;

        while(stack.size()>0||p!=null){
            System.out.println(stack.size()+"--"+p);
            if(p==null){
                p=stack.pop();
                //System.out.println(p.val);
                pre.right=p;
                p.left=pre;
                pre=p;
                p=p.right;
            }
            else{
                stack.push(p);
                //pre=p;
                p=p.left;
            }
        }
        pre.right=head.right;
        head.right.left=pre;

        return pre.right;
    }

    @Test
    public void test(){
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node4.left=node2;
        node4.right=node5;
        node2.left=node1;
        node2.right=node3;

        Node res=treeToDoublyList(node4);
        while(res!=null){
            System.out.println("a:"+res.val);
            res=res.right;
        }



    }
}
