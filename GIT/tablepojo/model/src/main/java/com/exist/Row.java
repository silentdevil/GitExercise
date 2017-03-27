package com.exist;

import java.util.ArrayList;

public class Row {

	private ArrayList<Cell> cellList = new ArrayList<>();

	public void setList(ArrayList<Cell> cellList) {
		this.cellList = cellList;
	}

	public ArrayList<Cell> getList() {
		return cellList;
	}
}