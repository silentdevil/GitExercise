import java.util.Scanner;

public class Activity1 {
    
	private String[][] stringGrid;
	private int x;
	private int y;
	private static Scanner scan;
	private Pair p;
	
	public static void main(String[] args) {
		Activity1 a = new Activity1();
		a.create();
		String val = "";
		
		scan = new Scanner(System.in);
		
		while(!val.equals("EXIT")) {
		    System.out.print("What do you want to do? [PRINT, EDIT, RECREATE, SEARCH, EXIT]");
			val = (scan.nextLine().toUpperCase());
			
			switch(val) {
				case "PRINT": 
					a.print();
					break;
				case "EDIT": 
					a.edit();
					break;
				case "RECREATE": 
					a.create();
					break;
				case "SEARCH": 
					a.search();
					break;
				case "EXIT": 
					break;

				default: System.out.println("Please enter a valid input");
			} // end of switch
		} // end of while
	}
	
	private void search() {
		int counter = 0;
		
		System.out.print("Search: ");
		String str = scan.nextLine();
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				int occurence = Pattern.occurencies(stringGrid[i][j], str);
				
				if(occurence > 0) {
					counter += occurence;
					String address = "(" + i + "," + j + ")";
					
					System.out.println(address + " with "+ occurence + " occurence/s");
				}
			}
		}
		System.out.println(str +" has "+ counter +" occurence/s");
	}
	
	private void create() {
		p = Pair.createPair();
		char[] str = null;
		if(p.getX() > 0 && p.getY() > 0) { 
			x = p.getX(); 
			y = p.getY();
			
			if(x > 0 && y > 0) {
				stringGrid = new String[x][y];
				
				for(int i=0;i<x;i++) {
					for(int j=0;j<y;j++) {
						stringGrid[i][j] = randomizeChar(str);
					}
				}

			}
			
			print();
			return;
		}
		System.out.println("Table not created");
	}
	
	private void print() {
		if(x < 1 && y < 1) {
			System.out.println("No table created");
		}
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				String address = "(" + j + "," + i + ")";
				
				System.out.print("\t"+address+stringGrid[j][i]+"\t");
			}
			System.out.println();
		}
	}
	
	private String randomizeChar(char[] str) {
		int len = (int) (Math.random() * 4) + 1;
		str = new char[len];
		for(int i=0;i<len;i++) {
			str[i] = (char) ((int)(Math.random() * 74) + 48);
		}
		
		return String.valueOf(str);
	}
	
	private void edit() {
		if(x > 0 && y > 0) {
			p = Pair.createPair();
			int a = p.getX(); 
			int b = p.getY();
			
			if(a > x - 1 || b > y - 1){
				System.out.println("Value greater than the range");
			} else if(a > -1 && b > -1){
				System.out.println("Your new word: ");
				String str = scan.nextLine();
				
				stringGrid[a][b] = str;
				
				print();
				
			}
			return;
		} 
		     System.out.println("No table created");
		
	}
}
