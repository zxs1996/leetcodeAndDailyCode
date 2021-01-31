package 贪心算法.哈夫曼树;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zxs666
 * @date 2020/12/15 17:16
 */
public class Huffman {

    private class TreeNode {

        int count;//当前节点的权值
        boolean isLeaf = false;//是不是叶子节点
        char c;//如果是叶节点，那么对应的字符
        TreeNode left;//左孩子
        TreeNode right;//右孩子

        public TreeNode(TreeNode left, TreeNode right) {
            this.count = left.count + right.count;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int count, char c, boolean isLeaf) {
            this.count = count;
            this.c = c;
            this.isLeaf = isLeaf;
        }
    }

    public Map<Character, String> map;

    public Huffman() {
        map = new HashMap<>();
    }

    /**
     * 传入一个字符串构造huffman树
     */
    public Map<Character, String> createHuffmanTree(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray())
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

        PriorityQueue<TreeNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        for (char c : countMap.keySet())
            pq.add(new TreeNode(countMap.get(c), c, true));
        while (pq.size() > 1) {
            TreeNode child1 = pq.poll();
            TreeNode child2 = pq.poll();
            TreeNode parent = new TreeNode(child1, child2);
            pq.add(parent);
        }

        preOrder(pq.poll(), "");
        return map;
    }


    /**
     * 对字符串进行编码
     *
     * @param str
     * @return
     */
    public String encodeStr(String str) {

        StringBuffer sb = new StringBuffer("");
        for (char c : str.toCharArray())
            sb.append(map.get(c));
        return sb.toString();
    }

    /**
     * 确定字符的编码
     *
     * @param node
     * @param path
     */
    public void preOrder(TreeNode node, String path) {
        //叶子节点
        if (node.isLeaf)
            map.put(node.c, path);

        //非叶节点
        else {
            preOrder(node.left, path + "0");
            preOrder(node.right, path + "1");
        }
    }


}
