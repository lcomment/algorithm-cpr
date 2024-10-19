class Solution {
	public int solution(int n) {
		int answer = 1;

		for (int i=3 ; i<=n ; i++) {
			if (isPrime(i)) {
				answer++;
			}
		}

		return answer;
	}

	private boolean isPrime(int number) {
		int limit = (int) Math.sqrt(number);

		for (int i=2 ; i<=limit ; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
