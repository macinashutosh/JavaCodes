package codingNinjas24;

public class Student implements CompareInterface<Student> {
	public int rollNo;
	public Student(int rollNo){
		this.rollNo = rollNo;
	}
	@Override
	public int compare(Student second) {
		// TODO Auto-generated method stub
		if(this.rollNo == second.rollNo){
			return 0;
		}else if(this.rollNo>second.rollNo){
			return -1;
		}else{
			return 1;
		}
	}

}
