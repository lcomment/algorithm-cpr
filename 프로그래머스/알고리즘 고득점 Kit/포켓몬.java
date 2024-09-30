import java.util.*;

class Solution {

	public int solution(final int[] nums) {
		final Set<Integer> set = new HashSet<>();

		Arrays.stream(nums).forEach(it -> set.add(it));

		return Math.min(nums.length / 2, set.size());
	}
}
