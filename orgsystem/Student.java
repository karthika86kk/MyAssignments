package orgsystem;

public class Student extends Department{
	public void studentName(String name)
	{
		System.out.println("Student Name : "+name);
	}
	
	public void studentDept(String dept)
	{
		System.out.println("Student Departmrnt : "+dept);
	}
	
	public void studentid(int id)
	{
		System.out.println("Student ID : "+id);
	}

	public static void main(String[] args) {
		
		Student stu = new Student();
		
		stu.collegeName("Annamalai University");
		stu.collegeCode(56789);
		stu.collegeRank(10);
		stu.deptName("Electronic And Electrical Engineering");
		stu.studentName("Suresh");
		stu.studentDept("EEE");
		stu.studentid(1223456);

	}

}
