/**
 * @author zxs666
 * @date 2020/12/26 22:48
 */
public class Num_5622 {

    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        double curTime = 0;
        for(int i=0;i<customers.length;i++)
        {
            curTime=Math.max(curTime,customers[i][0]);
            curTime=curTime+customers[i][1];
            sum+=(curTime-customers[i][0]);
        }
        return sum/customers.length;
    }
}
