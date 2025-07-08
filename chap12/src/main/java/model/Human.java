package model;

import java.io.Serializable;

public class Human implements Serializable {
	private String name;
	private int age;
	
	public Human() {}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
}
