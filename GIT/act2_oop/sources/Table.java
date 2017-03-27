import java.util.*;

public class Table extends MapManager {
	//MapManager mapManager = new MapManager();
	ArrayList<Row> rows = new ArrayList<Row>(); // set is better as of this day
	
	//@Overload
	public void changeKey(int x, int y) throws IndexOutOfBoundsException {
		Map m = rows.get(y).getMap(x);
		super.changeKey(m.getKey(), InputManager.enterString("New Key"));
	}
	
	public void changeValue(int x, int y) throws IndexOutOfBoundsException {
		Map m = rows.get(y).getMap(x);
		super.changeValue(m.getKey(), InputManager.enterString("New Value"));
	}
	
	
	public void addRow(String key, String value) {
		Map m = createMap(key, value);
		if(m!=null)
			rows.add(new Row(m));
	}
	
	//but if there will be additional functions, list 	
	public void save() {
		InputManager.resetWriter(false);
		InputManager.writer(InputManager.newDelimeterOne + " " + InputManager.newDelimeterTwo);
		for(Row r: rows) {
			InputManager.writer(r.toString());
		}
	}
	
	public void load(String str) {
		//System.out.println(InputManager.delimeterOne);
		InputManager.openFile(str);
		if(InputManager.isFileEmpty())
			InputManager.writer(InputManager.newDelimeterOne + " " + InputManager.newDelimeterTwo);
		rows.clear();
		resetCounter();
		ArrayList<String> lines = InputManager.reader();
		//try {
			for(int i = 0; i < lines.size(); i++) {
				Row r = new Row(this, lines.get(i));
				rows.add(r);
				//System.out.println(lines.get(i));
			}
		//} catch(Exception ex) {}
		printTable();
	}
	
	public void search(String str) {
		int total = 0;
		for(int i = 0; i < rows.size(); i++) {
			int count = rows.get(i).rowOccurence(str,i);
			total += count;
		}
		
		System.out.println(total + " occurence/s of " + str);
	}
	
	public void createTable(int x, int y) {
		if(x == 0 || y == 0) 
			System.out.println(TableMessage.NO_TABLE_CREATED);
		else {
			InputManager.resetWriter(false);
			rows.clear();
			resetCounter();
			
			for(int i = 0; i < y; i++) {
				Row r = new Row(this, x);
				rows.add(r);
			}
			printTable();
			save();
		}
	}
	
	public void printTable() {
		int ctr = 0;
		for(Row r: rows) {
			System.out.print("Row#" + ctr++);
			r.printRow();	
		}
	}
	
	public void printSort(String str) throws InputErrorException {
		
		if(str.trim().equals("all")) {
			for(Row r: rows) {
				r.printSort("");	
			}
			//return;
		}
		else
			rows.get(InputManager.getPositiveNumber("Row Number")).printSort("");
		
		printTable();
		
	}
	
	public void reverseSort(String str) throws InputErrorException {
		if(str.trim().equals("all")) {
			for(Row r: rows) {
				r.printSort("reverse");	
			}
			//return;
		}
		else
			rows.get(InputManager.getPositiveNumber("Row Number")).printSort("reverse");
		printTable();
	}
	public void addCell (int rowNumber, String key, String value) {
		try {
			//int rowNumber = InputManager.getPositiveNumber("Row Number");
			if(rowNumber > rows.size()) {
				throw new IndexOutOfBoundsException();
			}
			else if (rowNumber == rows.size()) {
				addRow(key, value);
				return;
			}
			rows.get(rowNumber).addCell(this.createMap(key, value));
			save();
			printTable();
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(TableMessage.ROW_NOT_EXISTING);
			System.out.println(TableMessage.INSERT_FAILED);
		}
	}
}
