import java.util.*;

class Solution {
	public int[] solution(int n, String[] words) {
		Game game = new Game();

		for (String word : words) {
			int result = game.play(word);

			if (result != 0) {
				int person = result % n == 0 ? n : result % n;
				int seq = result % n == 0 ? result / n : result / n + 1;

				return new int[] { person, seq };
			}
		}

		return new int[] { 0, 0 };
	}
}

class Game {

	private Set<String> wordSet;
	private String lastWord;

	public Game() {
		wordSet = new HashSet<>();
	}

	public int play(String word) {
		if (lastWord != null && !match(word)) {
			return wordSet.size() + 1;
		}

		if (wordSet.contains(word)) {
			return wordSet.size() + 1;
		}

		wordSet.add(word);
		setLastWord(word);

		return 0;
	}

	private boolean match(String word) {
		final char last = lastWord.charAt(lastWord.length() - 1);

		return last == word.charAt(0);
	}

	private void setLastWord(String word) {
		this.lastWord = word;
	}
}
