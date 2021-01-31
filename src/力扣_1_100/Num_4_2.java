package 力扣_1_100;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2021/1/29 22:39
 */
public class Num_4_2 {

    @Test
    public void test(){
        int [] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len % 2 == 1)
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2+1);
        else {
            double res1 = findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2);
            double res2 = findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2 + 1);
            return (res1 + res2) / 2;

        }
    }

    /**
     * 找第K大的元素，K从1开始
     * @param nums1
     * @param start_1
     * @param end_1
     * @param nums2
     * @param start_2
     * @param end_2
     * @param K
     * @return
     */
    public double findKth(int[] nums1, int start_1, int end_1, int[] nums2, int start_2, int end_2, int K) {

        int len1 = end_1 - start_1 + 1;
        int len2 = end_2 - start_2 + 1;
        //让第一个数组较短，这样如果有数组为空，那么一定是第一个。
        if (len2 < len1)
            return findKth(nums2, start_2, end_2, nums1, start_1, end_1, K);
        if (len1 == 0)
            return nums2[start_2 + K-1];
        //如果K等于1，那么直接返回两个数组较小值
        if (K == 1)
            return Math.min(nums1[start_1], nums2[start_2]);
        //注意这里要取一个最小值，因为有可能K/2-1会超过数组范围
        int i = start_1 + Math.min(len1-1,K / 2 - 1);
        int j = start_2 + Math.min(len2-1,K / 2 - 1);

        //如果数组1的中值小于数组2的中值
        if (nums1[i] <= nums2[j]) {
            return findKth(nums1, i + 1, end_1, nums2, start_2, end_2, K - (i - start_1 + 1));
        } else
            return findKth(nums1, start_1, end_1, nums2, j + 1, end_2, K - (j - start_2 + 1));
    }
}
