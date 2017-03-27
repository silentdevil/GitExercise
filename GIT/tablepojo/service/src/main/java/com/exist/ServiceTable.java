package com.exist;

import com.exist.utility.FileManager;
import com.exist.utility.Regex;
import java.io.File;
import java.util.*;

public class ServiceTable {
	private Table table = new Table();
	private FileManager fileManager;
	ArrayList<Row> rowList = table.getList();

	public ServiceTable(String input) throws Exception {
		File file = new File("/home/jmcarpio/tablepojo/app/src/main/resources/" + input);
		if(input.isEmpty() || input == null || !file.exists()) {
			System.out.println("File does not exist. Default file loaded");
			fileManager = new FileManager(getClass().getResourceAsStream("/default.txt"), 
				getClass().getResource("/default.txt"));
			fileManager.setFile("/home/jmcarpio/tablepojo/app/src/main/resources/default.txt");
			return;
		}
		 fileManager = new FileManager(file);
	}

	public void setTable(Table table) {
		this.table = table;
		rowList = table.getList();
	}

	public void print() {
		rowList.forEach(row -> {
			row.getList().forEach(System.out::print);
			System.out.println();
		});
	}

	public void create(int rows, int cols) throws Exception {
		for(int i = 0; i < rows; i++) {
			rowList.add(new Row());
			for(int j = 0; j < cols; j++) {
				rowList.get(i).getList().add(CellFactory.newCell());
			}
		}
		save();
	}

	public void addCell(int row) {
		if(row <= rowList.size()) {
			if(row == rowList.size())
				rowList.add(new Row());
			rowList.get(row).getList().add(new Cell("ADD","CELL"));
		}
	}

	public void search(String pattern) {
		for(int i = 0; i < rowList.size(); i++) {
			int rowOccurence = 0;
			ArrayList<Cell> cellList = rowList.get(i).getList();
			for(int j = 0; j < cellList.size(); j++) {
				int keyOccurence = Regex.occurence(cellList.get(j).getKey(),pattern);
				int valOccurence = Regex.occurence(cellList.get(j).getValue(),pattern);

				if(keyOccurence + valOccurence > 0) {
					System.out.println("("+i+","+j+") key : " + keyOccurence + ", value : " + valOccurence);
					rowOccurence += (keyOccurence + valOccurence);
				}
			}
			if(rowOccurence > 0)
				System.out.println("\t\t" + rowOccurence + " in row " + i + ".");
		}
	}

	public void changeKey(int row, int col, String key) throws Exception {
		if(!CellFactory.containsKey(key)) {
			Cell cell = rowList.get(row).getList().get(col);
			CellFactory.removeKey(cell.getKey());
			cell.setKey(key);
			CellFactory.addKey(key);
		}
		save();
	}

	public void changeValue(int row, int col, String value) {
		rowList.get(row).getList().get(col).setValue(value);
		save();
	}

	public void save() {
		fileManager.writer("",false);
		rowList.forEach(row -> {
			row.getList().stream().forEach(cell -> fileManager.writer(cell.toString(),true));
			fileManager.writer("\n",true);
		});
	}

	public void load() {
		fileManager.reader().forEach(r ->rowList.add(CellFactory.rowParser(r)));
	}
}