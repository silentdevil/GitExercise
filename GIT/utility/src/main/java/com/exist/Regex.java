package com.exist.utility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static int occurence(String one, String two) {
		int counter = 0;
    	int pos = 0;
		Pattern pattern = Pattern.compile("("+two+")");
        Matcher matcher = pattern.matcher(one);
		
		while(matcher.find(pos)) {
		    counter++;
		    pos = matcher.start() + 1;
		}
		
		return counter;
	}

	public static ArrayList<String> tokenizer(String stream) {
		ArrayList<String> stringList = new ArrayList<>();

		String pattern = "(?<=\\()(?:[^()]+|\\([^)]+\\))+(?=\\))|(?<=\\()?\\((?:[^()]+|\\([^)]+\\))?\\)+(?=\\))";
      	Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(stream);

	    while(m.find()) {
	    	stringList.add(m.group());
	    }

	    return stringList;
	}
}
