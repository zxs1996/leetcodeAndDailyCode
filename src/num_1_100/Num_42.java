package num_1_100;

/**
 * Created by zxs666 on 2020/7/5.
 */
public class Num_42 {

    public int trap(int[] height) {

        int sum = 0;
        int left = -1, right = -1;
        int temp = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                //如果左边界为-1，说明无左边界
                if (left == -1)
                    left = i;
                    //如果左边界不为0，并且该高度高于左边界，那么将temp加到sum上去
                else if (left != -1 && height[i] >= height[left]) {
                    sum += temp;
                    temp = 0;
                    //重新更新左边界
                    left=i;
                }
                //没有到达边界，计算体积临时装入temp
                else {
                    temp += height[left] - height[i];
                }
            }
        }
        return sum;
    }
}
