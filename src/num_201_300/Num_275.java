package num_201_300;

import org.junit.Test;

//本题是274的进阶，保证了数组有序，要求时间复杂度是对数级别
//二分法
public class Num_275 {

    @Test
    public void demo() {
        int nums[] = {4, 5, 6};
        System.out.println(hIndex(nums));
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int length = citations.length;
        int l = 0, r = length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            //如果当前mid对应的位置属于H指标的范围，那么往左渐进
            if (citations[mid] >= length - mid)
                r = mid - 1;
            else
                l = mid + 1;
        }
        //最后根据l对应的位置决定返回的H指数
        if (citations[l] >= length - l)
            return length - l;
        else
            return length - l - 1;
    }
}
