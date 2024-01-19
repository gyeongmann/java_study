package DynamicProgramming;

import java.util.Scanner;

public class N2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		int[] d = new int[n + 1];
		
		d[1] = a[1];
		
		
		for (int i = 1; i <= n; i++) {
			if (i == 2) {
				d[2] = a[1] + a[2];
			}
			
			if (i == 3) {
				d[3] = Math.max(a[1], a[2]) + a[3];
			}
			
			if (i >= 4) {
				d[i] = Math.max(d[i-3] + a[i-1] + a[i], d[i-2] + a[i]);
			}
		}
		
		
		System.out.println(d[n]);
	}
}
