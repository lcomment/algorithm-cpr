import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = sToI(br.readLine());
		while (T-- > 0) {
			final int n = sToI(br.readLine());
			final int[][] sticker = new int[2][n + 1];
			final int[][] dp = new int[2][n + 1];

			// init
			for (int i = 0; i < 2; i++) {
				sticker[i] = sToIArr(br.readLine());
			}

			dp[0][1] = sticker[0][0];
			dp[1][1] = sticker[1][0];

			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i - 1];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i - 1];
			}

			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

	private static int[] sToIArr(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private static int sToI(String s) {
		return Integer.parseInt(s);
	}
}
