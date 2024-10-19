import java.util.*;

class Solution {

	public int solution(int[] nums) {
		List<Integer> list = new ArrayList<>();

		backTracking(list, nums, new boolean[nums.length], 0, 3);

		return list.size();
	}

	private void backTracking(List<Integer> list, int[] nums, boolean[] visited, int depth, int count) {
		if (count == 0) {
			int sum = 0;
			for (int i=0 ; i<visited.length ; i++) {
				if (visited[i]) {
					sum += nums[i];
				}
			}

			if (isPrime(sum)) {
				list.add(sum);
			}

			return;
		}

		for (int i=depth ; i<nums.length ; i++) {
			visited[i] = true;
			backTracking(list, nums, visited, i + 1, count - 1);
			visited[i] = false;
		}
	}

	private boolean isPrime(int number) {
		final int limit = (int) Math.sqrt(number);

		for (int i=2 ; i<number ; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
