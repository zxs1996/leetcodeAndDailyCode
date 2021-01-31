import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zxs666
 * @date 2020/12/6 15:21
 */
public class Num_5619 {
    private class MyCollection {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int curSize = 0;
        int disTance = 0;
        Set<Integer> set;

        MyCollection() {
            set = new HashSet<>();
        }

        public void put(int num) {
            curSize++;
            set.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
            disTance = max - min;
        }

        public void pop(int num) {
            curSize--;
            set.remove(num);
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int tmp : set) {
                min = Math.min(min, tmp);
                max = Math.max(max, tmp);
            }
            if (curSize == 0)
                disTance = 0;
            else
                disTance = max - min;
        }
    }

    int res = Integer.MAX_VALUE;
    int currentSum = 0;
    int time=0;
    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int perMax = n / k;
        MyCollection[] collections = new MyCollection[k];
        for (int i = 0; i < k; i++)
            collections[i] = new MyCollection();
        recurse(nums, 0, perMax, collections);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void recurse(int[] nums, int index, int perMax, MyCollection[] collections) {
        time++;
        if (currentSum >= res){

            return;

        }

        if (index == nums.length) {
            res = Math.min(res, currentSum);
            return;
        }

        //尝试往每个集合放
        for (int i = 0; i < collections.length; i++) {

            //该子集还可以继续放，并且该子集的不包含该元素
            if (collections[i].curSize != perMax && !collections[i].set.contains(nums[index])) {
                //放入
                currentSum -= collections[i].disTance;
                collections[i].put(nums[index]);
                currentSum += collections[i].disTance;
                recurse(nums, index + 1, perMax, collections);

                //取出
                currentSum -= collections[i].disTance;
                collections[i].pop(nums[index]);
                currentSum += collections[i].disTance;
            }
        }

    }

    public boolean isEqual(MyCollection c1, MyCollection c2) {
        if (c1.set.size() != c2.set.size())
            return false;
        if (c1.set.size() == 0)
            return false;
        System.out.println(c1.set);
        System.out.println(c2.set);

        for (int num : c1.set) {
            if (!c2.set.contains(num))
                return false;
        }
        return true;
    }


    @Test
    public void test() {
        int[] nums = {13, 4, 7, 3, 3, 1, 12, 9, 11, 10, 13, 3, 12, 7};
        long start = System.currentTimeMillis();
        int res = minimumIncompatibility(nums, 7);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(res);
        System.out.println(time);
    }
}
