package num_1_100;

/**
 * Created by zxs666 on 2020/7/15.
 */
public class Num_53 {

    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new Num_53().maxSubArray(nums);
        System.out.println(res);
    }


    /**
     * 一种更简单的写法，思路一致
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int res=nums[0],b=0;
        for(int i=0;i<nums.length;i++){
            b+=nums[i];

            //这两个if语句的顺序很重要，如果让下面那个语句在上面，那么当字段和为负数时，会返回0，而不是原有答案
            if(b>res) res=b;
            //如果当前b为负数，即前面的字段和小于0，那么将b设置为0，表示从头开始计数
            if(b<0) b=0;
        }

        return res;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果前面的和是负数，那么直接重新计算max，nums[i]不变
            if (nums[i - 1] < 0) {
                max = Math.max(nums[i], max);
                continue;
            }
            //当前值+前面的值大于max，更新max和nums[i]
            if (nums[i] + nums[i - 1] > max) {
                max = nums[i] + nums[i - 1];
                nums[i] = max;
                continue;
            }
            //当前值加前面值小于等于max，更新nums[i]
            else {
                nums[i] += nums[i - 1];
            }
        }
        return max;

    }


    //动态规划
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        //初始化dp数组
        for (int i = 0; i < n; i++)
            dp[i] = nums[i];
        int max = dp[0];
        //动态结构过程中搜索max
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;

    }


}
