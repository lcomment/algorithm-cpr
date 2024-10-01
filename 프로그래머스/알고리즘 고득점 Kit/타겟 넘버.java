class Solution {

	private int answer;

	public int solution(int[] numbers, int target) {
		answer = 0;

		dfs(numbers, target, 0, 0);

		return answer;
	}

	private void dfs(int[] nums, int target, int result, int depth) {
		if (nums.length == depth) {
			if (result == target) {
				answer++;
			}

			return;
		}

		dfs(nums, target, result + nums[depth], depth + 1);
		dfs(nums, target, result - nums[depth], depth + 1);
	}
}
