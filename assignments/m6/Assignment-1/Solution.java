
import java.util.Scanner;

import java.util.Iterator;



class AddLargeNumbers {

    

    public static LinkedList numberToDigits(String number) {

        LinkedList<Integer> ll = new LinkedList<Integer>();

        for (int i = 0; i < number.length(); i++) {

            ll.insert(Integer.parseInt(number.charAt(i) + ""));

        }

        return ll;

    }



    public static String digitsToNumber(LinkedList<String> list) {

        return list.toString();

    }



    public static Stack<Integer> createStack(LinkedList<String> lst) {

        Stack<Integer> stack = new Stack<Integer>();

        Iterator<String> iter = lst.iterator();

        while(iter.hasNext()) {

            try {

                stack.push(Integer.parseInt(iter.next()));

            } catch (Exception ex) {

                System.out.println(ex.getMessage());

            }

        }

        return stack;

    }



    public static LinkedList addLargeNumbers(LinkedList<String> list1, LinkedList<String> list2) {

        Stack<Integer> aStack = createStack(list1);

        Stack<Integer> bStack = createStack(list2);

        LinkedList<String> result = new LinkedList();

        int flag = 0;

        while (! (aStack.isEmpty() && bStack.isEmpty())) {

            int sum = aStack.pop() + bStack.pop() + flag;

            if (sum >= 10) {

                flag = 1;

                sum = sum - 10;

            }

            result.insert(sum + "");

        }

        if (flag == 1)

            result.insert(flag + "");

        return result;

    }

}



public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String p = sc.nextLine();

        String q = sc.nextLine();

        switch(input){

            case "numberToDigits":

                LinkedList<String> pDigits = AddLargeNumbers.numberToDigits(p);

                LinkedList<String> qDigits = AddLargeNumbers.numberToDigits(q);

                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));

                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));

                break;



            case "addLargeNumbers":

                pDigits = AddLargeNumbers.numberToDigits(p);

                qDigits = AddLargeNumbers.numberToDigits(q);

                LinkedList<String> result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);

                System.out.println(AddLargeNumbers.digitsToNumber(result));

                break;

        }

    }

    

}

