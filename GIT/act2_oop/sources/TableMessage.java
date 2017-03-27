public enum TableMessage {
    INSERT_SUCCESS("Insert Success"),
	INSERT_FAILED("Insert failed"),
    ROW_NOT_EXISTING("The row number doesn't exist"),
	COLUMN_NOT_EXISTING("The column number doesn't exist"),
	COORD_NOT_EXISTING("The coordinate doesn't exist"),
    NO_TABLE_CREATED("No table created"),
	NO_DUPLICATE_KEY("Table prevent duplicate key"),
	KEY_CHANGE_SUCCESS("Key change successful"),
	KEY_CHANGE_FAIL("Key change failed"),
	KEY_NOT_FOUND("Key not found"),
	VALUE_CHANGE_SUCCESS("Value change successful"),
	FILE_NOT_FOUND("File not found. default file provided"),
 	INPUT_NOT_POSITIVE_INTEGER("Error: Input is not a positive Integer"),
	COMMAND_NOT_FOUND("Command not found");
	
    private final String message;

    TableMessage(String message) {
		this.message = message;
	}

	public String toString() {
	  return message; 
	}
}

	
class InputErrorException extends Exception {
	
}