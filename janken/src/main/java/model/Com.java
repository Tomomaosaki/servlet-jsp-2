package model;

public class Com extends Player {
	public Com() {
		this("コム");
	}
	public Com(String name) {
		super(name);
	}
	
	public void setRamdomHand() {
		int n = (int)(Math.random() * 3);
		this.setHand(n);
	}
}
