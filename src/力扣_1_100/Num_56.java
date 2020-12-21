package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/9.
 */
public class Num_56 {

    public static void main(String[] args) {
        int[][] intervals = {{15, 18}, {8, 10}, {2, 6}, {1, 3}};
        new Num_56().merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][2];
        //先排序
        quickSort(0, intervals.length - 1, intervals, 1);
        quickSort(0, intervals.length - 1, intervals, 0);

        int count = 0;
        int[][] res = new int[intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //这里是两个小于等于，防止两个一摸一样的区间重复
            if (intervals[i][0] <= end && end <= intervals[i][1])
                end = intervals[i][1];
            else {
                res[count][0] = start;
                res[count][1] = end;
                count++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res[count][0] = start;
        res[count][1] = end;
        count++;
        int[][] ans = new int[count][2];
        for (int i = 0; i < count; i++){
            ans[i][0] = res[i][0];
            ans[i][1] = res[i][1];
        }
        return ans;
    }


    public void quickSort(int l, int r, int[][] nums, int index) {
        if (l > r)
            return;
        int key = nums[l][index];
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j][index] >= key)
                j--;
            if (i < j)
                nums[i][index] = nums[j][index];
            while (i < j && nums[i][index] <= key)
                i++;
            if (i < j)
                nums[j][index] = nums[i][index];
        }
        nums[i][index] = key;
        quickSort(l, i - 1, nums, index);
        quickSort(i + 1, r, nums, index);
    }

}
