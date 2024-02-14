import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] vis;
    static int[][] board;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Pair {
        int r, c, cnt;

        public Pair(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static boolean isValid(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
            return false;
        }

        return true;
    }

    static void BFS() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = pair.r + dr[i];
                int nc = pair.c + dc[i];

                if (isValid(nr, nc)) {
                  // 벽이 있을 때,
                  // 1. 벽을 부순적이 있는지
                  // 2. 그 벽을 방문한 적이 있는지
                    if (map[nr][nc] == '1') {
                        if (pair.cnt == 0 && !vis[nr][nc][1]) {
                            vis[nr][nc][pair.cnt] = true;
                            board[nr][nc] = board[pair.r][pair.c] + 1;
                            q.add(new Pair(nr, nc, 1));
                        }
                    } else {
                        if (!vis[nr][nc][pair.cnt]) {
                            vis[nr][nc][pair.cnt] = true;
                            board[nr][nc] = board[pair.r][pair.c] + 1;
                            q.add(new Pair(nr, nc, pair.cnt));
                        }
                    }

                    if (nr == N - 1 && nc == M - 1) {
                        System.out.println(board[nr][nc] + 1);
                        return;
                    }
                }
            }
        } // while

        System.out.println(-1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        
        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        map = new char[N][M];
        board = new int[N][M];
        vis = new boolean[N][M][2];

        for (int r = 0; r < N; r++) {
            map[r] = sc.next().toCharArray();
        }

        BFS();
    } // main
}
