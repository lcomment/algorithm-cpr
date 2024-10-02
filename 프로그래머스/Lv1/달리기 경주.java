import java.util.*;

class Solution {
	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> playerMap = new HashMap<>();

		for (int i=0 ; i<players.length ; i++) {
			playerMap.put(players[i], i);
		}

		for (String calling : callings) {
			int seq = playerMap.get(calling);
			swap(players, seq, playerMap);
		}

		return players;
	}

	private void swap(String[] players, int target, Map<String, Integer> playerMap) {
		if (target == 0) {
			return;
		}

		String save = new String(players[target - 1]);

		players[target - 1] = players[target];
		playerMap.put(players[target - 1], target - 1);
		players[target] = save;
		playerMap.put(players[target], target);
	}
}
