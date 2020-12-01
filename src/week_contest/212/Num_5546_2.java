import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/10/25 10:40
 */
public class Num_5546_2 {

    @Test
    public void test2(){
        int[] releaseTimes=new int[]{9,29,49,50};
        System.out.println(slowestKey(releaseTimes,"cbcd"));
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char longChar = keysPressed.charAt(0);
        int length = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            char c = keysPressed.charAt(i);
            int tempLength = releaseTimes[i] - releaseTimes[i - 1];
            if (tempLength == length)
                longChar = longChar > c ? longChar : c;
            else if(tempLength>length)
            {
                length=tempLength;
                longChar=c;
            }
        }
        return longChar;
    }
}
