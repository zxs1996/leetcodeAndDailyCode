package 力扣_201_300;

public class Num_292 {



    //简单博弈：列表可知，当n是4的倍数时，会输掉，其余情况都可以赢

    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}
