import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		int index = 0;

		while(index < progresses.length) {
			final int cal = (100 - progresses[index]) / speeds[index];
			final int need = (100 - progresses[index]) % speeds[index] == 0 ? cal : cal + 1;

			for (int i=index ; i<progresses.length ; i++) {
				progresses[i] += need * speeds[i];
			}

			int count = 0;
			for (int i=index ; i<progresses.length ; i++) {
				if (progresses[i] < 100) {
					index = i;
					break;
				}

				if (i == progresses.length - 1) {
					index = i + 1;
				}
				count++;
			}

			list.add(count);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
