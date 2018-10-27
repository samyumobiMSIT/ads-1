import java.util.Scanner;
/**
 * Class for student data.
 */
class Student implements Comparable<Student> {
    /**
     * declaration of variable.
     */
    private String name;
    /**
     * declaration of variable.
     */
    private double total;
    /**
     * declaration of variable.
     */
    private int rollno;
    /**
     * Constructs the object.
     *
     * @param      n   The namee
     * @param      t  The totall
     * @param      r The rollnoo
     */
    Student(final String n, final String t, final String r) {
        this.name  = n;
        this.total = Double.parseDouble(t);
        this.rollno = Integer.parseInt(r);
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
     * Gets the total.
     *
     * @return     The total.
     */
    public double getTotal() {
        return total;
    }
    /**
     * Gets the roll no.
     *
     * @return     The roll no.
     */
    public int getRollNo() {
        return rollno;
    }
    /**
     * compare To.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.total > that.total) {
            return 1;
        }
        if (this.total < that.total) {
            return -1;
        }
        // if (this.name.compareTo(that.name) > 0) {
        //     return 1;
        // }
        // if (this.name.compareTo(that.name) < 0) {
        //     return -1;
        // }
        if (this.rollno > that.rollno) {
            return 1;
        }
        if (this.rollno < that.rollno) {
            return -1;
        }
        return 0;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        RedBlackBST<Student, Integer> student = new RedBlackBST<>();
        Student s = null;
        while (input > 0) {
            String[] num = scan.nextLine().split(",");
            s = new Student(num[1], num[2], num[0]);
            student.put(s, Integer.parseInt(num[0]));
            input--;
        }
        int testcases = Integer.parseInt(scan.nextLine());
        while (testcases > 0) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("BE")) {
                //int key = Integer.parseInt(tokens[1]);
                double less = Double.parseDouble(tokens[1]);
                double greater = Double.parseDouble(tokens[2]);
                for (Student each : student.keys()) {
                    if (each.getTotal() >= less && each.getTotal() <= greater) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("LE")) {
                double value = Double.parseDouble(tokens[1]);
                for (Student each : student.keys()) {
                    if (each.getTotal() <= value) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("GE")) {
                double value = Double.parseDouble(tokens[1]);
                for (Student each : student.keys()) {
                    if (each.getTotal() >= value) {
                        System.out.println(each.getName());
                    }
                }
            }
            testcases--;
        }
    }
}