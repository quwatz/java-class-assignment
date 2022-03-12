
import java.util.Scanner;

class Student{
	String name;
	String surname;
	int age;
	Student(String name,String surname,int age){
		this.name = name;
		this.surname = surname;
		this.age = age;	
	}
}
public class StudentRegisteryCode {
	public static void main(String[] args) {
		int quantity = new Scanner(System.in).nextInt();
		Student[] users=new Student[quantity];
		//get users info
		GetUsers(users);
		//ShowUsers(users);
	}
	static void GetUsers(Student[] usersArray) {
		Scanner scan = new Scanner(System.in);
		for (int i=0;i<usersArray.length;i++) {
			System.out.println("registering user: "+(i+1));
			System.out.println("enter your name, then your surname, and at last your age");
			usersArray[i] = new Student(scan.nextLine(),scan.nextLine(),scan.nextInt());
			scan.nextLine();
			try {
			CheckUsers(usersArray,usersArray[i],i);
			}
			catch (Exception e) {
				System.out.println("Problem detected: "+ e);
			}
		}
	}
	static void ShowUsers(Student[] usersArray) {
		for (int i=0;i<usersArray.length;i++) {
			System.out.println("user "+i+" is: "+usersArray[i].name+" "+usersArray[i].surname+" who's"+usersArray[i].age);
		}
	}
	static void CheckUsers(Student[] usersArray,Student sussyStudent,int index) throws StudentDuplicateException{
		for (int i=0;i<index;i++) {
			if ((sussyStudent.name.equals(usersArray[i].name))
				&& (sussyStudent.surname.equals(usersArray[i].surname))
				&& (sussyStudent.age == usersArray[i].age)){
				throw new StudentDuplicateException("\n this account already exists!");
			}
		}
		
	}
}