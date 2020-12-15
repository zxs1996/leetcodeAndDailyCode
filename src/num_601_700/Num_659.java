package num_601_700;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/12/4 16:41
 */
public class Num_659 {

    @Test
    public void test() {
        int[] nums = {1,2,3,3,4,5};
        boolean res = isPossible2(nums);
        System.out.println(res);
    }


    //使用数组来实现
    public boolean isPossible(int[] nums) {
        //计算每个数字出现的次数
        int[] count = new int[nums[nums.length - 1] + 1];
        for (int num : nums)
            count[num]++;
        //剩下没用过的数字的个数
        int leftCount = nums.length;

        int length=0;
        //当剩下的数字个数大于0
        while (leftCount > 0) {
            length=0;//当前串长度
            for (int i = 1; leftCount > 0 && i < count.length; i++) {
                    //如果当前数字为0，并且length为0，那么continue
                if(count[i]==0&&length==0)
                    continue;;
                    //如果当前的数字计数小于等于前一个(前一个已经-1了）,
                    // 那么当前数字不能添加到序列中，不然前一个数字会用不完
                    //比如 1 2 3 3 4 5，到4，就不能往前面
                if (i > 1 && count[i] <= count[i - 1]) {
                    //如果长度小于3，那么直接返回false
                    if (length < 3)
                        return false;
                    //否则break,在进行下一轮循环
                   break;
                }
                //否则将当前这个数字加入到序列中，修改 count  length leftCount
                else {
                    count[i]--;
                    length++;
                    leftCount--;
                }
            }
        }
        //最后一轮出来的时候，根据length判断返回结果
        return length>=3;

    }

    //使用hash表来实现，这速度还不如我上面写的贪心呢
    public boolean isPossible2(int[] nums){
        Map<Integer,Integer> countMap=new HashMap<>();//记录每个数字的次数
        Map<Integer,Integer> endMap=new HashMap<>();//记录以每个数字结尾的次数
        for(int num:nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
            endMap.put(num,0);
        }

        for(int num:nums){
            int count=countMap.get(num);
            if(count>0){
                //如果有以num-1结尾的子序列，那么可以加上去
                if(endMap.containsKey(num-1)&&endMap.get(num-1)>0){
                    endMap.put(num-1,endMap.get(num-1)-1);
                    endMap.put(num,endMap.get(num)+1);
                    //num的计数-1
                    countMap.put(num,countMap.get(num)-1);
                }
                //否则没有num-1结尾的子序列
                else{
                    //需要从num开始重新建子序列，判断num后面的两个数是不是大于1
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        endMap.put(num+2,endMap.get(num+2)+1);
                        countMap.put(num,countMap.get(num)-1);
                        countMap.put(num+1,countMap.get(num+1)-1);
                        countMap.put(num+2,countMap.get(num+2)-1);
                    }
                    else
                        return false;
                }

            }

        }
        return true;
    }
}
