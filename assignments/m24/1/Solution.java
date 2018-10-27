import java.util.*;
class Student {
    /**
    * params: 
    * rollno,name, total
    */
    String rollno;
   private String name;
   private double total;
    Student() {
    }
    Student(final String rollno, final String name, final double total) {
        this.rollno = rollno;
        this.name = name;
        this.total = total;
    }
}
/**
** Solution class.
**/
class Solution {
    /**
    ** Main. 
    **/
    public static void main(String[] args) {
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