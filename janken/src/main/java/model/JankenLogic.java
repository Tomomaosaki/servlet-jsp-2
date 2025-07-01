package model;

public class JankenLogic {
	final String[] HAND = {"グー", "チョキ", "パー"}; 
	
	public String execute(int user, int com) {
		String msg = "";
		msg += "あなた：" + HAND[user] + "<br>";
		msg += "わたし：" + HAND[com] + "<br>";
		
		if (user == com) {
			msg += "あいこです";
		} else if ((user + 1) % 3 == com) {
			msg += "あなたの勝ちです";
		} else {
			msg += "わたしの勝ちです";
		}
		return msg;	
	}	
}
