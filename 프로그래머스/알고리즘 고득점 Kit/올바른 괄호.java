import java.util.*;

class Solution {

	boolean solution(String s) {
		char[] arr = s.toCharArray();

		if (arr[0] == ')' || arr[arr.length - 1] == '(') {
			return false;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				count++;
			} else {
				count--;
			}

			if (count < 0) {
				return false;
			}
		}

		return count == 0;
	}
}
