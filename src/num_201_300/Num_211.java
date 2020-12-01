package num_201_300;

/**
 * Created by zxs666 on 2020/8/8.
 * 搜索和添加单词
 */
public class Num_211 {
}


class WordDictionary {
    class TreeNode {
        boolean isEnd;
        String str = null;
        TreeNode[] next;

        public TreeNode() {
            isEnd = false;
            next = new TreeNode[27];
        }

    }

    TreeNode root = null;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TreeNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            //如果是.
         /*   if (c == '.') {
                if (node.next[26] == null)
                    node.next[26] = new TreeNode();
                node = node.next[26];
            } else {*/
            if (node.next[c - 'a'] == null)
                node.next[c - 'a'] = new TreeNode();
            node = node.next[c - 'a'];

        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int start, TreeNode node) {
        //说明word已经全部查找完，判断node是不是单词结束
        if (start == word.length())
            return node.isEnd;//返回是不是单词结束
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            //如果是'.'的话，递归地去尝试每一条路线
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null) {
                        boolean res = search(word, i + 1, node.next[j]);
                        if (res)
                            return res;
                    }
                }
                return false;
            }
            //否则，按照前缀树查询
            else {
                if (node.next[c - 'a'] == null)
                    return false;
                node = node.next[c - 'a'];
            }
        }
        return node.isEnd;
    }
}
