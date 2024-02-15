import java.util.Scanner;

public class Main {
	// 가로, 세로, 네모 칸의 합이 모두 45가 되는지 -> 반례) 모두 5인 경우 -> 기각
	// 카운팅 배열을 이용해 각 숫자가 모두 들어있는지 확인

	static boolean rowCheck(int[][] board) {
		for (int r = 0; r < 9; r++) {
			int[] countingArr = new int[10];
			for (int c = 0; c < 9; c++) {
				countingArr[board[r][c]]++;
			}
			
			for (int i = 1; i <= 9; i++) {
				if (countingArr[i] != 1) {
					return false; // 1이 아닌 숫자가 있으면 없거나 2개 이상인 숫자가 있으므로 false
				}
			}
		}
		
		return true;
	}

	static boolean colCheck(int[][] board) {
		// 전치 행렬
		for (int r = 0; r < 9; r++) {
			for (int c = r + 1; c < 9; c++) {
				int tmp = board[r][c];
				board[r][c] = board[c][r];
				board[c][r] = tmp;
			}
		}
		
		return rowCheck(board);
	}
	
	static boolean boxCheck(int[][] board, int row, int col) {
		int[] countingArr = new int[10];
		
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				int nr = r + row;
				int nc = c + col;
				countingArr[board[nr][nc]]++;
			}
		}
		for (int i = 1; i <= 9; i++) {
			if (countingArr[i] != 1) {
				return false; // 1이 아닌 숫자가 있으면 없거나 2개 이상인 숫자가 있으므로 false
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int[][] board = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			boolean row = rowCheck(board);
			boolean col = colCheck(board);
			
			boolean box = true;
			int[] boxRow = {0, 3, 6};
			int[] boxCol = {0, 3, 6};
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// boxCheck가 false가 나오면
					if (!boxCheck(board, boxRow[i], boxCol[j])) {
						box = false;
					}
				}
			}
			
			System.out.print("Case " + t + ": ");
			if (row && col && box) { // 모두 참이면 1 출력
				System.out.println("CORRECT");
				continue;
			}
			
			System.out.println("INCORRECT");

		} // test case
	} // main
}
