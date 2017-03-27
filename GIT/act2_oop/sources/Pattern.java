public class Pattern {
	
	public static int occurencies(String one, String two) {
		int counter = 0;
    	int pos = 0;
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("("+two+")");
        java.util.regex.Matcher matcher = pattern.matcher(one);
		
		while(matcher.find(pos)) {
		    counter++;
		    pos = matcher.start() + 1;
		}
		
		return counter;
	}
}