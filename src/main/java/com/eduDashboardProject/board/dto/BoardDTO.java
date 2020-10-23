package com.eduDashboardProject.board.dto;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String board_number;
	private String identification;
	private String title;
	private String comment;
	private String create_date;
	
	public String getBoard_number() {
		return board_number;
	}
	public void setBoard_number(String board_number) {
		this.board_number = board_number;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}


	public void makeInsertDateFormmat(String create_date) {
		
		String year = create_date.substring(0, 4);
		String month = create_date.substring(6, 7);
		String date = create_date.substring(9, 10);
		
		month = month.length() > 1 ? month : "0" + month;
		date = date.length() > 1 ?date : "0" + date;
		
		this.create_date = year + "-" + month + "-" + date;
	}

}
