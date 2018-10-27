import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * rollnum.
     */
    private String rollno;
    /**
     * name.
     */
    private String name;
    /**
     * total marks.
     */
    private double total;
    /**
     * Constructs the object.
     */
    Student() {
    }
    /**
     * Constructs the object.
     *
     * @param      rollno1  The rollno
     * @param      name1    The name
     * @param      total1  The total
     */
    Student(final String rollno1, final String name1, final double total1) {
        rollno = rollno1;
        name = name1;
        total = total1;
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
     * Gets the rollno.
     *
     * @return   The rollno.
     */
    public String gerRoll() {
        return rollno;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public Double getmar() {
        return total;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        LinearProbingHashST<String, String> lpht1 = new LinearProbingHashST();
        LinearProbingHashST<String, Double> lpht2 = new LinearProbingHashST();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
             String str = sc.nextLine();
             String[] tokens = str.split(",");
             s = new Student(tokens[0], tokens[1],
                Double.parseDouble(tokens[2]));
             lpht1.put(tokens[0], tokens[1]);
             lpht2.put(tokens[0], Double.parseDouble(tokens[2]));
            }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String que = sc.nextLine();
            String[] query = que.split(" ");
            if (!lpht1.contains(query[1])) {
                System.out.println("Student doesn't exists...");
                continue;
            }
            switch (query[2]) {
                case "1":
                    System.out.println(lpht1.get(query[1]));

                //System.out.println(lpht1.get(query[1]));
                //lpht1.get(query[1]);
                break;
                case "2":
                System.out.println(lpht2.get(query[1]));
                //lpht2.get(query[2]);
                break;
                default:
                break;
            }
        }
    }
}