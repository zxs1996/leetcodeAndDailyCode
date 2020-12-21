package 算法导论代码;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/10/29 21:01
 * 在数组上找第二小的元素，要求在n+logn-2次比较完成
 */
public class Num_9_1_1 {


    @Test
    public void test2() {
        int N = 10;
        Random random = new Random();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++)
            nums[i] = random.nextInt(30);
        System.out.println(Arrays.toString(nums));
        int res = getSecond(nums);
        System.out.println(res);
    }

    public int getSecond(int[] nums) {
        int length = nums.length;
        int index = length;
        int[][] flag = new int[length * 2 + 1][2];
        for (int i = 0; i < nums.length; i++) {
            flag[i][0] = nums[i];
            flag[i][1] = i;
        }
        int oldCount = 0;
        int newCount = nums.length;
        while (newCount > 1) {
            //System.out.println("newcount:"+newCount);
            oldCount = newCount;
            newCount = 0;

            int start = index - oldCount;
            int end = index;
            for (int i = start; i < end; i++) {
                //如果有超过两个元素
                if (i + 1 < end) {
                    if (flag[i][0] <= flag[i + 1][0]) {
                        flag[index][0] = flag[i][0];
                        flag[index][1] = i;
                    } else {
                        flag[index][0] = flag[i + 1][0];
                        flag[index][1] = i + 1;
                    }
                    i++;
                }
                //只有一个元素，那么直接放到flag数组
                else {
                    flag[index][0] = flag[i][0];
                    flag[index][1] = i;
                }
                index++;
                newCount++;
            }
        }
        //
        int second = Integer.MAX_VALUE;
        //以lg(n)的时间复杂度往前找
        //System.out.println(flag[index - 1][0]);

        index = index - 1;
        while (index >= nums.length) {
            index = flag[index][1];
                second = Math.min(second, flag[index + 1][0]);
                second=Math.min(second,flag[index-1][0]);

        }
        return second;
    }
}
