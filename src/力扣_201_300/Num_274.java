package 力扣_201_300;

import java.util.Arrays;

public class Num_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        int length = citations.length;
        int i=length-1;
        while(i >= 0 && citations[i] >= length - i){
            res = Math.max(res, length - i);
            i--;
        }
        return res;
    }
}
