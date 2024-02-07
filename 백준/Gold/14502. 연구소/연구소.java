import java.util.*;

public class Main {
    // 0: 빈칸, 1: 벽, 2: 바이러스
    // 1. 벽을 세운다
    // 2. 바이러스 BFS
    // 3. 빈칸의 합 구하기 -> 최대값 갱신
    // 1,2,3 반복
    static int N, M;
    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

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

    static boolean isValid(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // out of bounds
            return false;
        }

        if (map[nx][ny] == 1) {
            return false;
        }

        return true;
    }

    static int BFS(Pair w1, Pair w2, Pair w3) {
        // 깊은 복사
        int[][] clone = new int[N][M];

        Queue<Pair> q = new LinkedList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                clone[x][y] = map[x][y];
                if (map[x][y] == 2) {
                    q.add(new Pair(x, y));
                }
            }
        }

        // 벽 세우기
        clone[w1.x][w1.y] = 1;
        clone[w2.x][w2.y] = 1;
        clone[w3.x][w3.y] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (isValid(nx, ny) && clone[nx][ny] == 0) {
                    q.add(new Pair(nx, ny));
                    clone[nx][ny] = 2;
                }
            } // for

        } // while

        int sum = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (clone[x][y] == 0) {
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

        List<Pair> blank = new ArrayList<>(); // 0인 좌표들

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                int val = sc.nextInt();

                if (val == 0) {
                    blank.add(new Pair(x, y));
                }

                map[x][y] = val;
            }
        }

        int max = 0; // 안전영역 최대 크기
        // 벽 조합 만들기
        for (int i = 0; i < blank.size(); i++) {
            for (int j = i + 1; j < blank.size(); j++) {
                for (int k = j + 1; k < blank.size(); k++) {
                    Pair w1 = blank.get(i);
                    Pair w2 = blank.get(j);
                    Pair w3 = blank.get(k);


                    int sum = BFS(w1, w2, w3);

                    if (max < sum) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);

    } // main
}
