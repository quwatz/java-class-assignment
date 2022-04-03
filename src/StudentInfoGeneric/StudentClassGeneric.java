package StudentInfoGeneric;

public class StudentClassGeneric<T1,T2,T3,T4> {
	private T1 studentName;
	
	public void setStudentName(T1 name) {
		this.studentName = name;
	}
	public T1 getStudentName() {
		return this.studentName;
	}
	private T2 studentID;
	public void setStudentID(T2 ID) {
		this.studentID = ID;
	}
	public T2 getStudentID() {
		return this.studentID;
	}
	private T3 studentFatherName;
	public void setStudentFatherName(T3 fatherName) {
		this.studentFatherName = fatherName;
	}
	public T3 getStudentFatherName() {
		return this.studentFatherName;
	}
	private T4 studentGrades;
	
	public void setStudentGrades (T4 grades) {
		this.studentGrades = grades;
	}
	public T4 getStudentGrades () {
		return this.studentGrades;
	}
}
