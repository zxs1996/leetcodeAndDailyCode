package num_201_300;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_229 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    //摩尔投票法，跟找超过半数的元素原理一样，这不过这里每次找三个元素
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null )
            return res;
        int key1 = nums[0], key2 = nums[0];//都指向第一个候选人，但是票数为0，相当于未投票
        int count1 = 0, count2 = 0;//初始化票数为0
        for (int num : nums) {
            //和第一个候选人相同
            if (key1 == num) {
                count1++;
                continue;
            }
            //和第二个候选人相同
            if (key2 == num) {
                count2++;
                continue;
            }
            //和两个候选人都不相同，看候选人有没有空的，有的话填进去
            if (count1 == 0) {
                key1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                key2 = num;
                count2++;
                continue;
            }
            //不和两个里面任何一个候选人相同，并且两个候选人都不空，那么出现三个候选人，抵消一票
            count1--;
            count2--;
        }

        //统计两个候选人的票数，看是否超过n/3
        count1 = count2 = 0;
        for (int num : nums) {
            if (key1 == num)
                count1++;
            else if (key2 == num)
                count2++;
        }
        if (count1 > nums.length / 3)
            res.add(key1);
        if (count2 > nums.length / 3)
            res.add(key2);
        return res;
    }


}