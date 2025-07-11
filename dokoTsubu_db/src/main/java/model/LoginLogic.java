package model;

public class LoginLogic {
	public boolean execute(User user) {
		if (user.getPass().equals("1234")) {
			return true;
		} // elseを書いても書かなくてもいい（returnで返しているから）
		return false;
	}
}
