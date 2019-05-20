package weather;

public class Weather {
	private int hour;
	private double temp;
	private String wfKor;
	private int reh;

	public Weather() {
		this(0, 0.0, "", 0);
	}

	public Weather(int hour, double temp, String wfKor, int reh) {
		this.hour = hour;
		this.temp = temp;
		this.wfKor = wfKor;
		this.reh = reh;
	}

	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfKor=" + wfKor + ", reh=" + reh + "]";
	}

}
