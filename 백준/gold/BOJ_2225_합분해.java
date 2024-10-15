import java.io.*;
import java.util.*;

public class Main {

	private static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int[] input = sToIArr(br.readLine());
		final int n = input[0];
		final int k = input[1];

		final int[][] dp = new int[n + 1][k + 1];

		// init
		for (int i = 0; i <= k; i++) {
			dp[1][i] = i;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][1] = 1;

			for (int j = 2; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
			}
		}

		System.out.println(dp[n][k]);
	}

	private static int[] sToIArr(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private static int sToI(String s) {
		return Integer.parseInt(s);
	}
}
