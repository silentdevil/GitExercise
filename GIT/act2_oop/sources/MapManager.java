import java.util.*;
//import java.io.*;

public class MapManager implements MapInterface{
	
	protected java.util.HashSet<Map> mapManager = new HashSet<Map>();
	protected HashSet<String> keySet = new HashSet<String>();
	
	protected int counter;
	
	public void resetCounter() {
		counter = 0;
		keySet.clear();
		mapManager.clear();
	}
	
	public Map createMap(String key, String value) {
		//String b = String.format("%04d", counter++).trim();
		Map m;
		if(mapManager.add(m = new Map(key,value))) {
			keySet.add(key);
			return m;
		} else {
			System.out.println(TableMessage.NO_DUPLICATE_KEY);
			return null;
		} 		  
	}
	
	
	
	public void changeKey(String key, String newKey) {
		for(Map m : mapManager) {
			String id = m.getKey();
			
			if(key.trim().equals(m.getKey().trim()) &&  keySet.add(newKey.trim())) {
				m.changeKey(key, newKey);
				keySet.remove(key);
				System.out.println(TableMessage.KEY_CHANGE_SUCCESS);
				return;
			}
		}
		
		if(keySet.contains(key)) {
			System.out.println(TableMessage.NO_DUPLICATE_KEY);
		} else {
			System.out.println(TableMessage.KEY_NOT_FOUND);
		} 
			
	}
	
	public void changeValue (String key, String value) {
		for(Map m : mapManager) {
			if(key.trim().equals(m.getKey().trim())) {
				m.changeValue(key, value);
				System.out.println(TableMessage.VALUE_CHANGE_SUCCESS);
				return;
			}
		}
		if(!keySet.contains(key))
			System.out.println(TableMessage.KEY_NOT_FOUND);
	}
	/*
	public void mapScan(String identifier,String key, String value) {
		boolean success = false;
		for(java.util.Map.Entry<String, Map> m : mapManager.entrySet()) {
			//try {
				Map map = m.getValue();
				if(key.trim().equals(map.getKey().trim())) {
					if(identifier.trim().equals("changeValue")) {
						map.changeValue(key, value);	
						System.out.println("Value was changed");
					} else if(identifier.trim.equals("changeKey") && !containsKey(value)) {
							map.changeKey(map.getID(), value);
							keyList.remove(keyList.indexOf(key));
							System.out.println("Key was changed");
					}
					success = true;
				}
			//}catch(Exception ex) {ex.printStackTrace();}
		}
		if(!success)
			System.out.println("Key not found");
	}*/
}