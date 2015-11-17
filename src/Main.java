import Search.Node;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by Andrew Cho on 10/11/2015.
 *
 * Linkedin interview
 */
public class Main {
    public static void main(String[] args) {
        checkConseqSum();
    }

    public static void readForPow() {
        Scanner in = new Scanner(System.in);
        int a = -1;
        int b = -1;


        System.out.println("Input base number: ");
        try {
            a = in.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(exception.toString());
        }

        System.out.println("Input exponent number': ");
        try {
            b = in.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(exception.toString());
        }

        double number = pow(a, Math.abs(b));
        if (b < 0) {
            number = 1/number;
        }

        System.out.println(number);
    }

    public static double pow(int a, int b) {
        if (a == 0 || a == 1) {
            if (b == 0) {
                return 1;
            } else {
                return a;
            }
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }

        return ((a * a) * pow(a, b - 2));
    }

    public static void wordDistance() {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> dict = new HashMap<String, Integer>();
        int position = 0;

        System.out.println("Input list of words, enter \"done\" when finished inputting:");
        while (in.hasNext()) {
            String temp = in.next();
            if (temp.equals("done")){
                break;
            }
            dict.put(temp, position);
            position++;
        }

        String wordOne;
        String wordTwo;

        System.out.print("Input two words to find distance, first word:");
        wordOne = in.next();
        while (dict.get(wordOne) == null) {
            System.out.print("Existing word not inputted, try again, first word:");
            wordOne = in.next();
        }

        System.out.print("Second word:");
        wordTwo = in.next();
        while (dict.get(wordTwo) == null) {
            System.out.print("Existing word not inputted, try again, second word:");
            wordTwo = in.next();
        }

        int distance = Math.abs(dict.get(wordOne) - dict.get(wordTwo));
        System.out.println("Distance of word " + wordOne + " and " + wordTwo +
        " is " + distance);
    }

    public static void checkTwoSum() {
        Map<Integer, Integer> numStore = new HashMap<Integer, Integer>();
        Map<Integer, Boolean> sumNumStore = new HashMap<Integer, Boolean>();

        Scanner in = new Scanner(System.in);
        System.out.println("Input Numbers:");
        int num = -1;

        try {
            num = in.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("need to input number");

        }
        while (num != -1) {
            twoSum(num, numStore, sumNumStore);
            try {
                num = in.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("need to input number");
                continue;
            }
        }

        do {
            System.out.println("Check sum:");
            try {
                num = in.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("need to input number");
                continue;
            }
            if (sumNumStore.containsKey(num)) {
                System.out.println("Two sum exists");
            } else {
                System.out.println("Two sum does not exist");
            }
        } while (num != -1);
    }

    public static void twoSum(int num, Map<Integer, Integer> numStore, Map<Integer, Boolean> sumNumStore) {
        if (!numStore.containsKey(num)) {
            numStore.put(num, 1);
        }

        Iterator it = numStore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int j = (int)pair.getKey();
            sumNumStore.put(num+j, true);
        }
    }

    public static void checkConseqSum() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input Numbers:");
        int num = -1;
        Boolean badinput = false;

        do {
            try {
                num = in.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("need to input number");
                badinput = true;
            }
        } while(badinput);

        Boolean conseqPossible = conseqNum((num));
        if (conseqPossible) {
            System.out.println(num + " is possible");
        } else {
            System.out.println(num + " is not possible");
        }
    }

    //finds if consecutive sum is possible
    //O(.5)
    public static Boolean conseqNum(int num) {
        if (num < 3) {
            return false;
        }
        if (num % 2 != 0) {
            return true;
        }

        for (int i = 3; i < num / 2; i++) {
            if (i % 2 == 0) {
                if (num / (double)i % .5 == 0) {
                    return true;
                }
            } else {
                if (num % i == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
