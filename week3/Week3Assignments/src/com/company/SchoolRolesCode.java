package com.company;
abstract class Role{
	abstract void showRole();
}

class Teacher extends Role{

	@Override
	void showRole() {
		System.out.println("Teacher");
	}
}
class Student extends Role{

	@Override
	void showRole() {
		System.out.println("Student");
	}
}
class Employee extends Role{
	@Override
	void showRole() {
		System.out.println("Employee");
	}
}


public class SchoolRolesCode {

	public static void main(String[] args) {
		new Teacher().showRole();
		new Student().showRole();
		new Employee().showRole();
	

	}

}
