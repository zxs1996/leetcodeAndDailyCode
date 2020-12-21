package 周赛.Num_198;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num5464_changeWink {
    public static void main(String[] args) {
        System.out.println(new Num5464_changeWink().numWaterBottles(9, 3));
    }

    int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            //可换购的酒
            int changeCount = numBottles / numExchange;
            //下一次的瓶子
            numBottles = changeCount + numBottles %numExchange;
            res += changeCount;
        }
        return res;
    }
}
