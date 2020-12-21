package 回溯算法;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zxs666
 * @date 2020/12/1 22:39
 */
public class JobAllocationTest {

    @Test
    public void test(){
        int[][] spend={{10, 2 ,3},{  2, 3, 4},{ 3 ,4 ,5}};
        int res=new JobAllocation().jobAllocate(spend);
        System.out.println(res);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        recurse(nums,0,res,new ArrayDeque<>());

        return res;
    }

    public void recurse(int[]nums, int cur, List<List<Integer>>res, Deque<Integer> path){
        if(cur==nums.length)
        {
            res.add(new ArrayList(path));
            return ;
        }
        for(int i=cur;i<nums.length;i++){
            swap(nums,cur,i);
            path.addLast(nums[cur]);
            recurse(nums,cur+1,res,path);
            path.removeLast();
        }
    }



    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
