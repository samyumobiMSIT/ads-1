import java.util.Scanner;
/**
*** Student class.
**/
class Student {
/**
** roll no.
**/
    private String rno;
   private String sname;
   /** 
    * name.
    **/
   private double stotal;
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
    Student(final String rollno1, final String sname1, final double stotal1) {
        this.rno = rollno1;
        this.sname = sname1;
        this.stotal = stotal1;
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
        LinearProbingHashST<String, String> lp1 = new LinearProbingHashST();
        LinearProbingHashST<String, Double> lp2 = new LinearProbingHashST();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
             String str = sc.nextLine();
             String[] tokens = str.split(",");
             s = new Student(tokens[0], tokens[1],
                Double.parseDouble(tokens[2]));
             lp1.put(tokens[0], tokens[1]);
             lp2.put(tokens[0], Double.parseDouble(tokens[2]));
            }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String que = sc.nextLine();
            String[] query = que.split(" ");
            if (!lp1.contains(query[1])) {
                System.out.println("Student doesn't exists...");
                continue;
            }
            switch (query[2]) {
                case "1":
                    System.out.println(lp1.get(query[1]));

                
                break;
                case "2":
                System.out.println(lp2.get(query[1]));
                
                break;
                default:
                break;
            }
        }
    }
}
