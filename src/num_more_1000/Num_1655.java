package num_more_1000;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxs666
 * @date 2020/12/4 12:56
 */
public class Num_1655 {

    @Test
    public void test() {
        int tasks[][] = {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}};

        int[][] tasks2={{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        int res = minimumEffort(tasks2);
        System.out.println(res);
    }

    public int minimumEffort(int[][] tasks) {

        int max = 0;
        for (int[] task : tasks)
            max += task[0];

        //按照每个任务之间的损失，降序排列，
        Arrays.sort(tasks, Comparator.comparingInt(o -> -(o[1] - o[0])));

        int temp = max;
        for (int[] task : tasks) {
            //如果当前temp不够用了，那么需要增加相应的启动能量
            if (temp < task[1]) {
                max += (task[1] - temp);
                temp = task[1];
            }
            temp -= task[0];
        }
        //System.out.println("max" + max);
        return max;
    }
}
