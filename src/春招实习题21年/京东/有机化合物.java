package 春招实习题21年.京东;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zxs666
 * @date 2021/3/27 19:22
 */
public class 有机化合物 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        map.put('C', 12);
        map.put('H', 1);
        map.put('O', 16);
        map.put('N', 14);
        Character cur = null;
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //如果是数字，那么直接加到sb上
            if (c >= '0' && c <= '9') {
                if (cur != null)
                    sb.append(c);
            }

            //是字母
            else {
                if (cur != null) {
                    if (sb.length() > 0) {

                        sum += map.get(cur) * Integer.parseInt(sb.toString());
                    } else {
                        sum += map.get(cur);
                    }

                }
                sb = new StringBuffer();
                cur = c;
            }

        }

        if (cur != null) {
            if (sb.length() > 0) {
                sum += map.get(cur) * Integer.parseInt(sb.toString());
            } else {
                sum += map.get(cur);
            }
        }

    }

    @Test
    public void test(){
        ConcurrentHashMap goe;

        HashMap h;
        String s1="abcd";
        String s2=s1;
        System.out.println(s1==s2);
        s1="sdf ";
        System.out.println(s1==s2);
    }
}
