package stringanalysiscode;

import java.util.Scanner;

public class StringAnalysisCode {

	public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine();
		try {
			CheckForNumbers(input);
			System.out.println("your string is "+input.length()+" letters long");
			main(args);
		}
		catch(Exception e) {
			System.out.println("error: "+e);
			main(args);
		}
		
	}
	static void CheckForNumbers(String str) throws StringException {
		for (int i=0;i<10;i++) {
			if (str.contains(String.valueOf(i))) throw new StringException("\nyour string contains a number!");
		}
	}

}
