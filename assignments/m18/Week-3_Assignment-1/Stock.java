class Stock implements Comparable<Stock> {
 String name;
 double val;
 Stock(String name, String val) {
     this.name = name;
     this.val = Double.parseDouble(val);
 }
 public int compareTo(Stock that) {
     if (this.val < that.val) {
     	return -1;
     }
     if (this.val > that.val) {
     	return 1;
     }
     if (this.name.compareTo(that.name) > 0) {
     	return 1;
     }
     if (this.name.compareTo(that.name) < 0) {
     	return -1;
     }
     return 0;
 }
}