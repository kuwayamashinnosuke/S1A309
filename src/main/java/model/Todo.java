package model;

import java.io.Serializable;

public class Todo implements Serializable{
	private String Numbers;
	private String Contents;
	private String limitDay;
	
	
	public String getNumbers() {
		return Numbers;
	}
	public void setNumbers(String numbers) {
		Numbers = numbers;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public String getLimitDay() {
		return limitDay;
	}
	public void setLimitDay(String limitDay) {
		this.limitDay = limitDay;
	}
	
}
