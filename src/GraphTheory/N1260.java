import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, M, V;
    static boolean[] vis;
    static int[][] adj;

    static void DFS() {
        Stack<Integer> st = new Stack<>();

        int x = V;
        st.add(x);
        vis[x] = true;
        System.out.print(x + " "); // print test

        while (!st.isEmpty()) {
            x = st.peek();

            for (int i = 1; i <= N; i++) {
                if (adj[x][i] == 1) { // 간선 존재
                    if (!vis[i]) { // 갈 수 있으면 add
                        st.add(i);
                        vis[i] = true;
                        System.out.print(i + " "); // print test
                        break;
                    }
                }
                if (i == N) {
                    st.pop();
                }
            } // for
        } // while
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();

        int x = V;
        q.add(x);
        vis[x] = true;

        while (!q.isEmpty()) {
            x = q.peek();
            q.poll();
            System.out.print(x + " "); // print test

            for (int i = 1; i <= N; i++) {
                if (adj[x][i] == 1) {
                    if (!vis[i]) {
                        q.add(i);
                        vis[i] = true;
                    } // 방문했으면 continue
                }
            } // for
        } // while
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        V = sc.nextInt(); // 시작 정점

        vis = new boolean[N + 1]; // 1 - N 인덱스 사용
        adj = new int[N + 1][N + 1]; // 1 - N 인덱스 사용

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            adj[r][c] = 1;
            adj[c][r] = 1;
        }

        DFS();
        System.out.println();
        vis = new boolean[N + 1]; // 1 - N 인덱스 사용
        BFS();
    }
}
