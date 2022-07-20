package model;

import java.util.List;

public class UpdateLogic{
	public void execute(List<Todo> todoList,int status,Todo todo) {
		//リストに1件分のデータを変更
		
		todoList.set(status, todo);
		
	}
	

}
