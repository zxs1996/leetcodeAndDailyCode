package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/5.
 * <p>
 * 记录每一个格子左边最高的墙和右边最高的墙，短板效应，将两者中较小的和自己比较，计算自己能装水的高度
 * 使用动态规划，先使用两个数组记录每一个格子左边的最大高度，和右边的最大高度
 */
public class Num_42 {

    /**
     * 动态规划，开辟两个数组，记录每个位置左边的最大高度和右边的最大高度
     */

    public int trap(int[] height) {

        int n = height.length;
        if (n == 0)
            return 0;
        int[] left_Max = new int[n];
        int[] right_Max = new int[n];
        left_Max[0] = 0;//第一格左边的最大高度为0
        right_Max[n - 1] = 0;//最后一格右边的最大高度为0
        for (int i = 1; i < n; i++)
            left_Max[i] = Math.max(left_Max[i - 1], height[i - 1]);
        for (int i = n - 2; i >= 0; i--)
            right_Max[i] = Math.max(right_Max[i + 1], height[i + 1]);

        int sum = 0;
        //第一格和最后一格是不用算的，因为他们装不了雨水
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(left_Max[i], right_Max[i]);
            if (min > height[i])
                sum += min - height[i];
        }
        return sum;
    }

    /**
     *  进一步优化，使用双指针，即两个变量，一个记录左边的最大值，一个记录右边的最大值
     *  从两端渐进  i =1   j=n-2;
     *  当  left_max < right_max的时候，计算i这个位置的水
     *  否则当 left_max > right_max的时候，计算j这个位置的水。
     */

    public int trap2(int[] height) {

        int n = height.length;
        if (n == 0)
            return 0;
        int left_max = height[0];
        int right_max = height[n - 1];
        int i = 1, j = n - 2;
        int sum = 0;
        while (i <= j) {
            //如果左边上限小于右边上限
            if (left_max <= right_max) {
                if (left_max > height[i])
                    sum += left_max - height[i];
                left_max = Math.max(left_max, height[i]);
                i++;
            } else {
                if (right_max > height[j])
                    sum += right_max - height[j];
                right_max = Math.max(right_max, height[j]);
                j--;
            }
        }
        return sum;
    }
}
