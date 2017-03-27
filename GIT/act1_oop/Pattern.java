public class Pattern {
	private Pattern() {
	}
	
	public static int occurencies(String one, String two) {
		int counter = 0;
		
		if(one.contains(two)) {
			boolean match = false;
			
			if(two.isEmpty()) {
				if(one.isEmpty()) {
					counter = 1;
				}
			} else {
				for(int k = 0; k < one.length(); k++) {
					if(two.charAt(0) == one.charAt(k) && (one.length()-k) >= two.length()) {
						match = true;
						
						for(int l = 1;l<two.length();l++) {
							if(two.charAt(l) == one.charAt(k+l)) {
								continue;
							} else{
								match = false;
								break;
							}
							
						} // END OF SECOND LOOP
						
						if(match == true) {
							counter++;
						}
					}
				} // END OF FIRST LOOP	
			}
			
		}
		
		return counter;
	}
}