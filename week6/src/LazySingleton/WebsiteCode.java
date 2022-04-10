package LazySingleton;

import java.util.Scanner;

public class WebsiteCode {
	
	public static void main(String args[]) {
		LazyRegistry registrator = LazyRegistry.getInstange();
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your username");
		registrator.setUserName(scanner.nextLine());
		System.out.println("please enter your password");
		String passTemp = scanner.nextLine();
		System.out.println("please confirm your password");
		if (passTemp.equals(scanner.nextLine()))
			registrator.setPassWord(passTemp);
		else {System.out.println("passwords don't match!!!");return;}
		System.out.println("username: " + registrator.getUserName());
		System.out.println("password: " + registrator.getPassWord());
	}

}
