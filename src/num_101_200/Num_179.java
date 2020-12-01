package num_101_200;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_179 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public String largestNumber(int[] nums) {
        int index = 0;
        int firstNumber = 0;
        for (int times = 0; times < nums.length; times++) {
            index = -1;//每次初始化为-1
            firstNumber = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == -1)
                    continue;
                //如果等于0，并且index=-1,那么让index指向j
                if (nums[j] == 0 && index == -1)
                    index = j;
                //获取nums[j]的第一个数字
                int theNumber = Integer.parseInt(String.valueOf(nums[j]).charAt(0) + "");
                //如果小于，那么continue
                if (theNumber < firstNumber)
                    continue;
                    //如果大于等于
                else {

                }

            }
        }
        return null;
    }

    //返回true,说明num1比num2更优，反之num2更优
    public boolean compare(int num1, int num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        int length = Math.min(s1.length(), s2.length());
        int i = 0;
        for (; i < length; i++) {
            if (s1.charAt(i) > s2.charAt(i))
                return true;
            else if (s1.charAt(i) < s2.charAt(i))
                return false;
        }
        //如果num1<num2,说明num2是更长的
        if (num1 < num2) {
            if (s2.charAt(i) >= s2.charAt(0))
                return false;
            else
                return true;
        }

        else if (num1 > num2) {
            if (s1.charAt(i) >= s1.charAt(0))
                return true;
            else
                return false;
        }
        return true;


    }

}
