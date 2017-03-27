import java.util.*;
import java.io.*;

public class InputManager {
	
	public static String delimeterOne;
	public static String delimeterTwo;
	
	public static String newDelimeterOne;
	public static String newDelimeterTwo;
	
	private static Scanner scan = new Scanner(System.in);
	private static File f = new File("default.txt");
	private static FileOutputStream fos;
    private static BufferedWriter bw; 
	private static PrintWriter out;
	private static OutputStreamWriter os;
	
	//private static BufferedReader bufferedReader;
	// File Handling Utility methods
	static {
			resetWriter(true);
			newDelimeterOne = randomDelimeter();
			newDelimeterTwo = randomDelimeter();
			
	}
	
	public static void resetWriter(boolean append) {
		try{
			fos = new FileOutputStream(f,append); //dont overwrite
			os = new OutputStreamWriter(fos, "UTF-8");
			bw = new BufferedWriter(os);
			out = new PrintWriter(bw);
			//bufferedReader = new BufferedReader(new FileReader(f));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void writer (String text) {
			//resetReaderAndWriter(true);
			try {
			fos = new FileOutputStream(f,true);
    		out.println(text);
			out.flush();
			}catch(Exception ex){}
	}

	public static void openFile(String fileName) {
		try {	
			File file = new File(fileName);
			if(file.exists() && !f.isDirectory()) {
				System.out.println("File successfully loaded "+fileName );
				f = file;
				fos = new FileOutputStream(f,true);
			}
			else {
				System.out.println(TableMessage.FILE_NOT_FOUND);
			}
		}catch(IOException ex) {}
	}
	
	public static void closeFile() {
			out.close();
	}
	
	public static boolean isFileEmpty() {
		//BufferedReader br
		try {
			BufferedReader br = new BufferedReader(new FileReader(f)); 
			return (br.readLine() == null);
		} catch(IOException ex) {}
		
		return false;
	}
	
	
	
	public static ArrayList<String> reader() {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
			String line;
			while((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			bufferedReader.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		String delims = lines.get(0);
		String[] delm = delims.split(" ");
		delimeterOne = delm[0];
		delimeterTwo = delm[1];
		//try {
		//if(lines.get(1)!=null)
 			return new ArrayList<String>(lines.subList(1,(lines.size())));
		//}catch(Exception ex) {
		
		//}
		//return null;
		
	}
	
	//Input verifications
	public static int getPositiveNumber(String str) throws InputErrorException {
		System.out.print("Enter a non-negative integer for "+str+" : ");
		String X = scan.nextLine();
		int i = 0;
		
		if(isNumeric(X) && !X.isEmpty() && Integer.parseInt(X) >= 0) {
			i = Integer.parseInt(X);
		}
		else {
			throw new InputErrorException();
		}
		return i;
	}
	
	public static String enterKey(String name) {
		System.out.println("Enter "+name+" key: ");
		String str = scan.nextLine();
		String[] split = str.split(" ");
		
		return String.join("",split);
	}
	
	public static String enterString(String str) {
		System.out.println("Enter "+str+" :");
		return scan.nextLine();
	}
	
	public static char[] reverseArray(char[] chars) {
		char[] charArray = new char[chars.length];
		
		for(int i=chars.length-1; i>=0; i--) {
			charArray[(chars.length - 1) - i] = chars[i];
		}
		return charArray;
	}
	
	public static boolean isNumeric(String s){ 
		try {
			int i = Integer.parseInt(s);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}

	public static String randomizeChar(char[] str) {
		int len = (int) (Math.random() * 3) + 3;
		str = new char[len];
		for(int i=0;i<len;i++) {
			str[i] = (char) ((int)(Math.random() * 25) + 65);
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
	//output
	public static void printSearch(java.util.Map.Entry <Map, ArrayList<Integer>> m) {
		System.out.print("\t Col#" + m.getValue().get(0) + " = " + m.getKey().toString().replace("\t","") + 
						 "(key=" +m.getValue().get(2) + ",value=" + m.getValue().get(3) + ")");
	}
	
}	
