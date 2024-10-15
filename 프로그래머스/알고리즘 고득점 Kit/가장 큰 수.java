import java.util.*;
import java.util.stream.*;

class Solution {

	public String solution(int[] numbers) {
		List<Num> list = Arrays.stream(numbers)
			.mapToObj(it -> new Num(it))
			.collect(Collectors.toList());

		Collections.sort(list);

		if (list.get(0).toString().equals("0")) {
			return "0";
		}

		String answer = "";
		for (Num n : list) {
			answer += n.toString();
		}

		return answer;
	}
}

class Num implements Comparable<Num> {

	private int value;

	public Num(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Num number) {
		String s1 = this.toString() + number.toString();
		String s2 = number.toString() + this.toString();

		return s2.compareTo(s1);
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
