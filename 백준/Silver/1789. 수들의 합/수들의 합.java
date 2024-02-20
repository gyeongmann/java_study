import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong();
		
		if (S == 1) {
			System.out.println(1);
			return;
		}
		
		long n = 1;
		long sum = (n * n + n) / 2;
		
		while (true) {
			if (sum > S) {
				break;
			}
			n++;
			sum = (n * n + n) / 2;
		}
		
		System.out.println(n - 1);
	}
}
