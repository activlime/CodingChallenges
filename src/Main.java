import org.apache.commons.lang.ObjectUtils;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Andrew Cho on 10/11/2015.
 *
 * Linkedin interview
 */
public class Main {
    public static void main(String[] args) {
        wordDistance();
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

        return (a * a) * pow(a, b - 2);

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
}
