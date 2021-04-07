package 二分算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2021/3/8 15:48
 */
public class findX {

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6};
        int[] res = findX(arr, 5);
        System.out.println(Arrays.toString(res));
    }

    /**
     * @param arr
     * @param x
     * @return 以数组的方式返回左右边界
     */
    public int[] findX(int[] arr, int x) {
        //1、先二分找到一个x
        int mid = find(arr, x);

        //2、从下标[0,mid]之间二分的查找最最左边界
        int left = findLeft(arr, mid, x);
        //3、从下标[mid,arr.length]之间二分的查找最右边界
        int right = findRight(arr, mid, x);

        //返回结果
        return new int[]{left, right};
    }


    /**
     * 找x出现的位置
     *
     * @param arr
     * @param x
     * @return
     */
    public int find(int[] arr, int x) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        //找不到返回-1
        return -1;
    }

    /**
     * 在0到right这个范围找最左边的x
     *
     * @param arr
     * @param right
     * @param x
     * @return
     */
    public int findLeft(int[] arr, int right, int x) {

        int left = 0;
        int res = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return res;
    }

    /**
     * 从left到arr.length-1找最右边的x
     *
     * @param arr
     * @param left
     * @param x
     * @return
     */
    public int findRight(int[] arr, int left, int x) {
        int right = arr.length - 1;
        int res = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                res = mid;
                left = mid + 1;
            } else if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return res;
    }
}
