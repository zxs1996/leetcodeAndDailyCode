package algCourse;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/10/29 18:33
 * 9.3-6
 * 对一个含有n个元素的集合来说，所谓k分位数（the kth quantile），就是能把已排序的集合分成k个大小相等的集合的k-1个顺序统计量。
 * 给出一个能列出某一集合的k分位数的O(nlgk)时间的算法
 * 思路：递归以k为4举例：第一次k==4，那么去4/2=2，去找第2个划分点对应的数组元素(可以使用快排的找第i小元素思想)
 *    找到之后，再分别从左右两边递归找k=2的解，
 *    重复上述递归，一直到k=1，返回
 */
public class K_divide {

    @Test
    public void test2() {
        int N = 10;
        Random random = new Random();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = random.nextInt(100);
        System.out.println(Arrays.toString(nums));
        System.out.println(get_Ith(nums, 2, 7, 3));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int N = 18;
        Random random = new Random();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = random.nextInt(100);
        System.out.println(Arrays.toString(nums));
        int[] res = k_divide(nums, 3);
        for(int num:res)
            System.out.print(num+" ");
        Arrays.sort(nums);
        System.out.println();
        System.out.println(Arrays.toString(nums));

    }

    int index = 0;

    //对给定的数据进行
    public int[] k_divide(int[] nums, int k) {
        //如果不能完全划分，那么返回false
        if (nums.length % k != 0)
            return null;
        //否则进行划分;
        int[] res = new int[k - 1];
        k_divide_detail(nums, res, nums.length / k, k, 0, nums.length - 1);
        return res;
    }

    /**
     * @param nums  原数组
     * @param res   返回值
     * @param t     每个子集长度
     * @param k     当前划分数
     * @param start 开始下标
     * @param end   结束下标
     * @return
     */
    public void k_divide_detail(int[] nums, int[] res, int t, int k, int start, int end) {
        if (k <= 1)
            return;
        //如果是偶数，那么能刚好划分成两个
        if (k % 2 == 0) {
            int N_th = get_Ith(nums, start, end, k / 2 * t);
            res[index++] = N_th;
            //左边
            k_divide_detail(nums, res, t, k / 2, start, (end + start) / 2);
            //右边
            k_divide_detail(nums, res, t, k / 2, (end + start) / 2 + 1, end);
        }
        //是奇数
        else {
            int N_th = get_Ith(nums, start, end, k / 2 * t);
            res[index++] = N_th;
            //左边
            k_divide_detail(nums, res, t, k / 2, start, start + t * k / 2 - 1);
            //右边
            k_divide_detail(nums, res, t, k - k / 2, start + t * (k / 2), end);
        }

    }


    //找第i小的元素
    public int get_Ith(int[] nums, int start, int end, int i) {
        if (start == end)
            return nums[start];
        int p = partion(nums, start, end);
        int k = p - start + 1;
//        System.out.println(Arrays.toString(nums));
//        System.out.println("currentp:"+p+"   currentkey:"+k+"  ");
        if (k == i)
            return nums[p];
            //去右边找
        else if (k < i)
            return get_Ith(nums, p + 1, end, i - k);
        else
            return get_Ith(nums, start, p - 1, i);
    }

    //快排划分
    public int partion(int[] nums, int start, int end) {
        int key = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= key)
                swap(nums, j, ++i);
        }
        swap(nums, i + 1, end);//非常重要
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
