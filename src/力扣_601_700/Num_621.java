package 力扣_601_700;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/12/5 11:47
 */
public class Num_621 {


    @Test
    public void test() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int res = leastIntervalWithHashMap(tasks, 2);
        System.out.println(res);
    }

    /**
     * 使用数组记录字符
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int[] preIndex = new int[26];
        Arrays.fill(preIndex, Math.min(-n * tasks.length, -1));
        for (char c : tasks)
            count[c - 'A']++;

        int time = 0;
        int leftJob = tasks.length;
        while (leftJob > 0) {
            int findIndex = findMax(count, preIndex, time, n);

            if (findIndex != -1) {
                count[findIndex]--;
                preIndex[findIndex] = time;
                leftJob--;
            }
            time++;
        }
        return time;
    }

    public int findMax(int[] count, int[] preIndex, int time, int n) {
        int findIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (time - preIndex[i] > n && count[i] > 0) {
                if (findIndex == -1)
                    findIndex = i;
                else
                    findIndex = count[findIndex] > count[i] ? findIndex : i;
            }
        }
        return findIndex;
    }


    /**
     * 使用hashMap
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastIntervalWithHashMap(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> preMap = new HashMap<>();

        for (char c : tasks) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            preMap.put(c, -100 * tasks.length);
        }

        int time = 0;
        while (countMap.size() > 0) {
            char findChar = findMaxWithHashMap(countMap, preMap, time, n);

            if (findChar != '0') {
                int leftCount = countMap.get(findChar);
                leftCount--;
                if (leftCount == 0)
                    countMap.remove(findChar);
                else
                    countMap.put(findChar, leftCount);
                preMap.put(findChar, time);
            }
            time++;
        }
        return time;
    }

    public char findMaxWithHashMap(Map<Character, Integer> countMap, Map<Character, Integer> preMap, int time, int n) {
        char findChar = '0';
        for (char key : countMap.keySet()) {
            if (time - preMap.get(key) > n) {
                if (findChar == '0')
                    findChar = key;
                else
                    findChar = countMap.get(findChar) > countMap.get(key) ? findChar : key;
            }
        }
        return findChar;
    }

}
