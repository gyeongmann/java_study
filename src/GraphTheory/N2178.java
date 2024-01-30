package GraphTheory;

import java.util.*;

public class N2178 {

    static int N, M;
    static boolean[][] vis;
    static int[][] map;
    static List<Integer> ans = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y;
        int distance;

        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ", d = " + distance + ")";
        }
    }


    static boolean isValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }

        if (vis[x][y] || map[x][y] != 1) {
            return false;
        }

        return true;
    }

    static void BFS() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;

//        System.out.println(q);

        while (!q.isEmpty()) {
            Pair pair = q.peek();
            q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                int nd = pair.distance + 1;

                if (isValid(nx, ny)) {
                    if (nx == N - 1 && ny == M - 1) {
                        ans.add(nd);
                        break;
                    }

                    vis[nx][ny] = true;
                    q.add(new Pair(nx, ny, nd));
                }
            } // searching 4 direction

//            System.out.println(q);
        } // while
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] NM = sc.nextLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N][M];
        vis = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String[] line = sc.nextLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            } // col
        } // row

//        for (int[] row : map) {
//            System.out.println(Arrays.toString(row));
//
//        }

        BFS();

        System.out.println(Collections.min(ans));
    } // main
}
