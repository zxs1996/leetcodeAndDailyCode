package 力扣_201_300;

import java.util.*;

/**
 * Created by zxs666 on 2020/8/8.
 * 暴力DFS
 * 前缀树+DFS 高效
 */
public class Num_212 {
    boolean[][] visited;
    ArrayDeque<String> res = new ArrayDeque<>();

    public List<String> findWords(char[][] board, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words)
            map.put(str, 1);
        words = new String[map.size()];
        int index = 0;
        for (String key : map.keySet())
            words[index++] = key;
        System.out.println(words.length);
        visited = new boolean[board.length][board[0].length];
        for (int times = 0; times < words.length; times++) {
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++) {
                    if (res.size() > 0 && res.getLast().equals(words[times]))
                        break;
                    if (board[i][j] == words[times].charAt(0)) {
                        for (int k = 0; k < board.length; k++)
                            Arrays.fill(visited[k], false);
                        dfs(words[times], board, 0, i, j);
                    }

                }
        }
        return new ArrayList<>(res);
    }


    public void dfs(String word, char[][] board, int index, int i, int j) {
        //到达最后
        if (index == word.length()) {
            res.add(word);
            return;
        }
        //如果越界或者被访问过或者字符不相等，那么返回
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j])
            return;

        //否则说明元素相等，那么继续dfs
        visited[i][j] = true;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            //如果这个单词已经被放入res里面了,那么直接返回
            if (res.size() > 0 && word.equals(res.getLast()))
                return;
            dfs(word, board, index + 1, i + row[k], j + col[k]);
        }
        visited[i][j] = false;

    }
}
