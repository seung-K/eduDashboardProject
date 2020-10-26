package com.eduDashboardProject.board.dto;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String board_number;
	private String user_number;
	private String identification;
	private String title;
	private String comment;
	private String create_date;

	public void makeInsertDateFormmat(String create_date) {
		
		String year = create_date.substring(0, 4);
		String month = create_date.substring(6, 7);
		String date = create_date.substring(9, 10);
		
		month = month.length() > 1 ? month : "0" + month;
		date = date.length() > 1 ?date : "0" + date;
		
		this.create_date = year + "-" + month + "-" + date;
	}

}
