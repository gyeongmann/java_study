import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, count;
    static int[] group;
    static int[][] adj;

    static void BFS(int x) {
        if (group[x] != 0) { // group이 있으면 return
            return;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        count++;
        group[x] = count;

        while (!q.isEmpty()) {
//            System.out.println(q);
            x = q.poll();

            for (int i = 1; i <= N; i++) {
                if (adj[x][i] == 1 && group[i] == 0) { // 연결 되어 있고, 방문한 적 없으면
                    q.add(i);
                    group[i] = count;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수

//        map = new int[N + 1];
        group = new int[N + 1];
        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            adj[r][c] = 1;
            adj[c][r] = 1;
        } // for

        for (int i = 1; i <= N; i++) {
            BFS(i);
        }

//        System.out.println(Arrays.toString(group));
        System.out.println(count);

    } // main
}
