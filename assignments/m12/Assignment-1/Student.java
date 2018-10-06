public class Student {

	public Student() {
	 String name,rc;
	 int vacancies;
	 int unreserved;
	 int BC;
	 int SC ;
	 int ST;
	 int m1,m2,m3,tmarks;
	 int day,month,year;

	 Student(String name,String dob,String m1,
	 	String m2,String m3,String tm,String rc){
	 	String[] d= dob.split("-");
	 	this.day=Integer.parseInt(d[0]);
	 	this.month=Integer.parseInt(d[1]);
	 	this.year=Integer.parseInt(d[2]);
	 	this.m1=Integer.parseInt(m1);
	 	this.m2=Integer.parseInt(m2);
	 	this.m3=Integer.parseInt(m3);
	 	this.tmarks=Integer.parseInt(tmarks);
	 	this.rc=rc;


	 }
		
		
	}

}
