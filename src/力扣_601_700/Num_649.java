package 力扣_601_700;

/**
 * @author zxs666
 * @date 2020/12/11 11:00
 */
public class Num_649 {
    public String predictPartyVictory(String senate) {

        char[] arr = senate.toCharArray();
        //当前被禁止权利的两类参议员数量
        int disableR = 0;
        int disableD = 0;
        while (true) {
            //本轮过后剩余的两类参议员数量。
            int Rcount = 0;
            int Dcount = 0;
            for (int i = 0; i < arr.length; i++) {
                //无权利
                if (arr[i] == '0')
                    continue;
                char c = arr[i];
                if (c == 'R') {
                    if (disableR > 0) {
                        disableR--;
                        arr[i] = '0';
                    } else {
                        Rcount++;
                        disableD++;
                    }
                }

                if (c == 'D') {
                    if (disableD > 0) {
                        disableD--;
                        arr[i] = '0';
                    } else {
                        Dcount++;
                        disableR++;
                    }
                }
            }

            //这里不能直接判断Rcount数量，还要考虑disableR的数量，
            //有可能这些数量作用于前面的参议员，但是本轮循环用不到
            if (Rcount - disableR <= 0)
                return "Dire";
            else if (Dcount - disableD <= 0)
                return "Radiant";
        }

    }
}
