package num_201_300;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/9/26 12:32
 */
//不能使用除法
public class Num_238 {

    @Test
    public void test() {
        int[] res = productExceptSelf2(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(res));
    }


    //使用额外的数组空间
    //开辟一个前缀乘积和一个后缀乘积
    //每一个位置上的元素除它本身的之外元素的乘积==前缀乘以后缀
    //res[i] =pre[i]*last[i]
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        //pre[i]表示从0~i的数组乘积
        int[] pre = new int[len];
        //last[i]表示从len-1~i的数组乘积
        int[] last = new int[len];
        pre[0] = nums[0];
        for (int i = 1; i < len; i++)
            pre[i] = pre[i - 1] * nums[i];
        last[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--)
            last[i] = last[i + 1] * nums[i];
        int[] res = new int[len];
        res[0] = last[1];
        res[len - 1] = pre[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = pre[i - 1] * last[i + 1];
        }
        return res;
    }

    //不使用额外的数组空间
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;//0左边没有元素，初始化为1
        //先计算res[i]表示以i结尾的左边数组元素乘积，不包括i这个元素
        for (int i = 1; i < len; i++)
            res[i] = res[i - 1] * nums[i - 1];

        //从右往左乘,用一个数R记录从len-1到i的乘积，res[i]=res[i]*R，即前缀乘以后缀
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * R;//当前i下标，等于res[i]表示i左边的元素乘积，R表示i右边的元素乘积
            R = R * nums[i];//将当前元素记录为右边乘积
        }
        return res;
    }


}
