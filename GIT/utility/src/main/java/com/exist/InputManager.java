package com.exist.utility;

public class InputManager {

	private static java.util.Scanner scan = new java.util.Scanner(System.in);
	
	public static int getPositiveNumber(String str) throws Exception {
		System.out.print("Enter a non-negative integer for "+str+" : ");
		String X = scan.nextLine();
		int i = 0;
		
		if(isNumeric(X) && !X.isEmpty() && Integer.parseInt(X) >= 0) {
			i = Integer.parseInt(X);
		}
		else {
			throw new Exception();
		}
		return i;
	}
	
	public static String enterKey(String name) {
		System.out.println("Enter "+ name +" key: ");
		String str = scan.nextLine();
		String[] split = str.split(" ");
		
		return str = (str.isEmpty()) ? ("null") : String.join("",split);
	}
	
	public static String enterString(String str) {
		System.out.println("Enter "+str+" :");
		return scan.nextLine();
	}
	
	public static boolean isNumeric(String s){ 
		try {
			int i = Integer.parseInt(s);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}

	public static String randomizeChar(int min,int max, int lenMin, int lenMax) {
		int len = (int) (Math.random() * (lenMax-lenMin)) + lenMin;
		char[] str = new char[len];
		for(int i=0;i<len;i++) {
			str[i] = (char) ((int)(Math.random() * (max-min)) + min);
		}
		return String.valueOf(str);
	}
	
	public static String randomDelimeter() {
		int len = (int) (Math.random() * 3) + 3;
		char[] str = new char[len];
		for(int i=0;i<len;i++) {
			str[i] = (char) ((int)(Math.random() * 10) + 1000);
		}
		return String.valueOf(str);
	}	
}	
