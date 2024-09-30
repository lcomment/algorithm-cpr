import java.util.*;

class Solution {

	public int[] solution(int[] array, int[][] commands) {
		final List<Integer> answer = new ArrayList<>();

		for (int[] cmd : commands) {
			final int start = cmd[0] - 1;
			final int end = cmd[1];
			final int cursor = cmd[2] - 1;

			final int[] copyArray = Arrays.copyOfRange(array, start, end);
			Arrays.sort(copyArray);
			answer.add(copyArray[cursor]);
		}

		return answer.stream().mapToInt(it -> it).toArray();
	}
}
