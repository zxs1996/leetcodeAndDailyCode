package BFS和存储优化;

import java.security.spec.ECGenParameterSpec;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author zxs666
 * @date 2021/1/11 14:17
 */
public class Graph {

    Vertex[] vexArr;//顶点数组

    /**
     * 创建图
     *
     * @param vertexInfoList
     * @param edgeInfo
     */
    public void createGraph(List<Character> vertexInfoList, char[][] edgeInfo) {
        vexArr = new Vertex[vertexInfoList.size()];
        //1、创建顶点数组
        for (int i = 0; i < vertexInfoList.size(); i++)
            vexArr[i] = new Vertex(vertexInfoList.get(i));

        //2、根据边表创建信息
        for (char[] arr : edgeInfo) {
            //2.1先找到这个边对应的两个顶点的下标
            int iVex = 0, jVex = 0;
            while (vexArr[iVex].c != arr[0])
                iVex++;
            while (vexArr[jVex].c != arr[1])
                jVex++;
            //2.2 创建边
            Edge edge = new Edge(iVex, jVex);
            //2.3 将边插入
            insertEdge(iVex, jVex, edge);
        }
    }


    /**
     * 往图里面插入边，
     *
     * @param iVex 顶点1 下标
     * @param jVex 顶点2 下标
     * @param edge 边
     */
    private void insertEdge(int iVex, int jVex, Edge edge) {


        //维护iVex
        if (vexArr[iVex].firstEdge != null) {
            edge.iLink = vexArr[iVex].firstEdge;
        }
        vexArr[iVex].firstEdge = edge;


        //维护jVex
        if (vexArr[jVex].firstEdge != null)
            edge.jLink = vexArr[jVex].firstEdge;
        vexArr[jVex].firstEdge = edge;
    }

    /**
     * 返回bfs结果
     * @return
     */

    public String bfs() {
        boolean[] visited = new boolean[vexArr.length];
        StringBuffer sb = new StringBuffer();
        //1、辅助队列
        Queue<Integer> queue = new ArrayDeque<>();
        //从每个节点开始
        for (int i = 0; i < vexArr.length; i++) {
            //如果被访问过，那么continue
            if (visited[i])
                continue;
            //否则从这个点开始bfs
            queue.add(i);
            visited[i]=true;
            while (!queue.isEmpty()) {
                System.out.print(sb+",");
                System.out.print("[");
                for(int j:queue)
                    System.out.print(" "+vexArr[j].c);
                System.out.println("]");
                //取出队头元素
                int cur = queue.poll();
                sb.append(vexArr[cur].c + "  ");
                Edge edge = vexArr[cur].firstEdge;
                while (edge != null) {

                    if (!visited[edge.iVex]){
                        queue.add(edge.iVex);
                        visited[edge.iVex]=true;
                    }

                    if (!visited[edge.jVex]){
                        visited[edge.jVex]=true;
                        queue.add(edge.jVex);
                    }
                    edge = getNextEdge(cur, edge);
                }

            }
        }
        return sb.toString();
    }

    /**
     * 获取当前点的下一条边
     *
     * @param vexIndex
     * @param cur
     * @return
     */
    private Edge getNextEdge(int vexIndex, Edge cur) {
        return cur.iVex == vexIndex ? cur.iLink : cur.jLink;
    }


    /**
     * 打印每个顶点的边
     */
    public void print() {
        for (int i = 0; i < vexArr.length; i++) {
            Vertex vertex = vexArr[i];
            System.out.println("顶点 " + vertex.c + " 的所有边: ");

            Edge cur = vertex.firstEdge;
            while (cur != null) {
                System.out.print(cur.iVex + "---" + cur.jVex + " ||");
                if (cur.iVex == i) {
                    cur = cur.iLink;
                } else {
                    cur = cur.jLink;
                }
            }
            System.out.println();
        }
    }

    /**
     * 没用了这个方法，繁杂
     *
     * @param iVex
     * @param jVex
     * @param edge
     */
    private void insert(int iVex, int jVex, Edge edge) {
        Vertex vi = vexArr[iVex];
        Vertex vj = vexArr[jVex];
        if (vi.firstEdge == null) {
            vi.firstEdge = edge;
        } else {
            Edge vexNextEdge = vi.firstEdge;
            edge.iLink = vexNextEdge;
            vi.firstEdge = edge;
        }
        //头插法插入oVertex的边
        //这里一定是从jLink出发因为jvex相同
        if (vj.firstEdge == null) {
            vj.firstEdge = edge;
        } else {
            Edge oVexNextEdge = vj.firstEdge;
            edge.jLink = oVexNextEdge;
            vj.firstEdge = edge;
        }
    }

}
