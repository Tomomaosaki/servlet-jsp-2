package model;

import java.io.Serializable;

public abstract class Player implements Serializable {
	private String name;
	private int hand;
	private String[] handImg = { 
			"<img src=\"img/gu.png\" alt=\"グー\">", 
			"<img src=\"img/choki.png\" alt=\"チョキ\">", 
			"<img src=\"img/pa.png\" alt=\"パー\">" };
	
	
	public Player() {}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getHandImg() {
		return handImg[this.hand];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHand() {
		return hand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}
		
}
