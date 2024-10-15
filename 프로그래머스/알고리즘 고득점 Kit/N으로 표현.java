import java.util.*;

class Solution {
	public int solution(int N, int number) {
		if (N == number) {
			return 1;
		}

		Set<Integer>[] arr = new Set[9];

		for (int i=0 ; i<=8 ; i++) {
			arr[i] = new HashSet<>();
		}

		arr[1].add(N);

		for (int i=2 ; i<9 ; i++) {
			final Set<Integer> set = arr[i];

			for (int j=1 ; j<i ; j++) {
				final Set<Integer> a = arr[j];
				final Set<Integer> b = arr[i - j];

				for (int x : a) {
					for (int y : b) {
						set.add(x + y);
						set.add(x - y);
						set.add(x * y);

						if (x != 0 && y != 0) {
							set.add(x / y);
						}
					}
				}
			}

			set.add(Integer.parseInt(String.valueOf(N).repeat(i)));

			if (set.contains(number)) {
				return i;
			}
		}

		return -1;
	}
}
