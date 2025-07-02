package test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<>();
		
		nameList.add("湊");
		nameList.add("綾部");
		nameList.add("菅原");
		
		for (String name : nameList) {
			System.out.println(name);
		}

	}

}
