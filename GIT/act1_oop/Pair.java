import java.util.Scanner;
public class Pair {
	
	private static int x = -1;
	private static int y = -1;
	private static String X;
	//private static String Y;
	private static final Scanner scan = new Scanner(System.in);
	
	private static final Pair p = new Pair();
	
	private Pair() {
	}
	
	public static Pair createPair() {
		
		do {
			x = set("X");
			if(x > -1) {
				do {
					y = set("Y");
				} while (y == -1);
				
			} 
		} while (x == -1);
		
		return p;
	}
	
	private static int set(String letter) {
		System.out.print("Enter value for " + letter + ": ");
		X = scan.nextLine();
		if(isNumeric(X) && !X.isEmpty()) {
			return Integer.parseInt(X);
		} else {
			return -1;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static boolean isNumeric(String s){ 
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return true;
	}
	
}