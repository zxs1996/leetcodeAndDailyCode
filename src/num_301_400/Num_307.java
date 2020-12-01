package num_301_400;

/**
 * @author zxs666
 * @date 2020/10/2 13:21
 */
public class Num_307 {
    class NumArray {

        int nums[];
        int sum[];

        public NumArray(int[] nums) {
            this.nums = nums;
            sum = new int[nums.length];
            if (nums.length == 0)
                return;
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                sum[i] += sum[i - 1] + nums[i];
        }

        public void update(int i, int val) {
            int before = nums[i];
            this.nums[i] = val;
            //更新sum值
            for (int j = i; j <nums.length; j++)
                sum[j] = sum[j] - before + val;
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return sum[j];
            return sum[j] - sum[i - 1];
        }
    }
}
