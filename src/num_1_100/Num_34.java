package num_1_100;

/**
 * Created by zxs666 on 2020/7/1.
 */
public class Num_34 {
    int ans[] = {-1, -1};

    public static void main(String[] args) {
        int nums[]={5,7,7,8,8,10};
       int ans[]= new Num_34().searchRange(nums,8);
        System.out.println(ans[0]+","+ans[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return ans;
        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            //如果相等，那么说明找到了,分成左右两边递归渐进
            if (target == nums[mid]) {
                System.out.println();
                ans[0] = ans[1] = mid;
                selfSearch(nums, true, l, mid - 1, target);
                selfSearch(nums, false, mid + 1, r, target);
                break;
            }
            //目标值比中值小，去左边找
            else if (target < nums[mid])
                r = mid - 1;
                //目标值比中值大，去右边找
            else
                l = mid + 1;
        }
        return ans;
    }

    public void selfSearch(int nums[], boolean flag, int l, int r, int target) {
        if (l > r)
            return;
        int mid = (l + r) / 2;
        //目标值和中值等
        if (nums[mid] == target) {
            //如果是往左走
            if (flag) {
                ans[0] = mid;
                selfSearch(nums, true, l, mid - 1, target);
            }
            //往右走
            else {
                ans[1] = mid;
                selfSearch(nums, false, mid + 1, r, target);
            }
        }
        //目标值大于中值，去右边找
        else if (target > nums[mid])
            selfSearch(nums, flag, mid + 1, r, target);
        //目标值小于中值
        else selfSearch(nums, flag, l, mid - 1, target);
    }
}
