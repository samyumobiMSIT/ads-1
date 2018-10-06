import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution{

	ArrayList<Student> students= new ArrayList<>();
	Scanner scan= new Scanner(System.in);
	int noLines= Integer.parseInt(scan.nextLine());
	int vacancies=Integer.parseInt(scan.nextLine());
	int unreserved= Integer.parseInt(scan.nextLine());
	int bc=Integer.parseInt(scan.nextLine());
	int st=Integer.parseInt(scan.nextLine());

	while(scan.hasNext()){
		String[] tokens=scan.nextLine().split(",");
		System.out.println(Arrays.toString(tokens));
		Student s=new Student(tokens[0],tokens[1],tokens[2],tokens[3],
			tokens[4],tokens[5],tokens[6]);
		students.add(s);
	}
}