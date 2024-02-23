import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int cnt = 1;

		while (B > A) {
			if (B % 2 == 0) {
				B /= 2;
			} else if (String.valueOf(B).endsWith("1")) {
				B /= 10;
			} else {
				System.out.println(-1);
				return;
			}
			
			cnt++;
		}
		
		if (A == B) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
}
