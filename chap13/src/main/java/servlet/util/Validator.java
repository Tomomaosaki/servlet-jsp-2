package servlet.util;

import java.util.List;

import model.Employee;
import model.IsNotExistIdLogic;

public class Validator {
	public void checkName(String name, List<String> errorList) {
		if (name == null || name.length() == 0) { // ←null（何も入力していない）ならば
			errorList.add("文字が未入力です"); // ←errorListに追加
		}
	}
	
	public int checkAge(String ageTxt, List<String> errorList) {
		if (ageTxt == null || ageTxt.length() == 0) { // ←null（何も入力していない）ならば
			errorList.add("年齢が未入力です"); // ←errorListに追加
			return 0;
		}
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt); // ←数字に変換
		} catch (NumberFormatException e) { // ←数字が入力されてなくてNumberFormatExceptionエラーが出たら
			errorList.add("数字ではありません"); // ←errorListに追加
		}
		return age;
	}
	
	public void checkId(Employee emp, List<String> errorList) {
		// ↓nullのチェック
		if (emp.getId() == null || emp.getId().length() == 0) {
			errorList.add("IDが入力されていません");
		}
		
		// ↓id形式チェック（正規表現）
		emp.setId(emp.getId().toUpperCase()); // すべて大文字に変換してidにセットする
		if (!emp.getId().matches("^EMP[0-9]{3}$")) { // ←マッチしていなかったら
			errorList.add("IDの形式が違います");  // ←errorListに追加
		}
		
		// ↓id重複チェック
		IsNotExistIdLogic logic = new IsNotExistIdLogic();
		if (!logic.execute(emp.getId())) {
			errorList.add("そのIDは存在しています");
		}
	}
	
	// ↓intのageをチェック　checkAgeのオーバーロード
	public void checkAge(Employee emp, List<String> errorList) {
		if (emp.getAge() == 0 ) {
			errorList.add("年齢が不正です");
		}
	}
	
	public void check(Employee emp, List<String> errorList) {
		checkId(emp, errorList);
		checkName(emp.getName(), errorList);
		checkAge(emp, errorList);
	}
}
