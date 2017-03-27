package com.exist;
import com.exist.utility.InputManager;

public class Main {

	public static void main(String[] args) throws Exception {
		String file = "";
		try {
			file = args[0];
		} catch (Exception ex) {
			file = "";
		} 
		
		ServiceTable st = new ServiceTable(file);

		st.load();
		st.print();	
		outer:
		while(true) {
			try {
				System.out.println("What to do: ");
				for(int i = 1; i <= TableFunctions.SIZE; i++) {
					System.out.print(TableFunctions.valueOf(i) + "\t"); 
				}
				System.out.println();
				switch(TableFunctions.valueOf(InputManager.getPositiveNumber(""))) {
					case SEARCH: 
						st.search(InputManager.enterString("What to search: ")); 
						break;
					case CHANGEKEY:	
						st.changeKey(InputManager.getPositiveNumber("row"),
							InputManager.getPositiveNumber("col"),InputManager.enterKey("NEW")); 
						st.print(); 
						break;
					case CHANGEVALUE:	
						st.changeValue(InputManager.getPositiveNumber("row"),
							InputManager.getPositiveNumber("col"),InputManager.enterString("New Value")); 
							st.print(); 
							break;
					case ADDCELL:	
						st.addCell(InputManager.getPositiveNumber("Row Number")); 
						st.print(); 
						break;
					case SAVE: 
						st.save(); 
						break;
					case PRINT:	
						st.print(); 
						break;
					case CREATE: st.create(InputManager.getPositiveNumber("rows"),InputManager.getPositiveNumber("cols"));
						st.print();
						break;
					case EXIT: break outer;
				}
			} catch(Exception ex) {
				System.out.println(ex);
			}
		}
	}
}
