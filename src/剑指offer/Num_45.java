package 剑指offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2021/3/12 22:18
 */
public class Num_45 {
    @Test
    public void test() {
        char[] arr={'1','2'};
        System.out.println(arr.toString());
        minNumber(new int[]{11, 22, 1});
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        //如果x+y>y+x,说明x更大，否则y更大
        //自定义排序如果第一个字符相同，那么比较两个字符串x y拼接后的大小
        //如果不同，直接按照大小排序
        Arrays.sort(strs, (str1, str2) -> {
            if (str1.charAt(0) == str2.charAt(0)) {
                return (str1 + str2).compareTo(str2 + str1);
            } else {
                return str1.charAt(0) - str2.charAt(0);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        char[] arr=new char[]{1,2};
     
        return sb.toString();
    }
}
