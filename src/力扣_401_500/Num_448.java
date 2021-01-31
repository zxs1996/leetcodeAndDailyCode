package 力扣_401_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zxs666
 * @date 2021/1/2 23:41
 */
public class Num_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            //如果位置不正确，那么交换到正确的位置上去
            while(nums[i]!=i+1&&nums[nums[i]-1]!=nums[i])
                swap(nums,i,nums[i]-1);
        }

        List<Integer> res=new ArrayList();
        for(int i=0;i<n;i++)
            if(nums[i]!=i+1)
                res.add(i+1);
        return res;

    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
