package 力扣_101_200;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/29.
 */
public class Num_165 {
    public static void main(String[] args) {
        String s="0.1.2.3.4";
        String arr[]=s.split("\\.");
        for (String str:arr) {
            System.out.println("分割:"+str);
        }
        System.out.println(Arrays.toString(arr));
    }
    public int compareVersion(String version1, String version2) {
        String[] arr1, arr2;
        if (version1.contains("."))
            arr1 = version1.split("\\.");//按照.分割需要使用\\转义
        else {
            arr1 = new String[1];
            arr1[0] = version1;
        }
        if (version2.contains("."))
            arr2 = version2.split("\\.");
        else {
            arr2 = new String[1];
            arr2[0] = version2;
        }
        int i;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        for (i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            if (Integer.parseInt(arr1[i]) == Integer.parseInt(arr2[i]))
                continue;
            else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]))
                return 1;
            else return -1;
        }
        if (i == arr1.length) {
            for (; i < arr2.length; i++)
                if (Integer.parseInt(arr2[i]) != 0)
                    return -1;
        } else if (i == arr2.length) {
            for (; i < arr1.length; i++)
                if (Integer.parseInt(arr1[i]) != 0)
                    return 1;
        }
        return 0;
    }
}
