package 力扣_301_400;

/**
 * @author zxs666
 * @date 2020/12/29 16:12
 */
public class Num_330 {
    public int minPatches(int[] nums, int n) {
        //max表示当前能够到达的区间 [0,max)
        int max = 1;
        //i表示当前的下标
        int i = 0, res = 0;
        while (max <= n) {
            //如果当前元素小于max，那么直接在max的基础上+nums[i]，表示能够到达新区间
            if (i < nums.length && nums[i] <= max)
                max += nums[i++];
                //否则需要插入一个数，这个数为max
                //比如现在为[0,5)，当前数为8，前面的数+8就是[0,5)+[8,13),中间[6,7]区间被丢掉了，那么需要补上5这个数字
            else {
                max += max;
                res++;
            }
        }
        return res;
    }
}
