package num_601_700;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zxs666
 * @date 2020/10/31 22:21
 * //对paris排序，先按照下标1排序，然后按照下标0排序，
 * 排序完成之后去重，比如[1,2],[1,5],[1,7]，只保留[1,2]，因为[1,2]后面可选择的对组的更多
 * 就转化成了最长上升子序列问题
 * 然后利用最长上升子序列的思路解题
 */
public class Num_646 {


    //简单动态规划，时间复杂度O(N²)
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0)
            return 0;
        int res = 0;
        int length = pairs.length;

        //对这个paris排序，让它以递增顺序，先使用下标1排，再使用下标2排
        Arrays.parallelSort(pairs, Comparator.comparingInt(o -> o[1]));
        Arrays.parallelSort(pairs, Comparator.comparingInt(o -> o[0]));
        //dp[i】表示以当前i结尾对组所能获得的最大链长度
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //动态规划+二分搜索
    public int findLongestChain2(int[][] pairs) {
        if (pairs.length == 0)
            return 0;
        int length = pairs.length;

        //对这个paris排序，让它以递增顺序，先使用下标1排，再使用下标0排
        Arrays.parallelSort(pairs, Comparator.comparingInt(o -> o[1]));
        Arrays.parallelSort(pairs, Comparator.comparingInt(o -> o[0]));
        //进行过滤，同样字符开头的，保留较小的，比如[1,10]和[1,5]，那么保留 1 5

        int start = 1;
        for (int i = 1; i < pairs.length; i++) {
            //如果当前对组第一个元素和前一个对组第一个元素相同，那么舍弃，
            if (pairs[i][0] == pairs[i - 1][0])
                continue;
            else
                pairs[start++] = pairs[i];
        }
        //经过上面的处理 pair数组已经有序，并且没有重复的开头元素，重新定义pairs长度。
        pairs = Arrays.copyOf(pairs, start);

        //这个时候就可以使用最长子序列的思想 动态规划+二分查找来完成。
        int[] tail = new int[pairs.length];//tail[i]表示i+1长度的对组链的最后一个元素的值，每次我们都希望缩小这个值，以得到更长的链
        tail[0] = pairs[0][1];
        int k = 1;
        for (int i = 1; i < pairs.length; i++) {
            //index表示当前i应该插入的tail的位置，但是不一定要插入，需要对对组第二个元素做判断
            int index = binarySearch(tail, k, pairs[i][0], pairs[i][1]);
            //index=k说明当前元素放入的位置是最后，那么直接放进去，k++，对组链长度+1
            if (index == k) {
                tail[k++] = pairs[i][1];
            }
            //否则说明当前元素需要放入的位置是在tail前面，那么需要做判断
            else {
                if (pairs[i][1] < tail[index])
                    tail[index] = pairs[i][1];
            }
        }
        return k;
    }

    public int binarySearch(int[] tail, int k, int num1, int num2) {
        int left = 0, right = k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num1 <= tail[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    @Test
    public void test2() {

    }


    @Test
    public void test() {
        int[][] nums = new int[][]{{2, 5}, {2, 7}, {1, 4}, {1, 3}};
        Arrays.sort(nums, Comparator.comparingInt(o1 -> o1[1]));
        Arrays.sort(nums, Comparator.comparingInt(o1 -> o1[0]));
        for (int i = 1; i < nums.length; i++)
            if (nums[i][0] == nums[i - 1][0])
                nums[i][0] = Integer.MAX_VALUE;
        List<int[]> newNums = Arrays.stream(nums).filter(ints -> ints[0] != Integer.MAX_VALUE).collect(Collectors.toList());
        System.out.println(Arrays.deepToString(newNums.toArray()));
    }


}
