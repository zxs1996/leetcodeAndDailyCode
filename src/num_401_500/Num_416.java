package num_401_500;

import org.junit.Test;

import javax.xml.transform.Source;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.*;

public class Num_416 {


    @Test
    public void test1() {

        int sum=1241;
        int res1=sum&1;
        System.out.println(res1==1);

        int nums[] = {1, 2, 3, 4};
        boolean res = canPartition(nums);
        System.out.println(res);
    }


    /**
     * 二位数组，空间复杂度高。
     */

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums)
            sum+=num;
        if((sum&1)==1)
            return false;
        int half=sum/2;
        boolean[][] dp=new boolean[nums.length][half+1];
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        dp[0][0]=true;
        //第一个元素
        if(nums[0]<=half)
            dp[0][nums[0]]=true;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=1;j<=half;j++){
                //继承自前一轮计算结果
                dp[i][j]=dp[i-1][j];
                //当j>=nums[i]时，判断dp[i-1][j-nums[i]]
                if(j>=nums[i])
                    dp[i][j]=dp[i][j] ||dp[i-1][j-nums[i]];
            }
            if(dp[i][half])
                return true;
        }
        return dp[nums.length-1][half];
    }

    /**
     * 使用一维数组，降低空间复杂度
     * 注意使用一维数组时，必须从target开始往前遍历，如果1到target，那么在后面会用到更新后的值
     * @param nums
     * @return
     */
    public boolean canPartition22(int[] nums) {
        int sum=0;
        for(int num:nums)
            sum+=num;
        if((sum&1)==1)
            return false;
        int half=sum/2;
        boolean[] dp=new boolean[half+1];
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        dp[0]=true;//dp[i]表示当前循环前x个元素的时候，总和为i是否能够达到，x在循环的过程中隐式给出
        //第一个元素
        if(nums[0]<=half)
            dp[nums[0]]=true;
        for(int i=1;i<nums.length;i++)
        {
            //必须要从后往前，不然有可能会用到更新后的值,只用循环到nums[i]就行，因为再往前j-nums[i]就是负数了，下标必然不能为负数
            for(int j=half;j>=nums[i];j--)
                    dp[j]=dp[j] ||dp[j-nums[i]];

            if(dp[half])
                return true;
        }
        return dp[half];
    }

}
