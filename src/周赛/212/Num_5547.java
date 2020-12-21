import org.junit.Test;

import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zxs666
 * @date 2020/10/25 10:56
 */
public class Num_5547 {

    @Test
    public void test1() {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0,0, 2};
        int[] r = {2, 3, 5};
        List<Boolean> res = checkArithmeticSubarrays2(nums, l, r);
        System.out.println(res.size());
       res.stream().forEach(a -> System.out.println(a));
    }


    //暴力解，待优化
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            //如果只有两个数据，那么一定是等差
            if (l[i] + 1 == r[i]) {
                list.add(true);
                continue;
            }
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i]+1);
            Arrays.sort(arr);

            boolean res = true;
            int distance = arr[1]-arr[0];
            for (int j = 2; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != distance) {
                    res = false;
                    break;
                }
            }
            list.add(res);
        }
        return list;
    }



    //优化不完全
    public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] l, int[] r) {

        sortLAndR(r, l);
        sortLAndR(l, r);
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            //如果只有两个数据，那么一定是等差
            if (l[i] + 1 == r[i]) {
                list.add(true);
                continue;
            }
            insertSort(nums, l[i], r[i]);
            boolean res = true;
            int distance = nums[l[i] + 1] - nums[l[i]];
            for (int j = l[i] + 2; j <= r[i]; j++) {
                if (nums[j] - nums[j - 1] != distance) {
                    res = false;
                    break;
                }
            }
            list.add(res);
        }
        return list;
    }

    //对给定数组从l到r按照插入排序
    public void insertSort(int[] nums, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int key = nums[i];
            int j = i - 1;
            for (; j >= l && nums[j] > key; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = key;
        }
    }

    //按照第一个数组大小排序，
    public void sortLAndR(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[j] < nums1[index]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(nums1, i, index);
                swap(nums2, i, index);
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
