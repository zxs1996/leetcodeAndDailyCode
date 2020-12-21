package 力扣_201_300;

/**
 * Created by zxs666 on 2020/8/8.
 * 前缀树，也称为字典树，它是一个多插树，用于查找单词
 */
public class Num_208 {

}


class Trie {
    //定义节点
    class TireNode {
        private boolean isEnd;//是不是一个单词的结束
        TireNode[] next;//下一个字符，有26种可能 a-z
        String str = null;

        public TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }

    private TireNode root;//树的根节点，不代表任何字符

    public Trie() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode node = root;//从根节点出发
        //遍历单词的每一个字符
        for (char c : word.toCharArray()) {
            //如果该字符在树中不存在，那么创建一个，node继续往下
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TireNode();
            }
            node = node.next[c - 'a'];
        }
        node.str = word;//单词结尾
        node.isEnd = true;//设置为true
    }

    public boolean search(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;//看是不是一个单词结尾
    }

    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
