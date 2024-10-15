import java.util.*;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		final Bridge bridge = new Bridge(bridge_length, weight);

		bridge.moveTruck(new Truck(truck_weights[0]));
		int answer = 1;
		int index = 1;

		while (!bridge.isEmpty()) {
			Truck truck = index < truck_weights.length ? new Truck(truck_weights[index]) : null;

			if (bridge.moveTruck(truck)) {
				index++;
			}

			answer++;
		}

		return answer;
	}
}

class Bridge {

	private Queue<Truck> q;
	private int length;
	private int weight;

	public Bridge(int length, int weight) {
		this.length = length;
		this.weight = weight;

		q = new LinkedList<>();
	}

	public boolean moveTruck(Truck truck) {
		int count = 0;
		for (Truck t : q) {
			if (t.move(this.length)) {
				count++;
			}
		}

		// poll arrived car
		while (count-- > 0) {
			q.poll();
		}

		if (truck != null && canDepart(truck)) {
			q.offer(truck);
			return true;
		}

		return false;
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public boolean canDepart(Truck truck) {
		if (length == q.size() || this.weight < getTotalWeight() + truck.getWeight()) {
			return false;
		}

		return true;
	}

	private int getTotalWeight() {
		int total = 0;

		for (Truck t : q) {
			total += t.getWeight();
		}

		return total;
	}
}

class Truck {

	private int weight;
	private int pos;

	public Truck(int weight) {
		this.weight = weight;
		this.pos = 1;
	}

	public boolean move(int length) {
		this.pos++;
		return this.pos >= length + 1 ? true : false;
	}

	public int getWeight() {
		return this.weight;
	}
}