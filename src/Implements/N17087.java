import java.math.BigInteger;
import java.util.Scanner;

public class N17087 {
	static int gcd;
	
	static int calculateGCD(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);

		return gcd.intValue();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int X = sc.nextInt();

		int[] kids = new int[N];
		int[] distance = new int[N];
		for (int i = 0; i < N; i++) {
			kids[i] = sc.nextInt();
			distance[i] = Math.abs(kids[i] - X);
		}

//		System.out.println(Arrays.toString(distance));

		if (N == 1) {
			System.out.println(distance[0]);
		} else {
			gcd = distance[0];
			
			for (int i = 1; i < N; i++) {
				gcd = calculateGCD(gcd, distance[i]);
			}
			
			System.out.println(gcd);
		}
	}
}
