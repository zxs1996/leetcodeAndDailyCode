package 力扣_401_500;

import org.junit.Before;


/**
 * @author zxs666
 * @date 2021/2/3 16:01
 * 字典序，其实就是一颗十叉树
 * 计算当前节点的子树（包括当前节点）总个数count，
 * 如果当前节点的次序p+count>k,第k大元素落在当前子树下面
 * 如果p+count<=k,那么第k大元素，落在当前节点的兄弟节点上
 *
 */
public class Num_440 {
    public int findKthNumber(int n, int k) {
        long prefix = 1;//选择1作为前缀
        long p = 1;//表示当前是第p个，初始为1，所以是第一个
        while (p < k) {
            long count = getCount(prefix, n);
            //第k个数在当前前缀下,在当前子树下找
            if (p + count > k) {
                prefix *= 10;//*10相当于去到子树第一个节点 0开头的
                p++;//P往后移动一位
            }
            //第k个数在不在当前前缀下或者刚好相等，去右边棵树找
            else if(p+count<=k){
                prefix++;
                p+=count;//p往后移动count位
            }
        }
        return (int)prefix;
    }

    /**
     * 计算当前节点前缀的子树节点总和
     * @param prefix
     * @param n
     * @return
     */
    public long getCount(long prefix, long n) {
        long cur = prefix;
        long next = prefix + 1;
        long count = 0;
        while (cur <= n) {
            //next不能超过上界,所以取n+1和next的较小值，为什么是n+1，比如n=195，cur=100，next=100，从100到195之间其实有96个数
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
