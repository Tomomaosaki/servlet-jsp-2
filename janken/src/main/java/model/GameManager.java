package model;

import java.io.Serializable;

public class GameManager implements Serializable {
	private String hands;
	private String result;
	
	public GameManager() {}
	
	public void setHands(Player p1, Player p2) {
		hands = p1.getName() + p1.getHandImg() +
		        p2.getName() + p2.getHandImg();
	}
	
	public void judge(Player p1, Player p2) {
		setHands(p1, p2);
		if (p1.getHand() == p2.getHand()) {
			this.result = "あいこ";
		} else if ((p1.getHand() + 1) % 3 == p2.getHand()) {
			this.result = p1.getName() + "の勝ちです";
		} else {
			this.result = p2.getName() + "の勝ちです";
		}
	}

	public String getHands() {
		return hands;
	}

	public String getResult() {
		return result;
	}
}
