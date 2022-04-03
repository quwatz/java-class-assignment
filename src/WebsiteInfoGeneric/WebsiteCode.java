package WebsiteInfoGeneric;

import java.util.Scanner;

public class WebsiteCode {

	public static void main(String[] args) throws CloneNotSupportedException{
		//new user
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your username and then your password.");
		UserClass<String,String> realUser = new UserClass<String,String>(scanner.nextLine(),scanner.nextLine());
		UserClass<String,String> cloneUser1 = (UserClass<String, String>) realUser.clone();
		UserClass<String,String> cloneUser2 = (UserClass<String, String>) realUser.clone();
		printInfo(realUser);
		printInfo(cloneUser1);
		printInfo(cloneUser2);
		
	}

	private static void printInfo(UserClass<String, String> user) {
		
		System.out.println("username = "+ user.username + " password: "+ user.password);
	}

}
