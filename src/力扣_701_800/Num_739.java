package 力扣_701_800;

import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/12/23 23:54
 * 这道题的常规思路肯定就是重循环暴力，但是会超时
 */
public class Num_739 {


    /**
     * 使用栈实现，栈记录的顺序递增的元素，从后往前
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack();//记录栈顶元素
        Stack<Integer> countStack = new Stack();//记录这个元素到比它大的元素的第一个元素之间隔了多远
        //比如75 71 69 72 76
        //当栈顶为71 76时，countStack为 2 1,因为71和72之间间隔了一个69
        for (int i = T.length - 1; i >= 0; i--) {
            int count = 1;//定义一个最小其实距离
            //当栈顶元素小于当前元素时，栈顶元素出栈。这相当于一直在栈里找第一个比当前元素大的数字。
            //注意我们用了一个数字记录
            while (!stack.isEmpty() && stack.peek() <= T[i]) {
                stack.pop();
                count += countStack.pop();//加上间隔
            }
            if (!stack.isEmpty()) {
                res[i] = count;
                stack.push(T[i]);
                countStack.push(count);
            } else {
                stack.push(T[i]);
                countStack.push(1);
            }

        }
        return res;
    }


    /**
     * 使用标志数组实现，我们发现温度从30-100，那么开一个100的数组flag
     * flag[23]=5，表示温度为23的最近出现的下标，从后往前遍历，
     * 对于每个温度，比如56，我找flag[57]~flag[100]，看谁出现的最早，那么就是56需要等待的天数
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int n=T.length;
        int[] res=new int[n];
        int[] tempDay=new int[101];//tempDay[i]表示温度为i最近一次出现的位置
        for(int i=n-1;i>=0;i--){
            tempDay[T[i]]=i;
            for(int j=T[i]+1;j<101;j++){
                if(tempDay[j]!=0){
                    if(res[i]==0)
                        res[i]=tempDay[j]-i;
                    else
                        res[i]=Math.min(res[i],tempDay[j]-i);
                }
            }
        }
        return res;
    }


}
