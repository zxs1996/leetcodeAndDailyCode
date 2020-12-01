package num_1_100;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/6/18.
 * 最接近的三数之和
 */
public class Num_16 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 4, 8, 16, 32, 64, 128};
        int result = new Num_16().threeSumClosest(nums, 82);
        System.out.println(result);

    }

    public int threeSumClosest(int[] nums, int target) {
        //先进行一次排序
        Arrays.sort(nums);
        //初始化一个值
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
           // System.out.println(i+":"+ans);
            int start=i+1, end=nums.length-1;
            while(start<end){
                int sum=nums[i]+nums[start]+nums[end];
                //如果距离更小的话，那么更新ans
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                //根据sum和target的大小决定应该start++还是end--
                //注意这里比较的是sum和target，不是ans和target
                if(sum>target)
                    end--;
                else if(sum<target)
                    start++;
                //相等，直接返回
                else
                    return ans;
            }
        }
        return ans ;
    }

    //快排
    public static void quickSort(int[] nums, int i, int j) {
        if (i >= j)
            return;
        int low = i;
        int high = j;
        int key = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= key)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
        quickSort(nums, i, low - 1);
        quickSort(nums, low + 1, j);
    }


}
