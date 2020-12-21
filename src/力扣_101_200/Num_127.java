package 力扣_101_200;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/10/12 22:14
 */
public class Num_127 {


    private class GraphNode {
        String val;
        List<GraphNode> next;

        public GraphNode(String val) {
            this.val = val;
            next = new ArrayList<>();
        }
    }

    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return 解法1：bfs+直接建图
     * 一开始就建图，每个字符串需要和剩下的N-1个字符串比较，总的时间复杂度是（N*N*单词长度）
     * 如果两个字符串他们只有一个字符是不相同的，那么他们在图中是相邻的
     * 从起点开始广度优先遍历，遍历到endWord，返回当前遍历的深度
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //将起始节点放进去，放入0号位置
        wordList.add(0, beginWord);
        int size = wordList.size();
        GraphNode[] arr = new GraphNode[size];
        Set<GraphNode> visited = new HashSet<>();

        //1、所有字符串建立一个节点
        for (int i = 0; i < size; i++) {
            arr[i] = new GraphNode(wordList.get(i));
        }
        //2、维护各个节点之间关系
        for (int i = 0; i < size; i++) {
            String str = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String curr = wordList.get(j);
                //如果这两个元素只相差一个字符，那么说明他们是相邻的，维护索引
                if (compare(str, curr)) {
                    arr[i].next.add(arr[j]);
                    arr[j].next.add(arr[i]);
                }
            }
        }

        //创建队列，起始节点入队
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(arr[0]);
        int count = 0;
        //广度遍历
        while (queue.size() > 0) {
            count++;
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                GraphNode node = queue.poll();
                if (node.val.equals(endWord))
                    return count;
                visited.add(node);//设置访问标志
                List<GraphNode> nexts = node.next;
                for (GraphNode next : nexts) {
                    if (!visited.contains(next))
                        queue.add(next);
                }
            }

        }
        return 0;
    }

    public boolean compare(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }


    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return 解法2：bfs+优化建图，一开始并不建立图，并且不需要创建图节点
     * 先将所有的字符串放入一个Set中，每次遍历到一个字符串，将这个字符串每一个字符依次修改为a-z,时间复杂度是（N*26*单词长度)
     * 如果两个字符串他们只有一个字符是不相同的，那么他们在图中是相邻的
     * 从起点开始广度优先遍历，遍历到endWord，返回当前遍历的深度
     */

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();//用于存放原始的字符串
        for (String str : wordList)
            set.add(str);
        //如果不包含结束字符串，直接返回0
        if (!set.contains(endWord))
            return 0;
        Queue<String> queue = new ArrayDeque<>();//bfs会用到
        Set<String> visited = new HashSet<>();//访问位
        queue.add(beginWord);//放入开始节点
        visited.add(beginWord);
        int step = 1;//因为最开始起始字符串也算一个长度，所以初始为1
        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                String str = queue.poll();
                //如果从str相邻处找到了endWord，那么返回step+1
                boolean res = exchangeCharacter(str, queue, set, endWord, visited);
                //如果相等，那么说明找到了
                if (res)
                    return step + 1;
            }
            step++;
        }
        return 0;
    }

    /**
     * @param str     当前遍历的字符串
     * @param queue   队列
     * @param set     单词集
     * @param endWord 结束单词
     * @param visited 访问标志
     * @return
     */
    public boolean exchangeCharacter(String str, Queue<String> queue, Set<String> set, String endWord, Set<String> visited) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char originalChar = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar)
                    continue;
                arr[i] = c;
                String newStr = new String(arr);
                if (newStr.equals(endWord))
                    return true;
                //这个新字符串包含在wordList里面，并且没有被访问过，那么它入队，加入访问set
                if (set.contains(newStr) && !visited.contains(newStr)) {
                    queue.add(newStr);
                    visited.add(newStr);//设置访问标志
                }
            }
            arr[i] = originalChar;//每一轮变换之后一定要恢复
        }
        return false;//找不到endWord，默认返回false
    }


    /**
     * 第三种解法：双向bfs
     */
    @Test
    public void test() {

        List<String> wordlist = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int res = ladderLength2("hit", "cog", wordlist);
        System.out.println("res:" + res);
    }
}
