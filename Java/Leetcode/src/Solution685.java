import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
NO685 冗余连接2
在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u and v和顶点的边，其中父节点u是子节点v的一个父节点。
返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 */
public class Solution685 {
    int[] parent;   //各节点父节点

    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;  //默认父节点为自己
        }
        /*
        conflict说明发生冲突，记录下边的序号
        冲突举例[[2,1],[3,1],[1,4],[4,2]]
        由于parent[1]=2,无法再将3赋给parent[1]
        即当前edges[conflict][1]的父节点已经不为自己，此时在循环中直接跳过
        */
        int conflict = -1;
        /*
        与conflict相对,图中不发生冲突，所有节点都有唯一父节点但成环，如题中示例2，
        用来记录成环边的序号
        */
        int noconflict = -1;
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] != edges[i][1]) {
                conflict = i;
                continue;
            }
            /*
            如果不发生冲突，可以找到成环边，并记录。
            注意noconflict == -1不可少否则一旦成环后面find会造成死循环，
            之所以仍不跳出是因为后面仍有可能有边造成冲突，导致该记录无意义
            */
            if (conflict == -1 && noconflict == -1 && find(edges[i][0]) == find(edges[i][1])) noconflict = i;
            parent[edges[i][1]] = edges[i][0];  //记录父节点
        }
        //如果未冲突，直接返回成环边
        if (conflict == -1) return edges[noconflict];
        /*
        否则进行判断：
        由于未添加冲突边，如果当前图有环，则说明答案是与之相对的另一条边
        否则就是该冲突边
        */
        if (hasCircle(edges[conflict][1])) {
            int[] res = new int[2];
            res[1] = edges[conflict][1];
            res[0] = parent[edges[conflict][1]];
            return res;
        } else return edges[conflict];
    }

    private boolean hasCircle(int i) {
        int v = i;
        while (parent[i] != i) {
            if (parent[i] == v) return true;
            i = parent[i];
        }
        return false;
    }

    private int find(int n) {
        while (n != parent[n]) n = parent[n];
        return n;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantDirectedConnection = new Solution685().findRedundantDirectedConnection(x);
        for (int i : redundantDirectedConnection) {
            System.out.println(i);
        }
    }
}
