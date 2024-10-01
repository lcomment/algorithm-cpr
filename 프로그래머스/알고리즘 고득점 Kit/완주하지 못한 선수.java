import java.util.*;

class Solution {

	public String solution(String[] participant, String[] completion) {
		final Map<String, Integer> map = new HashMap<>();

		Arrays.stream(participant).forEach(it -> {
			map.put(it, map.containsKey(it) ? map.get(it) + 1 : 1);
		});

		Arrays.stream(completion).forEach(it -> {
			map.put(it, map.get(it) - 1);

			if (map.get(it) == 0) {
				map.remove(it);
			}
		});

		return new ArrayList<>(map.keySet()).get(0);
	}
}
