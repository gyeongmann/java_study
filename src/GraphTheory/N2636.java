package N2636;

import java.util.*;

public class Main {
    // 너비 우선 탐색으로 주변이 0이고, 바깥이랑 접촉된 경우
    // BFS 큐의 삽입

    // 1. 바깥과 안을 구분한다. -> boolean[][] outside
    // 2. 바깥에 접촉한 1을 탐색

    static int N, M; // N: 가로, M: 세로
    static int[][] map;
    static boolean[][] outside;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static boolean isValidOutside(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return false;
        }

        // 바깥 처리된 부분 또는 치즈인 부분은 false
        if (outside[nx][ny] || map[nx][ny] == 1) {
            return false;
        }

        return true;
    }

    static void checkOutside(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        Pair start = new Pair(x, y);
        q.add(start);

        outside[x][y] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            x = pair.x;
            y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidOutside(nx, ny)) {
                    q.add(new Pair(nx, ny));
                    outside[nx][ny] = true;
                }
            }
        }
    }

    static int countCheeze() {
        int sum = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 1) {
                    sum++;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        outside = new boolean[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                map[x][y] = sc.nextInt();
            }
        }

        int cheeze;
        int time = 0;

        checkOutside(0, 0); // 초기 설정

        while (true) { // 치즈가 0이 되기 전
            cheeze = countCheeze();
            List<Pair> deletePair = new ArrayList<>();

            // 바깥과 접해있으면 삭제
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[x][y] == 1) { // 치즈이면
                        for (int i = 0; i < 4; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            if (outside[nx][ny]) { // 주변에 바깥이 있으면
                                map[x][y] = 0;
                                deletePair.add(new Pair(x, y));
                            }
                        }
                    }
                } // y
            } // x

            time++;

//            System.out.println("#" + time);
//            for (int[] row : map) {
//                System.out.println(Arrays.toString(row));
//            }

            if (countCheeze() == 0) {
                break;
            }

            // 안팎 구분
            for (Pair pair : deletePair) {
                checkOutside(pair.x, pair.y);
            }

        } // while

        System.out.println(time);
        System.out.println(cheeze);

    } // main
}
