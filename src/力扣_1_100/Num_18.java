package 力扣_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/5.
 * <p>
 * 四数之和，利用三数之和的变形。
 */
public class Num_18 {

    public static void main(String[] args) {
        int nums[]={0,4,-5,2,-2,4,2,-1,4};
        List<List<Integer>> ans=new Num_18().fourSum(nums,12);
        System.out.println("答案"+ans.size());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;
        int n = nums.length;
        Arrays.sort(nums);
        //最外层循环
        for (int i = 0; i < n - 3; i++) {
            //如果和前一个值相等，直接continue
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            //优化,如果前4个值小于大于target，直接break
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            //优化,如果nums[i]+最后3个值小于target，直接continue
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target)
                continue;
            //内层循环
            for (int j = i + 1; j < n - 2; j++) {
                //和前一个值相等时
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                //最小值都大于target，直接break
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                //最大值都小于target，直接continue
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target)
                    continue;
                int k = j + 1, h = n - 1;
                //双指针从两端渐进
                while (k < h) {
                    int value = nums[i] + nums[j] + nums[k] + nums[h];
                    if (value == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                        //去重
                        while (++k < h && nums[k] == nums[k - 1]) ;
                        while (k < --h && nums[h] == nums[h + 1]) ;
                    } else if (value > target)
                        --h;
                    else
                        ++k ;
                }
            }
        }
        return res;
    }

}
