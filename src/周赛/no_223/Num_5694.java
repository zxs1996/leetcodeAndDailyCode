package 周赛.no_223;

/**
 * @author zxs666
 * @date 2021/1/10 10:31
 */
public class Num_5694 {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] res = new int[n+1];
        res[0]=first;
        for(int i=1;i<n+1;i++){
            res[i]=encoded[i-1]^res[i-1];
        }
        return res;
    }
}
