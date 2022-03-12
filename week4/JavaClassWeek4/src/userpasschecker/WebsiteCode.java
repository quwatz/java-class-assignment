package userpasschecker;

import java.util.Scanner;

class Student{
	String name;
	String username;
	String password;
	Student(String name,String username,String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}
}
public class WebsiteCode {

	public static void main(String[] args) {
		Student[] studentDataBase = {
				new Student("arshia","arshia","pass1234"),
				new Student("notArshia","totallyNotArshia","pass4321"),
				new Student("quwatzoki","quwatz","idk123"),
				new Student("Absentiya","Absentiya","idc123"),};
		try {
			login(studentDataBase);
		}
		catch(Exception e) {
			System.out.println("a problem occured!: "+ e);
		}
		

	}

	private static void login(Student[] info) throws LoginInfoException {
		boolean didFindName = false;
		boolean didFindUserOrPassword=false;
		Scanner scan = new Scanner(System.in);
		System.out.println("hi! please enter your name: ");
		String newName = scan.nextLine().toLowerCase();
		System.out.println("great! now enter your username: ");
		String newUserName = scan.nextLine();
		System.out.println("great! now enter your password: ");
		String newPassWord = scan.nextLine();
		for (int i=0;i<info.length;i++) {
			if (newName.equals(info[i].name)) didFindName = true;
			if (newPassWord.equals(info[i].password) && newUserName.equals(info[i].username)) didFindUserOrPassword = true;
		}
		if (!didFindName) throw new LoginInfoException("\n sorry but we couldn't find your name");
		if (!didFindUserOrPassword && didFindName) throw new LoginInfoException("\n invalid username or password");
		else System.out.println("great! you're in");
		
	}
}
