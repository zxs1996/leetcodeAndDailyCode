import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/12/6 10:37
 */
public class Num_5618 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = 0;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                res++;
                l++;
                r--;
            } else if (nums[l] + nums[r] < k)
                l++;
            else r--;
        }
        return res;
    }
}
