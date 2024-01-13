package step2;

import java.util.Scanner;

public class N2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(calculate(a, b, c));
    }

    static int calculate(int a, int b, int c) {
        if (a == b) {
            // 모두 동일
            if (b == c) {
                return 10000 + a * 1000;
            }

            // a,b만 동일
            return 1000 + a * 100;
        }

        if (b == c) {
            // b,c만 동일
            return 1000 + b * 100;
        }

        if (a == c) {
            // a,c만 동일
            return 1000 + a * 100;
        }

        int max = Math.max(a, b);
        max = Math.max(max, c);

        return max * 100;
    }
}
