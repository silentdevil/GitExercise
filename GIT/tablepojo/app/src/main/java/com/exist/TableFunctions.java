package com.exist;

enum TableFunctions {
	SEARCH(1,"SEARCH"),
	CHANGEKEY(2,"CHANGE KEY"),
    CHANGEVALUE(3,"CHANGE VALUE"),
	ADDCELL(4,"ADD CELL"),
	SAVE(5,"SAVE"),
    PRINT(6,"PRINT"),
    CREATE(7,"CREATE"),
    EXIT(8, "EXIT");
	
    private final String message;
    private final int id;
    public final static int SIZE = 8;
    TableFunctions(int id, String message) {
		this.message = message;
		this.id = id;
	}

	public String toString() {
	  return id + ": " + message; 
	}

	public static TableFunctions valueOf(int i) {
		for(TableFunctions t : TableFunctions.values()) {
			if(t.id == i)
				return t;
		}
		return null;
	}
}