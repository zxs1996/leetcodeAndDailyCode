package num_201_300;

import org.junit.Test;

public class Num_263 {
    @Test
    public void test(){
        System.out.println(isUgly(14));
    }
    public boolean isUgly(int num) {
        if(num<=0)
            return false;

        while (num >= 5) {
            if (num % 2 == 0) {
                num /=2;
                continue;
            } else if (num % 3 == 0) {
                num /= 3;
                continue;
            } else if (num % 5 == 0) {
                num /= 5;
                continue;
            } else if (num > 5)
                return false;
        }
        return true;

    }
}
