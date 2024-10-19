import java.util.*;

class Solution {

	private final int MOD = 1_000_000_007;

	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n][m];
		dp[0][0] = 1;

		for (int[] puddle : puddles) {
			dp[puddle[1] - 1][puddle[0] - 1] = -1;
		}

		for (int i=0 ; i<n ; i++) {
			for (int j=0; j<m ; j++) {
				if (dp[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}

				if (i != 0) {
					dp[i][j] += dp[i-1][j] % MOD;
				}

				if (j != 0) {
					dp[i][j] += dp[i][j-1] % MOD;
				}

				dp[i][j] %= MOD;
			}
		}

		return dp[n - 1][m - 1];
	}
}
