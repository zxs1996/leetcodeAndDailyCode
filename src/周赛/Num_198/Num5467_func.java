package 周赛.Num_198;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num5467_func {
    public int closestToTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return target;
        if (target == 0)
            return 0;
        Arrays.sort(arr);
        int min = Math.abs(arr[0] - target);
        int start = 0;
        int end = 0;
        int currentSum = arr[0];
        while (start <= end && end < arr.length) {
            if (currentSum - target == 0)
                return 0;
            int temp1 = min;
            int temp2 = min;
            //end往后移动
            if (end < arr.length - 1)
                temp1 = Math.abs(currentSum + arr[end + 1] - target);
            //start往后移动
            if (start < end)
                temp2 = Math.abs(currentSum - arr[start] - target);
            //如果end+1.能更优，那么执行
            if (temp1 < min && temp1 < temp2) {
                min = temp1;
                currentSum += arr[end + 1];
                end++;

            }
            //如果start+1.能更优，那么执行
            else if (temp2 < min && temp2 < temp1) {
                min = temp2;
                currentSum -= arr[start];
                start++;
            }
            //如果两个都不满足
            else {
                if (currentSum - target > 0) {
                    currentSum -= arr[start];
                    start++;

                } else {
                    currentSum += arr[end + 1];
                    end++;
                }
            }
        }
        return min;
    }
}
