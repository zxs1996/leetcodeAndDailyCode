

/*
并查集
 */
public class UnionSearch {

    int[] pre;

    public UnionSearch(int n) {
        pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = i;
    }

    public int unionSearch(int root) {
        int root2 = root;
        //一直往上找，直到找到他的最高领导人
        while (root != pre[root])
            root = pre[root];

        //路径压缩,将从root往上找这个过程中所有的元素都设为最高领导人直接管理，方便下次查询
        while (root2 != root) {
            int temp = pre[root2];//记录它的上级
            pre[root2] = root;//将当前元素直接设置为最高领导人管理
            root2 = temp;//对它之前的上级做相同操作
        }
        return root;
    }


    //合并
    public void join(int x, int y) {
        int root1 = unionSearch(x);
        int root2 = unionSearch(y);
        if (root1 != root2)
            pre[root1] = root2;
    }
}
