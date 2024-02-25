import java.util.*;

public class Main {
    static int v, e;
    static int[] parent;
    static int[][] edges;

    static int find(int x) {
        if (parent[x] < 0)
            return x;
        return parent[x] = find(parent[x]);
    }

    static boolean isDiffGroup(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) // 부모가 같으면
            return false;
        if (parent[u] == parent[v])
            parent[u]--;
        if (parent[u] < parent[v])
            parent[v] = u;
        else parent[u] = v;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        parent = new int[v + 1];
        edges = new int[e][3];

        for (int i = 1; i <= v; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new int[]{cost, a, b};
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < e; i++) {
            int cost = edges[i][0];
            int a = edges[i][1];
            int b = edges[i][2];
            if (!isDiffGroup(a, b)) continue;
            ans += cost;
            cnt++;
            if (cnt == v - 1) break;
        }

        System.out.println(ans);

    }
}
