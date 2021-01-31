import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxs666
 * @date 2021/1/3 10:32
 */
public class Num_5641 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int res = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            if (truckSize >= boxTypes[i][0]) {
                res += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                res += boxTypes[i][1] * truckSize;
                truckSize = 0;
            }

        }
        return res;
    }


}
