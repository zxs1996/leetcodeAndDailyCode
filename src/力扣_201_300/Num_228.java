package 力扣_201_300;

import java.util.ArrayList;
import java.util.List;

public class Num_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int pre = nums[0];
        int i;
        for ( i=1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1)
                continue;
            //不连续了
            else {
                //如果只有一个数
                if (nums[i - 1] == pre)
                    res.add(pre + "");
                    //如果有两个数
                else
                    res.add(pre + "->" + nums[i - 1]);
                pre = nums[i];
            }

        }

        //循环结束，最后一个区间也要处理
        //如果只有一个数
        if (nums[i - 1] == pre)
            res.add(pre + "");
            //如果有两个数
        else
            res.add(pre + "->" + nums[i - 1]);
        return res;
    }
}
