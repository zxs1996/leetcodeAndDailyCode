package 力扣_301_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/10/31 20:49
 * <p>
 * 主要思想：动态规划
 * 第一种：单纯的动态规划  时间复杂度O(N²)
 * 直接使用动态规划dp[i]表示以i结尾的最长子数组的长度
 * 两层循环第一层 i从1~数组长度
 * 第二层  j从0到i-1
 * if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1)
 * <p>
 * 第一种：动态规划+二分查找
 * 状态转移方程：tail[k]表示K+1长度上升子序列的最小的结尾数
 * 比如 1  3 这个长度为2的子序列它肯定比1  10要好，因为我们去后面找大于3的数肯定比大于10的数好找
 * 所以如果我们当前找到的子序列是1 10 当前遍历元素是 3,那么先找到3应该插入的位置，然后把3插入到子序列，相当于把10换成3
 * 一层循环加一个二分查找
 * 循环：for i从1到数组长度
 * 去当前tail里面二分找nums[i]应该放的位置，
 * 如果这个位置大于了当前tail的长度，那么说明nums[i]比前面k+1个元素都大，子序列长度+1
 * 如果这个位置不大于当前tail长度，子序列长度不变
 */
public class Num_300 {


    //O(N²)解法
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        //tail[i]表示长度为i+1上升子序列的最小结尾数
        int[] tail = new int[nums.length];
        tail[0] = nums[0];//初始化tail[0]，它表示当前长度为1的上升子序列的最小值为nums[0]
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int insertIndex = binarySearch(tail, res, nums[i]);
            System.out.println(i + "---" + insertIndex + "--currentRes:" + res);
            //返回-1表示tail里面没有大于nums[i]的元素，那么tail[res]=nums[i]
            tail[insertIndex] = nums[i];
            if (insertIndex == res)
                res++;
        }
        return res;
    }


    //返回number要插入的tail的位置
    public int binarySearch(int[] tail, int k, int number) {
        int left = 0, right = k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tail[mid] < number)
                left = mid + 1;
            else
                right = mid - 1;
        }
        //执行到终点
        return left;
    }


    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 7, 9};
        int res = binarySearch(nums, 5, 7);
        System.out.println(res);
    }

    @Test
    public void test1() {
        Map<Integer, Integer> map = new HashMap<>();
        int n = 10;
        Random random = new Random();
        int[] nums = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            while (true) {
                temp = random.nextInt(15);
                if (!map.containsKey(temp))
                    break;
            }
            map.put(temp, 1);
            nums[i] = temp;
        }

        System.out.println(Arrays.toString(nums));
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }

}
