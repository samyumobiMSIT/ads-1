import java.util.Scanner;

/**
** Solution class.
**/
class Solution {
/**
** Main. 
** @param args String , Double
**/
public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
        int datalen = Integer.parseInt(scan.nextLine());
        RedBlackBST<Student, Integer> student = new RedBlackBST<>();
        Student s = null;
        while (datalen > 0) {
            String[] line = scan.nextLine().split(",");
            s = new Student(line[1], line[2], line[0]);
            student.put(s, Integer.parseInt(line[0]));

            datalen--;
        }

        int testcases = Integer.parseInt(scan.nextLine());
        while (testcases > 0) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("BE")) {
                //int key = Integer.parseInt(tokens[1]);
                double lower = Double.parseDouble(tokens[1]);
                double upper = Double.parseDouble(tokens[2]);
                //System.out.println("here");
                for (Student each : student.keys()) {
                    //System.out.println("hi");
                    //System.out.println(each);
                    if (each.getMarks() >= lower
                            && each.getMarks() <= upper) {
                        System.out.println(
                            each.getName());
                    }
                }
                //System.out.println("----");

            } else if (tokens[0].equals("LE")) {
                double limit = Double.parseDouble(tokens[1]);
                for (Student each : student.keys()) {
                    if (each.getMarks() <= limit) {
                        System.out.println(
                            each.getName());
                    }
                }
                //System.out.println("----");
            } else if (tokens[0].equals("GE")) {
                double limit = Double.parseDouble(tokens[1]);
                for (Student each : student.keys()) {
                    if (each.getMarks() >= limit) {
                        System.out.println(
                            each.getName());
                    }
                }
                //System.out.println("----");
            }

            testcases--;
        }

    }
}
/**
*** Student class.
**/
class Student implements Comparable<Student> {
/**
** roll no.
**/
    private int rollno;
   private String name;
   /** 
    * name.
    **/
   private double total;
    /** 
    * total.
    **/
    Student() {
    }
    Student(final String rollno1, final String sname, final String stotal) {
        this.rollno = Integer.parseInt(rollno1);
        this.name = sname;
        this.total = Double.parseDouble(stotal);
    }
    /**
     * compareTo function.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student other) {
        if (this.total > other.total) {
            return 1;
        }
        if (this.total < other.total) {
            return -1;
        }
        if (this.rollno > other.rollno) {
            return 1;
        }
        if (this.rollno < other.rollno) {
            return -1;
        }

        return 0;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public Double getMarks() {
        return total;
    }
    /**
     * Gets the roll.
     *
     * @return     The roll.
     */
    public Integer getRoll() {
        return rollno;
    }
}

