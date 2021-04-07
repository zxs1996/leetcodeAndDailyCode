package 力扣_1_100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxs666
 * @date 2020/11/15 20:56
 * <p>
 * 二分法：每次对k二分，k/2，然后去掉较小的那一半
 */
public class Num_4 {

    @Test
    public void tes() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }


    //O(log(m+n))的算法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //如果是奇数
        if ((m + n) % 2 == 1)
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 1) / 2);
            //偶数
        else {
            double res1 = findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2);
            double res2 = findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 1) / 2 + 1);
            return (res1 + res2) / 2;
        }

    }

    //找第k大的元素
    public double findKth(int[] nums1, int start_1, int end_1, int[] nums2, int start_2, int end_2, int K) {

        int len1 = end_1 - start_1 + 1;
        int len2 = end_2 - start_2 + 1;
        if (len2 < len1)
            return findKth(nums2, start_2, end_2, nums1, start_1, end_1, K);
        if (len1 == 0)
            return nums2[start_2 + K - 1];
        else if (K == 1)
            return Math.min(nums1[start_1], nums2[start_2]);
        int i = start_1 + Math.min(len1 - 1, K / 2 - 1);
        int j = start_2 + Math.min(len2 - 1, K / 2 - 1);

        //System.out.println(i+"--"+j);
        if (nums1[i] > nums2[j]) {
            return findKth(nums1, start_1, end_1, nums2, j + 1, end_2, K - (j - start_2 + 1));
        } else {
            return findKth(nums1, i + 1, end_1, nums2, start_2, end_2, K - (i - start_1 + 1));
        }



    }

    //O(m+n)算法
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    //使用贪心算法做
    public static class Num_410_2 {


        public int splitArray(int[] nums, int m) {
            int max = 0;//max是最大值的下界
            int sum = 0;//sum是最大值的上界

            // 计算「子数组各自的和的最大值」的上下界
            for (int num : nums) {
                max = Math.max(max, num);
                sum += num;
            }

            // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
            // 使得它对应的「子数组的分割数」恰好等于 m
            int left = max;//左边界，最小值
            int right = sum;//有边界，最大值
            while (left < right) {
                int mid = left + (right - left) / 2;

                int splits = split(nums, mid);
                //往大的方向渐进
                if (splits > m) {
                    // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
                    // 下一轮搜索的区间是 [mid + 1, right]
                    left = mid + 1;
                }
                //往小的方向渐进
                else {
                    // 下一轮搜索的区间是上一轮的反面区间 [left, mid]
                    right = mid;
                }
            }
            return left;
        }

        /***
         *
         * @param nums 原始数组
         * @param maxIntervalSum 子数组各自的和的最大值
         * @return 满足不超过「子数组各自的和的最大值」的分割数
         */
        private int split(int[] nums, int maxIntervalSum) {
            // 至少是一个分割
            int splits = 1;
            // 当前区间的和
            int curIntervalSum = 0;
            for (int num : nums) {
                // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
                if (curIntervalSum + num > maxIntervalSum) {
                    curIntervalSum = 0;
                    splits++;
                }
                curIntervalSum += num;
            }
            return splits;
        }

    }
}
