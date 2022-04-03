package ClassActivity;

public class PrivateStudentClass {
	private String name,surName,password,userName,job;
	//setters 
	void setName(String _name) {
		this.name = _name;
	}
	void setSurName(String _surName) {
		this.surName = _surName;
	}
	void setUserName(String _userName) {
		this.userName = _userName;
	}
	void setPassword(String _password) {
		this.password = _password;
	}
	void setJob(String _job) {
		this.job = _job;
	}
	//getters
	String getName() {
		return this.name;
	}
	String getSurName() {
		return this.surName;
	}
	String getUserName() {
		return this.userName;
	}
	String getPassword() {
		return this.password;
	}
	String getJob() {
		return this.job;
	}
	private int age;
	void setAge(int _age) {
		this.age =_age;
	}
	int getAge() {
		return age;
	}
}
