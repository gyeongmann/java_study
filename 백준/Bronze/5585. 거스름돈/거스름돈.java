import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();
        money = 1000 - money;

        int cnt = 0;
        cnt += money / 500; money %= 500;
        cnt += money / 100; money %= 100;
        cnt += money / 50; money %= 50;
        cnt += money / 10; money %= 10;
        cnt += money / 5; money %= 5;
        cnt += money / 1;

        System.out.println(cnt);

    }
}
