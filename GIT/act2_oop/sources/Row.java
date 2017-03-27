import java.util.*;
//import java.io.*;

public class Row{
	private  ArrayList <Map> cols = new ArrayList<Map>();
	private java.util.Map<Map, ArrayList<Integer>> indices = new LinkedHashMap<Map,ArrayList<Integer>>();
	
	public Row(MapManager mapManager, int size) {
		for(int i = 0; i < size; i++) {
			cols.add(mapManager.createMap(InputManager.randomizeChar("".toCharArray()),
										 InputManager.randomizeChar("".toCharArray()))); //randomizer for key and value
		}
	}
	
	public Row(MapManager mapManager, String str) {
		System.out.println(InputManager.delimeterOne);
		String[] rowSplit = str.split(InputManager.delimeterTwo);
		for(String s: rowSplit) {
			String[] mapSplit = s.split(InputManager.delimeterOne);
			cols.add(mapManager.createMap(mapSplit[0],mapSplit[1]));
		}
		
	}
	
	public Row(Map m) {
		//Map m = mapManager.createMap(InputManager.enterString("Key"), InputManager.enterString("Value"));
		if(m!=null)
			cols.add(m);
	}
	
	public Map getMap(int index) {
		return cols.get(index);
	}
	
	public int rowOccurence(String str,int index) {
		int counter = 0;
		indices.clear();
		ArrayList<Integer> keysAndValues = keysAndValues = new ArrayList<Integer>();
		for(int i=0; i < cols.size(); i++){
			keysAndValues = new ArrayList<Integer>();
	
			int key = Pattern.occurencies(cols.get(i).getKey(), str);
			int value = Pattern.occurencies(cols.get(i).getValue(), str);
			int occurence = key + value;
			
			counter += occurence;
			if(occurence > 0) {
				keysAndValues.add(i);
				keysAndValues.add(occurence);
				keysAndValues.add(key);
				keysAndValues.add(value);
				indices.put(cols.get(i),keysAndValues);
			}
			
		}
		printRowOccurence(counter,str,index);
		return counter;
	}
	
	
	
	public void printRowOccurence(int count, String str, int index) {
		if(count > 0) {
			System.out.println(count + " occurence/s of " + str + " at Row#" + index + ":");
			
			for(java.util.Map.Entry<Map, ArrayList<Integer>> m : indices.entrySet()) {
				InputManager.printSearch(m);
			}
			
			System.out.println();
		}
	}

	public void printRow() {
		for(Map m : cols) {
			System.out.print(m);
		}
		System.out.println();
	}
	
	public void printSort(String str) {
		/*for(Map m : cols) {
			System.out.print(m.printSort(str));
		}
		System.out.println();
		*/
		Collections.sort(cols);
		if(str.trim().equals("reverse"))
			Collections.reverse(cols);
	}
	
	public void addCell(Map m) {
		if(m != null) {
			cols.add(m);
			System.out.println(TableMessage.INSERT_SUCCESS);
		}
		else {}
	}
	
	public String toString() {
		String str = "";
		for(Map m : cols) {
			str += m.getKey().trim()+(InputManager.newDelimeterOne)+m.getValue().trim()+InputManager.newDelimeterTwo;
		}
		return str;
	}
}