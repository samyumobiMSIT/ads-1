/** Student 
Class to take inputs in given test case format**/
class Student implements Comparable<Student> {
    String sname;
    String bday;
    int sm1;
    int sm2;
    int sm3;
    int tmarks;
    String rescat;
    /** Student Method 
    to display student details**/
    Student(String name, String dob, int sub1, int sub2, int sub3, int total, String category) {
        this.sname = name;
        this.bday = dob;
        this.sm1 = sub1;
        this.sm2 = sub2;
        this.sm3 = sub3;
        this.tmarks = total;
        this.rescat = category;
    }
    /** Split date time and month 
    in date with '-'
    **/
    String[] splitDate() {
        String[] splitdate = bday.split("-");
        return splitdate;
    }
    /**Student class uses other object 
    to compare every parameter**/
    public int compareTo(Student other) {
        if (this.tmarks > other.tmarks) {
            return 1;
        }
        if (this.tmarks < other.tmarks) {
            return -1;
        }
        if (this.sm3 > other.sm3) {
            return 1;
        }
        if (this.sm3 < other.sm3) {
            return -1;
        }
        if (this.sm2 > other.sm2) {
            return 1;
        }
        if (this.sm2 < other.sm2) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[2]) > Integer.parseInt(other.splitDate()[2])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[2]) < Integer.parseInt(other.splitDate()[2])) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[1]) > Integer.parseInt(other.splitDate()[1])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[1]) < Integer.parseInt(other.splitDate()[1])) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[0]) > Integer.parseInt(other.splitDate()[0])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[0]) < Integer.parseInt(other.splitDate()[0])) {
            return -1;
        }
        return 0;
    }

}