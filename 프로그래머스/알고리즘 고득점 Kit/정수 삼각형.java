import java.util.*;

class Solution {

	public int solution(int[][] triangle) {
		final int length = triangle.length;
		final int[][] dp = new int[length][length];

		dp[0][0] = triangle[0][0];

		for (int i=1 ; i<length ; i++) {
			dp[i][0] = dp[i-1][0] + triangle[i][0];

			for (int j=1 ; j<=i ; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
			}
		}

		return Arrays.stream(dp[length - 1]).max().orElse(0);
	}
}
