package num_101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        int[] res = new int[numCourses];
        //表示以key作为前导课的课程集合,时间复杂度优化
        Map<Integer, List<Integer>> map = new HashMap<>();
        //记录每门课的先行课数量
        for (int i = 0; i < prerequisites.length; i++) {
            count[prerequisites[i][0]]++;
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add((prerequisites[i][0]));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }

        //依次学习numCourses这么多门课程
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (count[j] == 0) {
                    res[i] = j;
                    count[j] = -1;
                    if (map.containsKey(j)) {
                        List<Integer> list = map.get(j);
                        for (Integer course : list)
                            count[course]--;
                    }

                    break;
                }
            }
            //说明没找到
            if (j == numCourses)
                return new int[0];
        }
        return res;
    }
}
