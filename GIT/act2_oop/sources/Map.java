import java.util.*;

public class Map implements MapInterface, Comparable<Map>{
	private String key;
	private String value;
	//private String id;
	
	public Map (String K, String V) {
		//id = ID;
		key = K;
		value = V;
	}
	
	public void changeKey (String key, String newKey) {
		if(key.trim().equals(this.key.trim())) { //if(ID.trim().equals(id.trim())) {
			this.key = newKey;
		}
	}
	
	public void changeValue (String Key, String newValue) {
		if(Key.trim().equals(key.trim())) {
			value = newValue;
		}
	}
	
	public String get(String Key) {
		if(Key.trim().equals(key.trim())) {
			return value;
		}
		return "";
	}
	
	public String getValue() {
		return value;
	}
	
	public String getKey() {
		return key;
	}
	
	/*public String getID() {
		return id;
	}*/
	
	public String toString() {
		return "\t(" + key.trim() + "," + value.trim() + ")\t";
	}
	
	public String printSort(String identifier) {
		char[] k = key.toCharArray();
		char[] v = value.toCharArray();
		
		/*Arrays.sort(k);
		Arrays.sort(v);
		
		String string = String.valueOf(k) + String.valueOf(v);
		char[] sortedString = string.toCharArray();
		Arrays.sort(sortedString);*/
		
		String newKey = String.valueOf(k);
		String newValue = String.valueOf(v);
		/*
		if(identifier.trim().equals("SortAll")) {
			newKey = (String.valueOf(sortedString)).substring(0,k.length);
			newValue = (String.valueOf(sortedString)).substring(k.length);
			
		} else if(identifier.trim().equals("Reverse")) {
			newKey = String.valueOf(InputManager.reverseArray(k));
			newValue = String.valueOf(InputManager.reverseArray(v));
			
		} else if (identifier.trim().equals("ReverseAll")) {
			sortedString = InputManager.reverseArray(sortedString);
			newKey = (String.valueOf(sortedString)).substring(0,k.length);
			newValue = (String.valueOf(sortedString)).substring(k.length);
		}*/
		//key = newKey; value = newValue;
		return "\t(" + newKey + "," + newValue + ")\t";
		//if sort is to be saved, switch vals;	
	}
	
	 @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Map)) {
            return false;
        }
        Map map = (Map) o;
        return Objects.equals(key, map.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
	
	public int compareTo(Map m) {
		return key.compareTo(m.getKey());
	}
	
}
	
