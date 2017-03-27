//import java.util.*;
//import java.io.*;
public class StringGrid {
    
	public static void main(String[] args) {
		
		Table a = new Table();
		if(args.length > 0) {
			a.load(args[0]);
		} else {
			a.load("default.txt");
		}
			
		String val = "";
		
		while(!val.equals("EXIT")) {
		    System.out.println("\nWhat do you want to do?");
			System.out.println("[PRINT, EDITKEY, CREATE, SEARCH, SAVE, LOAD, EDITVALUE, SORT, ADDCELL, SORTALL]");
			System.out.println("[REVERSE, REVERSEALL]");
			val = (InputManager.enterString("Action").toUpperCase());
			
			try {
				switch(val) {
					case "ADDCELL": 
					a.addCell(InputManager.getPositiveNumber("Row Number"), 
						InputManager.enterKey(""), InputManager.enterString("Value"));
					break;
					case "PRINT": 
						a.printTable();
						break;
					case "EDITKEY": 
						a.changeKey(InputManager.getPositiveNumber("Column No."),
									InputManager.getPositiveNumber("Row No."));
						a.save();
						break;
					case "EDITVALUE": 
						a.changeValue(InputManager.getPositiveNumber("Column No."),
									InputManager.getPositiveNumber("Row No."));
						a.save();
						break;	
					case "CREATE": 
						a.createTable(InputManager.getPositiveNumber("X"),InputManager.getPositiveNumber("Y"));
						break;
					case "SORT": 
						a.printSort("");break;
					case "SORTALL": 
						a.printSort("all");break;
					case "REVERSE": 
						a.reverseSort("");break;
					case "REVERSEALL": 
						a.reverseSort("all");break;
					case "SEARCH": 
						a.search(InputManager.enterString("part of string"));
						break;
					case "LOAD":
						a.load(InputManager.enterString("filename"));break;
					case "SAVE":
						a.save();break;
					case "EXIT": 
						break;

					default: System.out.println(TableMessage.COMMAND_NOT_FOUND);
				} // end of switch
			} catch(InputErrorException ex) {
				System.out.println(TableMessage.INPUT_NOT_POSITIVE_INTEGER);
			} catch(IndexOutOfBoundsException ex) {
				System.out.println(TableMessage.COORD_NOT_EXISTING);
			} finally {
				InputManager.closeFile();
			}
		} // end of while
	}
	
}
