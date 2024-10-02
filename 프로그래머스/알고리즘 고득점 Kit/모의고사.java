import java.util.*;

class Solution {

	private int[] strategy1 = {1, 2, 3, 4, 5};
	private int[] strategy2 = {2, 1, 2, 3, 2, 4, 2, 5};
	private int[] strategy3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public int[] solution(int[] answer) {
		final GradeExecutor executor = new GradeExecutor();
		final List<Student> students = new ArrayList<>();

		students.add(new Student(1, executor.grade(answer, strategy1)));
		students.add(new Student(2, executor.grade(answer, strategy2)));
		students.add(new Student(3, executor.grade(answer, strategy3)));
		int max = students.stream()
			.mapToInt(Student::getScore)
			.max()
			.orElseThrow(NoSuchElementException::new);

		List<Integer> answerList = new ArrayList<>();
		for(int i = 0; i < students.size(); i++) {
			if(max == students.get(i).getScore()) {
				answerList.add(i + 1);
			}
		}


		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}
}

class Student {

	private int seq;
	private int score;

	public Student(int seq, int score) {
		this.seq = seq;
		this.score = score;
	}

	public int getSeq() {
		return this.seq;
	}

	public int getScore() {
		return this.score;
	}
}

class GradeExecutor {

	public int grade(final int[] correct, final int[] strategy) {
		int index = 0;
		int score = 0;

		for (int num : correct) {
			if (num == strategy[index++]) {
				score++;
			}

			if (index == strategy.length) {
				index = 0;
			}
		}

		return score;
	}
}
