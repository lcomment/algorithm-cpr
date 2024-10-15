import java.util.*;

class Solution {
	public int solution(int[] citations) {
		final int length = citations.length;
		Arrays.sort(citations);

		for (int i = 0 ; i < length ; i++) {
			final int h = length - i;

			if (citations[i] >= h) {
				return h;
			}
		}

		return 0;
	}
}
