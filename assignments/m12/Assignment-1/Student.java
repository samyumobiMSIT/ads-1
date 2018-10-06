/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    String name;
    int m1;
    int m2;
    int m3;
    int total;
    String rescat;
    int day;
    int month;
    int year;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      dob     The dob
     * @param      m1      The m 1
     * @param      m2      The m 2
     * @param      m3      The m 3
     * @param      total   The total
     * @param      rescat  The rescat
     */
    Student(String sname, String dob, String mark1, String mark2, String mark3, String totals, String res) {
        this.name = sname;
        String[] d = dob.split("-");
        this.day = Integer.parseInt(d[0]);
        this.month = Integer.parseInt(d[1]);
        this.year = Integer.parseInt(d[2]);
        this.m1 = Integer.parseInt(mark1);
        this.m2 = Integer.parseInt(mark2);
        this.m3 = Integer.parseInt(mark3);
        this.total = Integer.parseInt(totals);
        this.rescat = res;

    }
    public int compareTo(final Student other) {
        if (this.total > other.total) {
            return 1;
        }
        if (this.total < other.total) {
             return -1;
        }
        if (this.m3 > other.m3) {
            return 1;
        }
        if (this.m3 < other.m3) {
            return -1;
        }
        if (this.m2 > other.m2) {
            return 1;
        }
        if (this.m2 < other.m2) {
            return -1;
        }
        if (this.year > other.year) {
            return 1;
        }
        if (this.year < other.year) {
            return -1;
        }
        if (this.month > other.month) {
            return 1;
        }
        if (this.month < other.month) {
            return -1;
        }
        if (this.day < other.day) {
            return 1;
        }
        if (this.day > other.day) {
            return -1;
        }
        return 0;
    }
    public int compare(final Student other) {
        if((this.rescat.equals("SC") || this.rescat.equals("ST")
            || this.rescat.equals("BC") && other.rescat.equals("Open"))) {
            return 1;
        }
        if((other.rescat.equals("SC")
            || other.rescat.equals("ST") || other.rescat.equals("BC")
            && this.rescat.equals("Open"))) {
            return -1;
        }
        return 0;
    }
}