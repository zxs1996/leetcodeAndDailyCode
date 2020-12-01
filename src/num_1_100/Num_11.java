package num_1_100;

/**
 * Created by zxs666 on 2020/6/18.
 */
public class Num_11 {

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = new Num_11().maxArea2(height);
        System.out.println(result);
    }


    //暴力N²法
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        return max;
    }

    //双指针N法,头尾一个指针，每次移动较短的板。
    //每次移动之后，宽度减1，如果移动的是较长板，短板不变，那么高度不变或者变小，面积必然减小
    //如果移动的是较短板，那么短边可能会变长，面积相应变大。
    public int maxArea2(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
       while(i<j){
           max=Math.max(max,Math.min(height[i],height[j])*(j-i));
           if(height[i]<height[j])
               i++;
           else
               j--;
       }
       return max;
    }
}
