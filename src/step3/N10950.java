package step3;

import java.util.Scanner;

public class N10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(a + b).append('\n');
        }

        System.out.print(sb);
    }
}
