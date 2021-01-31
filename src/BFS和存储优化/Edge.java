package BFS和存储优化;

/**
 * @author zxs666
 * @date 2021/1/11 14:15
 */
public class Edge {
    boolean isVisited = false;//访问标志
    int iVex;//这条边的顶点i在顶点数组的下标
    int jVex;//顶点j在顶点数组的下标
    Edge iLink;//顶点i的下一条边
    Edge jLink;//顶点j的下一条边

    public Edge(int iVex, int jVex) {
        this.iVex = iVex;
        this.jVex = jVex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "isVisited=" + isVisited +
                ", iVex=" + iVex +
                ", jVex=" + jVex +
                ", iLink=" + iLink +
                ", jLink=" + jLink +
                '}';
    }
}
