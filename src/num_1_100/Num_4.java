package num_1_100;

import org.junit.Test;

import javax.security.auth.kerberos.KerberosKey;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/11/15 20:56
 *
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //如果是奇数
        if ((m + n) % 2 == 1)
            return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (m + n + 1) / 2);
            //偶数
        else {
            double res1 = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (m + n) / 2);
            double res2 = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (m + n + 1) / 2 + 1);
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
}
