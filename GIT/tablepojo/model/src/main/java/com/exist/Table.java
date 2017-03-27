package com.exist;

import java.util.ArrayList;

public class Table {
	private ArrayList<Row> rowList = new ArrayList<>();

	public void setList(ArrayList<Row> rowList) {
		this.rowList = rowList;
	}

	public ArrayList<Row> getList() {
		return rowList;
	}

}