package 力扣_201_300;

import org.junit.Test;

import java.util.*;

public class Num_300 {

    /**
     * O(N²)的解法
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //开辟动态数组，dp[i]表示以下标i结尾的最长上升子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);//初始为1

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++)
            if (dp[i] > res)
                res = dp[i];
        return res;

    }


    /**
     * O(NlogN)的解法
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0)
            return 0;
        //重新定义状态：tail[k]表示长度为k+1的子序列的最后一个元素值，
        //比如{1,4,5},表示长度为1 2 3的序列的结尾数字为1 4 5
        //对于{1,4,7}和{1,4,5}我们会选择1 4 5，因为选择5的话，后面去找比5大的数更好找
        int[] tail = new int[nums.length];
        int tailEndIndex = 0;//tail数组当前最后一个元素下标
        tail[0] = nums[0];//初始化tail[0]

        for (int i = 0; i < nums.length; i++) {

            //去tail里面查找nums[i]应该放的位置
            int index = binarySearch(tail, tailEndIndex, nums[i]);

            tail[index] = nums[i];
            //如果当前的nums[i]是一个特别大的数，那么index会大于tailEndIndex，需要刷新tailEndIndex
            tailEndIndex = Math.max(tailEndIndex, index);
        }
        return tailEndIndex + 1;
    }


    /**
     * 找x在tail中0到end中应该插入的位置
     */
    public int binarySearch(int[] tail, int end, int x) {
        int l = 0, r = end;
        while (l <= r) {
            int mid = (l + r) / 2;
            //注意这里一定要是等号，相等的时候也要往前找··
            if (tail[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }


    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int res = lengthOfLIS2(nums);
        System.out.println(res);

    }
}
