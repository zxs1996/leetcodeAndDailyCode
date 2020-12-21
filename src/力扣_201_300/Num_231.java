package 力扣_201_300;

public class Num_231{
    public static void main(String[] args) {
        double a=Math.log(8);
        double b=Math.log(2);
        System.out.println(a/b);

    }
    public boolean isPowerOfTwo(int n) {
        if(n==0)
            return false;
        double a=Math.log(n);
        double b=Math.log(2);
        int res=(int)(a/b);
        return Math.pow(2,res)==n;

    }
}
