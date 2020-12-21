import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/20 11:09
 */
public class Num_5631 {

    @Test
    public void test1() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        System.out.println(maxResult(nums, 3));
    }

    public int maxResult(int[] nums, int k) {
        int res = nums[0];
        int n = nums.length;
        //每次找到一个正数，或者当前范围内最小的负数跳
        for (int i = 1; i < n; i++) {
            int max = i;
            //如果小于0，那么才往后找，大于等于0 不会执行这个循环
            for (int j = 0; nums[max] < 0 && j < k && i + j < n; j++) {
                if (nums[i + j] >= nums[max])
                    max = i + j;
            }

            //核心代码，边界判断
            //如果当前能够直接跳到最后，并且当前范围内全是负数，那么直接跳到最后。
            if (i + k >= n && nums[max] < 0) {
                res += nums[n - 1];
                return res;

            }

            res += nums[max];
            i = max;
        }

        return res;
    }
}
