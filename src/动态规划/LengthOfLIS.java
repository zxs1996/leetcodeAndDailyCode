package 动态规划;

import org.junit.Test;

import java.util.Random;

/**
 * @author zxs666
 * @date 2020/12/19 17:42
 */
public class LengthOfLIS {

    @Test
    public void test2(){
        int N=40;
        int[] nums=new int[N];
        Random random=new Random();
        for(int i=0;i<N;i++)
            nums[i]=random.nextInt(500);
        int res=lengthOfLIS(nums);
        int res2=lengthOfLIS2(nums);
        System.out.println(res);
        System.out.println(res2);
    }


    public int lengthOfLIS(int[] nums) {
        //dp[i]表示以dp[i]结尾的最长上升子序列的长度
        int n = nums.length;
        int[] tail = new int[n + 1];//tail[2]表示长度为2的最长上升子序列的最末尾值
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;//单独一个数字的时候序列长度为1
            for (int j = 0; j < i; j++) {

                //如果nums[j]小于nums[i],那么以i结尾的最长上升列为dp[i]和dp[j]+1之中的较大值
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public int lengthOfLIS2(int[] nums) {
        //dp[i]表示以dp[i]结尾的最长上升子序列的长度
        int n = nums.length;
        int curLength = 1;
        if (n == 0)
            return 0;
        int[] tail = new int[n + 1];//tail[2]表示长度为2的最长上升子序列的最末尾值
        tail[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int findIndex = binarySearch(tail, curLength, nums[i]);
            if (findIndex == curLength) {
                tail[curLength++] = nums[i];
            } else {
                tail[findIndex] = nums[i];
            }
        }
        return curLength;
    }

    //找num应该在tail中插入的位置
    public int binarySearch(int[] tail, int curLength, int num) {
        int left = 0, right = curLength - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tail[mid] == num)
                return mid;
            else if (tail[mid] > num)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

}
