package 力扣_401_500;

import org.junit.Test;

public class Num_LCP_12 {

    @Test
    public void test(){
        int times[]={1,2,3,3,3};
        int res=minTime(times,2);

        System.out.println(res);
    }

    public int minTime(int[] time, int m) {
        int sum = 0;
        for (int ti : time)
            sum += ti;
        int left = 0;//最小边界
        int right = sum;//最大边界
        while (left < right) {
            int mid = left + (right - left) / 2;//这种写法不会整形溢出
            int splits = split(time, mid);
            if (splits > m)
                left = mid + 1;
            else right = mid;
        }
        return left;

    }

    public int split(int[] time, int maxValue) {
        //分割数最小为1
        int splits = 1;
        //当前分组的最大值
        int currentMax = 0;
        int currentVal = 0;
        for (int num : time) {
            currentMax = Math.max(currentMax, num);
            //如果今天使用的时间超过了maxValue,那么就划分成一个组
            if (currentVal + num - currentMax > maxValue) {
                splits++;
                currentVal = 0;
                currentMax = num;
            }
            currentVal += num;
        }
        return splits;
    }

}
