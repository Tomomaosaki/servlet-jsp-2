package model;

import java.io.Serializable;

public class Hero implements Serializable {
	private String name;
	private int hp;
	
	public Hero() {}

	public Hero(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}	
	
}
