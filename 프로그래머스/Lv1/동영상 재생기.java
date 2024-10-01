import java.util.*;

class Solution {
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		final Time posTime = new Time(pos.split(":"));
		final Time video = new Time(video_len.split(":"));
		final Time start = new Time(op_start.split(":"));
		final Time end = new Time(op_end.split(":"));

		posTime.skipOpening(start, end);
		for (final String command : commands) {
			switch (command) {
				case "prev":
					posTime.prev();
					break;
				case "next":
					posTime.next(video);
					break;
			}
			posTime.skipOpening(start, end);
		}

		return posTime.toString();
	}
}

class Time {

	private int minute;
	private int second;

	public Time(int minute, int second) {
		this.minute = minute;
		this.second = second;
	}

	public Time(String[] s) {
		this.minute = Integer.parseInt(s[0]);
		this.second = Integer.parseInt(s[1]);
	}

	public void next(Time video) {
		this.second += 10;

		if (this.second > 60) {
			this.minute++;
			this.second -= 60;
		}

		if (this.gt(video)) {
			this.setMinute(video.getMinute());
			this.setSecond(video.getSecond());
		}
	}

	public void prev() {
		this.second -= 10;

		if (this.second < 0) {
			this.minute--;
			this.second += 60;
		}

		if (this.minute < 0) {
			this.minute = 0;
			this.second = 0;
			return;
		}
	}

	public void skipOpening(Time start, Time end) {
		if (this.between(start, end)) {
			this.minute = end.getMinute();
			this.second = end.getSecond();
		}
	}

	public boolean between(Time start, Time end) {
		boolean goe = this.minute > start.minute || (this.minute == start.minute && this.second >= start.second);
		boolean loe = this.minute < end.minute || (this.minute == end.minute && this.second <= end.second);

		return goe && loe;
	}

	public boolean gt(Time target) {
		return this.minute > target.getMinute() || (this.minute == target.getMinute() && this.second > target.getSecond());
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public String toString() {
		String m = this.minute < 10 ? "0" + this.minute : Integer.toString(minute);
		String s = this.second < 10 ? "0" + this.second : String.valueOf(second);

		return m + ":" + s;
	}
}
