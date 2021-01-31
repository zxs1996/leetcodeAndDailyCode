import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/12/20 11:29
 */
public class Num_5632 {

    public static void main(String[] args) {

    }


    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[queries.length];

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] tmp = edgeList[i];
            if (tmp[0] > tmp[1]) {
                int t = tmp[0];
                tmp[0] = tmp[1];
                tmp[1] = t;
            }

            matrix[tmp[0]][tmp[1]] = tmp[2];
        }
        return null;
    }
}
