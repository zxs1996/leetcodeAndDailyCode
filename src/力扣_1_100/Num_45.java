package 力扣_1_100;

/**
 * @author zxs666
 * @date 2021/2/20 21:44
 */
public class Num_45 {
    public int jump(int[] nums) {
        if(nums.length==0||nums.length==1)
            return 0;
        int cur = 0;
        int res = 0;
        while (true) {
            if (cur + nums[cur] >= nums.length - 1)
                return res + 1;
            int step = nums[cur];
            int maxIndex = cur + 1;
            for (int i = cur + 1; i <= cur + step; i++) {
                if (nums[i] + i > maxIndex + nums[maxIndex])
                    maxIndex = i;
            }
            res++;
            cur = maxIndex;
        }
    }
}
