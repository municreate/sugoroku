package game;

public class Player {

	private int nowLocation = 0;

	private String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNowLocation(int nowLocation) {
		this.nowLocation = nowLocation;
	}

	public int getNowLocation() {
		return nowLocation;
	}

}
