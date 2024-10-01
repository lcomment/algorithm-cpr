import java.util.*;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int count = n - lost.length;

		Arrays.sort(reserve);
		Arrays.sort(lost);

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					count++;
					break;
				}
			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (lost[i] == -1) {
				continue;
			}

			for (int j = 0; j < reserve.length; j++) {
				if (reserve[j] == -1) {
					continue;
				}

				if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
					reserve[j] = -1;
					count++;
					break;
				}
			}
		}

		return count;
	}
}
