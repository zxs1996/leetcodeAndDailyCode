package 力扣_201_300;

/**
 * @author zxs666
 * @date 2020/12/3 10:25
 *统计所有小于非负整数 n 的质数的数量。
 * 空间换时间，
 *
 */
public class Num_204 {

    public int countPrimes(int n) {
        if(n<3)
            return 0;
        boolean[] flag=new boolean[n];//false表示质数，true表示合数
        int res=0;
        for(int i=2;i<n;i++){
            if(!flag[i])//如果是质数，那么res++
            {  res++;
                //将该数的倍数全部设置为false,非质数
                for(int j=1;j*i<n;j++)
                    flag[j*i]=true;
            }
        }
        return res;

    }
}
