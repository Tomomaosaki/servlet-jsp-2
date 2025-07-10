package servlet.util;

import java.util.List;

import model.Employee;

public class Validator {
	public void checkName(String name, List<String> errorList) {
		if (name == null || name.length() == 0) { // ←null（何も入力していない）ならば
			errorList.add("文字が未入力です");
		}
	}
	
	public int checkAge(String ageTxt, List<String> errorList) {
		if (ageTxt == null || ageTxt.length() == 0) { // ←null（何も入力していない）ならば
			errorList.add("年齢が未入力です");
			return 0;
		}
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt); // ←数字に変換
		} catch (NumberFormatException e) {
			errorList.add("数字ではありません");
		}
		return age;
	}
	
	public void check(Employee emp, List<String> errorList) {
		// ↓id形式チェック（正規表現）
		emp.setId(emp.getId().toUpperCase()); // すべて大文字に変換してidにセットする
		
		// ↓id重複チェック
		
		// ↓nameチェック
	}
}
