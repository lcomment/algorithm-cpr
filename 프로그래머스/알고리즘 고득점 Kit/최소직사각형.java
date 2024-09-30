import java.util.*;

class Solution {

	public int solution(int[][] sizes) {
		final List<BusinessCard> list = new ArrayList<>();

		Arrays.stream(sizes).forEach(it ->
			list.add(new BusinessCard(it))
		);

		final BusinessCard maxOfMax = list.stream()
			.max((it1, it2) -> it1.getMax() - it2.getMax())
			.get();
		final BusinessCard maxOfMin = list.stream()
			.max((it1, it2) -> it1.getMin() - it2.getMin())
			.get();

		return maxOfMax.getMax() * maxOfMin.getMin();
	}
}

class BusinessCard {

	private int width;
	private int length;

	public BusinessCard(int[] arr) {
		this.width = arr[0];
		this.length = arr[1];
	}

	public int getMax() {
		return Math.max(this.width, this.length);
	}

	public int getMin() {
		return Math.min(this.width, this.length);
	}
}
