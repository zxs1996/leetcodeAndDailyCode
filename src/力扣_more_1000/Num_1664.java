package 力扣_more_1000;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/4 11:24
 */
public class Num_1664 {

    @Test
    public void test(){
        int[] nums={1,2,3};
        int res=waysToMakeFair(nums);
        System.out.println(res);
    }
    public int waysToMakeFair(int[] nums) {
        int[] oddSum=new int[nums.length];
        int[] evenSum=new int[nums.length];
        int n=nums.length;
        if(n==1)
            return 1;
        if(n==2)
            return 0;
        evenSum[0]=nums[0];
        evenSum[1]=nums[0];
        oddSum[0]=0;
        oddSum[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            if(i%2==0){
                    evenSum[i]=evenSum[i-2]+nums[i];
                    oddSum[i]=oddSum[i-1];
            }
            else {
                oddSum[i]=oddSum[i-2]+nums[i];
                evenSum[i]=evenSum[i-1];
            }

        }
       /* System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(oddSum));
        System.out.println(Arrays.toString(evenSum));*/
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){

                if(evenSum[n-1]-evenSum[0]==oddSum[n-1])
                    res++;
            }
            else{
                    int sum1=evenSum[i-1]+oddSum[n-1]-oddSum[i];
                    int sum2=oddSum[i-1]+evenSum[n-1]-evenSum[i];
                    System.out.println("i:"+i+",sum1:"+sum1+",sum2:"+sum2);
                    if(sum1==sum2)
                     res++;
            }
        }
    return res;
    }
}
