package com.exist;

import com.exist.utility.Regex;
import java.util.HashSet;
import java.util.List;
import com.exist.utility.InputManager;

public class CellFactory {
	private static HashSet<String> keySet = new HashSet<>();

	public static Cell newCell() throws Exception  {
		String key = InputManager.randomizeChar(65,90,3,6);
		String value = InputManager.randomizeChar(65,90,3,6);
		return createCell(key,value);
	}

	public static Cell createCell(String key, String value) throws Exception {
		addKey(key);
		return new Cell(key, value);
	}

	public static void addKey(String key) throws Exception {
		if(!keySet.add(key)) {
			throw new Exception("Duplicate Key");
		}
	}

	public static boolean containsKey(String key) {
		return keySet.contains(key);
	}

	public static void removeKey(String key) {
		keySet.remove(key);
	}

	public static Row rowParser(String stream) {
		Row row = new Row();
		List<String> stringList = Regex.tokenizer(stream);
		stringList.forEach(s  -> row.getList().add(cellParser(s)));
		return row;

	}

	public static Cell cellParser(String stream) {
		Cell cell = null;
		try {
			String[] split = stream.split(",");
			cell = createCell(split[0], split[1]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cell;
	}

}