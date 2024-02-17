import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] adj; // 인접 행렬
    static boolean[] vis;

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        vis = new boolean[N];

        q.add(node);

        while (!q.isEmpty()) {
            node = q.poll();

            for (int i = 0; i < N; i++) {
                // 연결 되어 있고 방문한 적이 없으면
                if (adj[node][i] == 1 && !vis[i]) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (vis[i]) {
                System.out.print(1 + " ");
                continue;
            }
            System.out.print(0 + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        adj = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                adj[r][c] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            BFS(i);
            System.out.println();
        }


    } // main

}
