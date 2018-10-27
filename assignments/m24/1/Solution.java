import java.util.Scanner;
/**
*** Student class.
**/
class Student {
/**
** roll no.
**/
    private String rollno;
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
     /**
     * 
     * @param      rollno1  The rollno
     * @param      name1    The name
     * @param      total1  The total
     */
    Student(final String rollno1, final String sname, final double stotal) {
        this.rollno = rollno1;
        this.name = sname;
        this.total = stotal;
    }
}
/**
** Solution class.
**/
class Solution {
/**
** Main. 
** @param args String , Double
**/
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

                
                break;
                case "2":
                System.out.println(lpht2.get(query[1]));
                
                break;
                default:
                break;
            }
        }
    }
}
