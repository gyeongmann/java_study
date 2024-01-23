package Bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class N7696 {
    static int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int count;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int depth, int r, int[] output, boolean[] visited, int distance) {
        if (depth == r) {
            count++;
            if (count == distance) {
                for (int i : output) {
                    sb.append(i);
                }
                sb.append('\n');
//                System.out.println(Arrays.toString(output));
            }

            return;
        }

        int start = 0;
        if (depth == 0) {
            start = 1;
        }
        for (int i = start; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = digits[i];
                permutation(depth + 1, r, output, visited, distance);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        long[] cut = {9, 81, 648, 4536, 27216, 136080, 544320, 1632960};
        long[] prefix = new long[cut.length];

        prefix[0] = cut[0];
        for (int i = 1; i < cut.length; i++) {
            prefix[i] = prefix[i - 1] + cut[i];
        }

//        System.out.println(Arrays.toString(cut));
//        System.out.println(Arrays.toString(prefix));

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            list.add(n);
        }

        for (int x : list) {
            for (int i = 0; i < prefix.length; i++) {
                if (x < 10) {
                    System.out.println(x);
                    break;
                }

                if (x > prefix[i]) {
                    continue;
                }
//                System.out.println(i+1 + "자리수");
                int[] output = new int[i + 1];
                boolean[] visited = new boolean[10];
                count = 0;
                int distance = (int) (x - prefix[i - 1]);
                permutation(0, i+1, output, visited, distance);
                break;
            }
        }

        System.out.print(sb);


    }
}
