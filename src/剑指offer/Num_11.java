package 剑指offer;

/**
 * Created by zxs666 on 2020/7/22.
 * 旋转数组的最小数字
 */
public class Num_11 {
    public int minArray(int[] numbers) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = numbers.length - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            res = Math.min(res, numbers[mid]);
            if (mid == 0) {
                l = mid + 1;
                continue;
            } else if (mid == numbers.length - 1) {
                r = mid - 1;
                continue;
            }

            //说明左边有序
            if (numbers[0] <= numbers[mid - 1]) {
                res = Math.min(res, numbers[0]);//指向左边最小值,去右边找
                l = mid + 1;
            }
            //左边无序，右边有序,指向右边最小值，去左边找
            else {
                if (mid < r)
                    res = Math.min(res, numbers[mid + 1]);//指向右边的最小值，去左边找
                r = mid - 1;
            }
        }
        res = Math.min(res, numbers[l]);
        res = Math.min(res, numbers[r]);
        return res;
    }
}
