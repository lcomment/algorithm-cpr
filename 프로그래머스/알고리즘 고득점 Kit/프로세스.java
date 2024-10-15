import java.util.*;

class Solution {

	public int solution(int[] priorities, int location) {
		final WaitQueue queue = new WaitQueue();

		for (int i = 0 ; i < priorities.length ; i++) {
			queue.put(i, priorities[i]);
		}

		int answer = -1;

		while (answer == -1) {
			answer = queue.execute(location);
		}


		return answer;
	}
}

class WaitQueue {

	private Queue<Process> q;
	private int count;

	public WaitQueue() {
		q = new LinkedList<>();
		count = 0;
	}

	public int execute(int location) {
		final Process current = q.poll();

		for (Process p : q) {
			if (p.getPriority() > current.getPriority()) {
				put(current);
				return -1;
			}
		}

		count++;

		if (current.getSeq() == location) {
			return count;
		}

		return -1;
	}

	public void put(Process process) {
		this.q.offer(process);
	}

	public void put(int seq, int priority) {
		this.q.offer(new Process(seq, priority));
	}
}

class Process {

	private int seq;
	private int priority;

	public Process(int seq, int priority) {
		this.seq = seq;
		this.priority = priority;
	}

	public int getSeq() {
		return seq;
	}

	public int getPriority() {
		return priority;
	}
}