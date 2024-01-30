import java.util.Arrays;
import java.util.Scanner;

public class N10972 {
    static int[] input;
    static int N;

    // 1. 오름차순 찾기
    static int findAscending() {
        for (int i = N - 1; i > 0; i--) {
            int current = input[i];
            int before = input[i - 1];

            if (before < current) {
                return i;
            }
        }

        return -1;
    }

    // 2. 오름차순의 앞에 숫자보다 큰 수 뒤에서부터 탐색
    static void findBiggerAndSwap(int before, int idx) {
        for (int i = N - 1; i > idx; i--) {
            if (before < input[i]) {
                input[idx] = input[i];
                input[i] = before;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }


        // 전부 내림차순
        if (findAscending() == -1) {
            System.out.println(-1);
        } else {
            int idx = findAscending() - 1;
            findBiggerAndSwap(input[idx], idx);

            Arrays.sort(input, idx + 1, N);
            for (int i : input) {
                System.out.print(i + " ");
            }
        }

    }
}
