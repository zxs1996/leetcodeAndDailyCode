import com.sun.javafx.image.BytePixelSetter;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/12/4 19:02
 * 对数组求和，渐进寻找
 */
public class Num_1658 {

    @Test
    public void test() {
        int[] nums = {1,1,4,2,3};
        int res = minOperations(nums, 5);
        System.out.println(res);

    }

    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];
        //是不是特殊情况
        if(sum[n-1]==x)
            return n;
        if(sum[n-1]<x)
            return -1;

        //从左边找，找到大于x的sum[left]
        int left = 0, right =n;
        for(int i=0;i<n;i++){
            if(sum[i]>=x){
                left=i+1;
                break;
            }
        }
        int res = Integer.MAX_VALUE;

        //往左边渐进，中间不断更新res
        while (left >= 0&&left<right) {
            int leftSum=sum[left]-nums[left];//nums[left]不算在内
            int rightSum = sum[n-1] - sum[right-1];//从right到n-1都算在内
            if (leftSum + rightSum == x){
                left--;
                right--;
                res = Math.min(res, left  + n - right);
            }
            else if (leftSum+ rightSum < x) {
                right--;
            }
            else {
                left--;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
