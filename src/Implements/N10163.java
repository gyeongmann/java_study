import java.util.Scanner;

public class N10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[1001][1001];
		int n = sc.nextInt();
		int[] answer = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					int nx = x + col;
					int ny = y + row;
					int idx = map[nx][ny];
					if (idx != 0) {
						answer[idx]--;
					}
					map[nx][ny] = i + 1;
					answer[i+1]++;
					
				}
			}
		}
		
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
//		System.out.println(Arrays.toString(answer));
		
		for (int i = 0; i < n; i++) {
			System.out.println(answer[i+1]);
		}
	}
}
