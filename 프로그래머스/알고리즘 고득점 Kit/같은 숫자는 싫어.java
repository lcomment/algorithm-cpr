import java.util.*;

public class Solution {
	public int[] solution(final int[] arr) {
		final List<Integer> save = new ArrayList<>();

		save.add(arr[0]);
		for (int idx = 1 ; idx < arr.length ; idx++) {
			if (arr[idx - 1] == arr[idx]) continue;
			save.add(arr[idx]);
		}

		return save.stream().mapToInt(Integer::intValue).toArray();
	}
}
