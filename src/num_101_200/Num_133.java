package num_101_200;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        int[][] matrix = new int[101][101];//存图
        Queue<Node> queue = new ArrayDeque<>();//广度遍历队列
        queue.add(node);
        Node[] nodeArray = new Node[101];//生成Node数组
        boolean[] visit = new boolean[101];//访问标志
        while (queue.size() > 0) {
            Node temp = queue.poll();
            visit[temp.val] = true;
            nodeArray[temp.val] = new Node(temp.val);
            List<Node> list = temp.neighbors;
            for (Node node1 : list) {
                //如果没被访问过
                if (!visit[node1.val]) {
                    queue.add(node1);
                    matrix[temp.val][node1.val] = 1;
                    matrix[node1.val][temp.val] = 1;
                }
            }
        }
        for (int i = 1; i < 101; i++) {
            //如果这个节点不存在
            if (!visit[i])
                continue;
            List<Node> list = new ArrayList<>();
            for (int j = 1; j < 101; j++) {
                if (matrix[i][j] == 1)
                    list.add(nodeArray[j]);
            }
            nodeArray[i].neighbors = list;
        }
        return nodeArray[1];
    }


    public Node cloneGraph3(Node node) {
        if (node == null)
            return node;

        //Map key表示原来节点，value表示克隆节点
        HashMap<Node, Node> visited = new HashMap();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        //放入克隆初始节点
        visited.put(node, new Node(node.val, new ArrayList()));

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor : n.neighbors) {
                //如果相邻节点没有被访问过，也就是没有在map中，那么放入map，并且将这个节点放入queue
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                //neighbor的克隆放入n克隆节点的neighbors中去
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }


}
