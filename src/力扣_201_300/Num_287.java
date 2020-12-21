package 力扣_201_300;

import org.junit.Test;

public class Num_287 {

    @Test
    public void demo() {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    //可以用链表判断是否有环来处理，比如nums[0]=1，nums[1]=4,1指向4，
    // 因为有重复元素，所以必然有不同的下标指向同一个值，也就构成了环
    //关于回环找入口的问题
    //s2=2s1,s2=s1+nb  s1=nb  a+nb一定是入口点
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }
        System.out.println(slow);
        int find = 0;
        slow = nums[slow];
        while (find != slow) {
            find = nums[find];
            slow = nums[slow];
        }
        return find;
    }
}
