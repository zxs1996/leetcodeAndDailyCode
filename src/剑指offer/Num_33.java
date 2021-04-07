package 剑指offer;

/**
 * @author zxs666
 * @date 2021/3/28 23:39
 *
 * 判断一个数组是否是二叉搜索树的后续遍历
 * 后续遍历：左右根 ，每次最右节点是root，中间是右节点（全部大于root),左边是左节点(全部小于root)

 */
public class Num_33 {
    public boolean verifyPostorder(int[] postorder) {
        return lastOrder(postorder, 0, postorder.length - 1);
    }


    public boolean lastOrder(int[] postorder, int start, int end) {
        if (start >= end)
            return true;
        //确定当前层根节点
        int root = end;

        //从根节点往左， 找第一个小于根的节点。从这段开始也就是[right+1,end-1]是右节点
        int right = end - 1;
        while (right >= start && postorder[right] > postorder[root])
            right--;
        int p = start;
        //判断左边节点，即[start,right]是不是都小于root
        while (p <= right) {
            if (postorder[p] > postorder[root])
                return false;
            p++;
        }

        return lastOrder(postorder, start, right) && lastOrder(postorder, right + 1, end - 1);


    }
}
