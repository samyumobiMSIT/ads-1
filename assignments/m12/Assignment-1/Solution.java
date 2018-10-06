import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    Solution() {
        //unused
    }

/**Main
Method **/
public static void main(String[] args) {
	Scanner s =  new Scanner(System.in);
    int num = Integer.parseInt(s.nextLine());
    Student[] students = new Student[num];
    int vac = Integer.parseInt(s.nextLine());
    int unres= Integer.parseInt(s.nextLine());
    int bcvac = Integer.parseInt(s.nextLine());
    int scvac = Integer.parseInt(s.nextLine());
    int stvac = Integer.parseInt(s.nextLine());
    for (int i = 0; i < num; i++) {
    	String line = s.nextLine();
    	String[] tokens = line.split(",");
    	Student eachstudentdata = new Student(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
            students[i] = eachstudentdata;
        }
        InsertionSort insertion = new InsertionSort();
        insertion.sort(students);
        print(students);
        System.out.println();
        FilterResults(students, vac, unres, bcvac, scvac, stvac);
    }

/** Filter Results by 
s3> s2> s1> younger 
parameters: Student class info details in form of list
vac- vacanises , unres- unreserved, categorys**/
	 public static void FilterResults(Student[] list, int vac, int unres, int bc, int sc, int st) {
        for (int i = 0; i < list.length && vac > 0; i++) {
            if (unres > 0) { 
            	/** check if there are any unreserved seats **/
                System.out.println(list[i].sname + "," +
                                   list[i].tmarks + "," +
                                   list[i].rescat);
                unres--;
            } else if (list[i].rescat.equals("BC") || list[i].rescat.equals("SC") || list[i].rescat.equals("ST")) {
                if (list[i].rescat.equals("BC") && bc > 0) { 
                // reserve seats for BC category
                    System.out.println(list[i].sname + "," +
                                       list[i].tmarks + "," +
                                       list[i].rescat);
                    bc--;
                } else if (list[i].rescat.equals("SC") && sc > 0) {
                	  // reserve seats for SC category
                    System.out.println(list[i].sname + "," +
                                       list[i].tmarks + "," +
                                       list[i].rescat);
                    sc--;
                } else if (list[i].rescat.equals("ST") && st > 0) {
                	  // reserve seats for St category
                    System.out.println(list[i].sname + "," +
                                       list[i].tmarks + "," +
                                       list[i].rescat);
                    st--;
                } else {
                }
            }
        }
        vac--;
    }
/** Print the Student List by iterating through
 the student list array defined in Student.java **/
	 public static void print(Student[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].sname + "," +
                               list[i].tmarks + "," +
                               list[i].rescat);
        }
    }
}
    





