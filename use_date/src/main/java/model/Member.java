package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Member implements Serializable {
	private int id;
	private String name;
	private LocalDate birthday;
	
	public Member() {}

	public Member(int id, String name, LocalDate birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
	public int getAge() {
		LocalDate today = LocalDate.now(); // 現在
		return Period.between(birthday, today).getYears(); // 現在-誕生日の年を取り出して返す
	}
}
	
