package 力扣_101_200;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_119 {
    public static void main(String[] args) {
        List<Integer> res = new Num_119().getRow(3);
        for (int i : res
                )
            System.out.println(i + " ");
    }

    public List<Integer> getRow(int rowIndex) {
        Integer res[] = new Integer[rowIndex + 1];
        res[0] = 1;
        int beforeTemp;//保存上一个
        int currentTemp;//当前j
        for (int i = 1; i <= rowIndex; i++) {
            beforeTemp = 1;
            for (int j = 1; j < i; j++) {
                currentTemp = res[j];
                res[j] = beforeTemp + res[j];
                beforeTemp = currentTemp;
            }
            res[i] = 1;
        }
        return Arrays.asList(res);
    }
}
