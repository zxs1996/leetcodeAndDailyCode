package num_201_300;

import java.util.*;

/**
 * Created by zxs666 on 2020/8/8.
 * 前缀树+dfs回溯
 */
public class Num_212_Trie {
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

    class Trie {
        private TireNode root;

        public Trie() {
            root = new TireNode();
        }

        public void insert(String word) {
            TireNode node = root;
            StringBuffer sb = new StringBuffer("");
            for (char c : word.toCharArray()) {
                sb.append(c);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TireNode();
                }
                node = node.next[c - 'a'];
            }
            node.str = sb.toString();
            node.isEnd = true;
        }

    }

    boolean[][] visited;//访问标志数组
    Map<String, Integer> res;//存放结果的map，防止有重复的单词，使用map保证唯一性
    char[][] myBoard;//全局二维数组

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        //将words里面的单词插入trie
        for (String word : words)
            trie.insert(word);
        myBoard = board;
        res = new HashMap<>();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                // 如果该字符在字典树中存在，那么进行dfs回溯查询
                if (trie.root.next[board[i][j] - 'a'] != null) {
                    //初始化visited数组
                    for (int k = 0; k < visited.length; k++)
                        Arrays.fill(visited[k], false);
                    dfs(i, j, trie.root.next[board[i][j] - 'a']);
                }
            }
        List<String> list = new ArrayList<>();
        for (String str : res.keySet())
            list.add(str);
        return list;
    }

    public void dfs(int i, int j, TireNode node) {
        //如果该字符是一个单词的结束字符,将其添加到res中，然后继续往下走
        if (node.isEnd)
            res.put(node.str, 1);

        visited[i][j] = true;//将访问数组设置为true
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        //从4个方向出发
        for (int k = 0; k < 4; k++) {
            int newRow = i + row[k];
            int newCol = j + col[k];
            //如果越界或者被访问过,那么跳过
            if (newRow < 0 || newCol < 0 || newRow >= myBoard.length || newCol >= myBoard[0].length || visited[newRow][newCol])
                continue;
            //如果字符在前缀树中存在，那么dfs继续往下走
            if (node.next[myBoard[newRow][newCol] - 'a'] != null) {
                dfs(newRow, newCol, node.next[myBoard[newRow][newCol] - 'a']);
            }
        }
        visited[i][j] = false;//恢复访问数组
    }
}
