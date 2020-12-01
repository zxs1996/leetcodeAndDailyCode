import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/10/18 10:40
 */
public class Num_5545 {


    @Test
    public void test1(){
        int[] scores=new int[]{4,5,6,5};
        int[] ages=new int[]{2,1,2,1};
        System.out.println(bestTeamScore(scores,ages));
    }
    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        //先按照age排一次序
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j + 1 < n; j++) {
                if (ages[j] > ages[j + 1]) {
                    swap(ages, j, j + 1);
                    swap(scores, j, j + 1);
                }
            }


        if (n == 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = scores[0];

        for (int i = 1; i < n; i++) {
            int nextMaxIndex = i;
            int chooseSum = scores[i];
            for (int j = i - 1; j >= 0; j--) {
                if (scores[j] > scores[nextMaxIndex])
                    continue;
                else {
                    chooseSum += scores[j];
                    nextMaxIndex = j;
                }
            }
            dp[i] = Math.max(chooseSum, dp[i - 1]);
        }
        return dp[n - 1];
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
