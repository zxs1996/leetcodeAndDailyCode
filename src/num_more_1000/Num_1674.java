package num_more_1000;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/12/4 10:25
 */
public class Num_1674 {

    @Test
    public void test(){

        System.out.println(Integer.MAX_VALUE);
        int[] nums={1,2,2,1};
        int res=minMoves(nums,2);
        System.out.println(res);

    }

    public int minMoves(int[] nums, int limit) {
        int max=limit*2;
        int minNumber=Integer.MAX_VALUE;
        int maxNumber=Integer.MIN_VALUE;
        for(int num:nums){
            minNumber=Math.min(minNumber,num);
            maxNumber=Math.max(maxNumber,num);
        }

        int[] needs=new int[max+1];
        for(int i=0;i<nums.length/2;i++){
            int ano=nums[nums.length-1-i];
            for(int j=maxNumber-nums[i]+1;j<=limit;j++)
                if(ano!=j)
                    needs[j+nums[i]]++;
        }
        System.out.println(Arrays.toString(needs));
        int res=Integer.MAX_VALUE;
        for(int i=maxNumber+1;i<=minNumber+limit;i++)
            res=Math.min(res,needs[i]);
        return res;
    }
}
