import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/20 10:33
 */
public class Num_5629 {

    @Test
    public void test1() {
        String str = "--17-5 229 35-39475";

        System.out.println(reformatNumber(str));
    }

    public String reformatNumber(String number) {
        number = number.replace("-", "");
        number = number.replace(" ", "");
        StringBuffer res = new StringBuffer("");
        while (number.length() > 4) {
            res.append(number.substring(0, 3) + "-");
            number = number.substring(3);
        }
        if (number.length() == 4) {
            res.append(number.substring(0, 2) + "-").append(number.substring(2, 4));
        } else
            res.append(number);
        return res.toString();
    }
}
