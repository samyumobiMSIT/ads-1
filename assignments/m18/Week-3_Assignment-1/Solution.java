import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
  /**
   * Class variable for company name.
   */
  private String company;
  /**
   * Class variable for change in stock by hour.
   */
  private double change;

  /**
   * Constructs the object.
   *
   * @param      cmp   The company
   * @param      chg   The change
   */
  Stock(final String cmp, final double chg) {
    this.company = cmp;
    this.change = chg;
  }

  /**
   * Gets the company.
   *
   * @return     The company.
   */
  public String getComp() {
    return company;
  }

  /**
   * Gets the change.
   *
   * @return     The change.
   */
  public double getChange() {
    return change;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return company + " " + change;
  }

  /**
   * Compares two stocks.
   *
   * @param      that  The that
   *
   * @return     Integer value to compare.
   */
  public int compareTo(final Stock that) {
    if (this.change > that.getChange()) {
      return 1;
    }
    if (this.change < that.getChange()) {
      return -1;
    }
    if (this.company.compareTo(that.getComp()) > 0) {
      return 1;
    }
    if (this.company.compareTo(that.getComp()) < 0) {
      return -1;
    } else {
      return 0;
    }
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
    // unused
  }

  /**
   * Second part of the problem.
   *
   * @param      inp     The inp
   * @param      maxST   The maximum st
   * @param      minST   The minimum st
   * @param      stocks  The stocks
   */
  /** 
  * O/p Stocks that are both best and worst performers.
  * O/p Stocks that are not in bottom5 of minSt/maxSt atleast once.
  */
  public static void secOut(final String[] inp,
                            final BinaryST<String, Integer> maxST,
                            final BinaryST<String, Integer> minST,
                            final ArrayList<String> stocks) {
    /** function call from secOut(input, maxST, minST, stocks);
    **/
    switch (inp[0]) {
    case "get":
        if (inp[1].equals("minST")) {
        if (minST.contains(inp[2])) {
          /** get value of input from minST.
          ** check if value is in minST (WP BSST)
          ** prints wp if inp is not in bottom positions
          **/
          System.out.println(minST.get(inp[2]));
        } else {
          System.out.println(0);
        }
        break;
      } else if (inp[1].equals("maxST")) {
        if (maxST.contains(inp[2])) {
          //get value of input in maxST
          System.out.println(maxST.get(inp[2]));
        } else {
          System.out.println(0);
        }
        break;
      }
    case "intersection":
    /**calls MinPQ to ckeck if stock has appeared atleast once.
    ** tem gets stock value
    ** check if value is in min , max
    ** performs minPQ on values and inserts in minpq
    **/
      MinPQ<String> out = new MinPQ<String>();
      for (int i = 0; i < stocks.size(); i++) {
        String tem = stocks.get(i);
        if (minST.contains(tem) && maxST.contains(tem)) {
          out.insert(tem);
        }
      }
      /** minPQ is not empty
      ** delMin() element 
      ** performs comp, exch, sink, resize
      **/
      while (!out.isEmpty()) {
        System.out.println(out.delMin());
      }
      break;
    default:
      break;
    }


  }
  /**
   * Main method - Takes Inputs, prints out Outputs.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);

    /** Creating two AL's to store bp,wp.
    **/
    int stockSize = Integer.parseInt(scan.nextLine());
    ArrayList<String> stocks = new ArrayList<String>();
    ArrayList<Stock> bestPerformers = new ArrayList<Stock>();
    ArrayList<Stock> worstPerformers = new ArrayList<Stock>();

    /** Building minPQ,maxPQ for every hour using ArrayList
    **/

    // hour 1
    MinPQ<Stock> hr1Min = new MinPQ<Stock>();
    MaxPQ<Stock> hr1Max = new MaxPQ<Stock>();

    //iterating through ArrayList(stock) to max,min elements using temp as pointer
    for (int i = 0; i < stockSize; i++) {
      //input parameter to read inputs to store in min and max stocks
      String[] inputs = scan.nextLine().split(",");
      Stock temp = new Stock(inputs[0],
                             Double.parseDouble(inputs[1]));
      hr1Max.insert(temp);
      hr1Min.insert(temp);
      /**if stock have same change, to display preference.
      ** in decreasing order of company.
      **/
      if (!stocks.contains(temp.getComp())) {
        stocks.add(temp.getComp());
      }
    }
    /** print top 5 best and worst performers.
    **for wach hour.
    **/
    hr1Max.print5(bestPerformers);
    hr1Min.print5(worstPerformers);


    // hour 2
    MinPQ<Stock> hr2Min = new MinPQ<Stock>();
    MaxPQ<Stock> hr2Max = new MaxPQ<Stock>();

    for (int i = 0; i < stockSize; i++) {
      String[] inputs = scan.nextLine().split(",");
      Stock temp = new Stock(inputs[0],
                             Double.parseDouble(inputs[1]));
      hr2Max.insert(temp);
      hr2Min.insert(temp);
    }

    hr2Max.print5(bestPerformers);
    hr2Min.print5(worstPerformers);

    // hour 3
    MinPQ<Stock> hr3Min = new MinPQ<Stock>();
    MaxPQ<Stock> hr3Max = new MaxPQ<Stock>();

    for (int i = 0; i < stockSize; i++) {
      String[] inputs = scan.nextLine().split(",");
      Stock temp = new Stock(inputs[0],
                             Double.parseDouble(inputs[1]));
      hr3Max.insert(temp);
      hr3Min.insert(temp);
    }

    hr3Max.print5(bestPerformers);
    hr3Min.print5(worstPerformers);

    // hour 4
    MinPQ<Stock> hr4Min = new MinPQ<Stock>();
    MaxPQ<Stock> hr4Max = new MaxPQ<Stock>();

    for (int i = 0; i < stockSize; i++) {
      String[] inputs = scan.nextLine().split(",");
      Stock temp = new Stock(inputs[0],
                             Double.parseDouble(inputs[1]));
      hr4Max.insert(temp);
      hr4Min.insert(temp);
    }

    hr4Max.print5(bestPerformers);
    hr4Min.print5(worstPerformers);

    // hour 5
    MinPQ<Stock> hr5Min = new MinPQ<Stock>();
    MaxPQ<Stock> hr5Max = new MaxPQ<Stock>();

    for (int i = 0; i < stockSize; i++) {
      String[] inputs = scan.nextLine().split(",");
      Stock temp = new Stock(inputs[0],
                             Double.parseDouble(inputs[1]));
      hr5Max.insert(temp);
      hr5Min.insert(temp);
    }

    hr5Max.print5(bestPerformers);
    hr5Min.print5(worstPerformers);

    // hour 6
    MinPQ<Stock> hr6Min = new MinPQ<Stock>();
    MaxPQ<Stock> hr6Max = new MaxPQ<Stock>();

    for (int i = 0; i < stockSize; i++) {
      String[] inputs = scan.nextLine().split(",");
      Stock temp = new Stock(inputs[0],
                             Double.parseDouble(inputs[1]));
      hr6Max.insert(temp);
      hr6Min.insert(temp);
    }

    hr6Max.print5(bestPerformers);
    hr6Min.print5(worstPerformers);

    /**Creating two ArrayList to get the bp, wp .
    ** and their company names.
    ** frequency: how many times appeared 
    **/
    ArrayList<String> bestP = new ArrayList<String>();
    ArrayList<String> worstP = new ArrayList<String>();

    for (int i = 0; i < bestPerformers.size(); i++) {
      bestP.add(bestPerformers.get(i).getComp());
    }

    for (int i = 0; i < worstPerformers.size(); i++) {
      worstP.add(worstPerformers.get(i).getComp());
    }

    /** BSST stores k- Stock name,v-bestP,worstP .
    **
    **/
    BinaryST<String, Integer> maxST = new BinaryST<String, Integer>();
    BinaryST<String, Integer> minST = new BinaryST<String, Integer>();

    /** iterate thru bestP. wP
    ** temp to get bestP. wP
    ** if maxST contains value, store value in BSST maxST.
    ** if minST contains value,store value in BSST minST.
    **/
    for (int i = 0; i < bestP.size(); i++) {
      String temp = bestP.get(i);
      if (!maxST.contains(temp)) {
        maxST.put(temp, 1);
      } else {
        maxST.put(temp, maxST.get(temp) + 1);
      }
    }

    for (int i = 0; i < worstP.size(); i++) {
      String temp = worstP.get(i);
      if (!minST.contains(temp)) {
        minST.put(temp, 1);
      } else {
        minST.put(temp, minST.get(temp) + 1);
      }
    }
    int numInp = Integer.parseInt(scan.nextLine());

    for (int j = 0; j < numInp; j++) {
      String[] input = scan.nextLine().split(",");
      secOut(input, maxST, minST, stocks);
    }
  }
}