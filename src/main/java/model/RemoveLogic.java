package model;

import java.util.List;

public class RemoveLogic {
	public void execute(List<Todo> todoList,int number) {
		//リストに1件分のデータを削除
		
		todoList.remove(number);
		
	}
}
