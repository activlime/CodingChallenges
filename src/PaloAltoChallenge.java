import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrew Cho on 10/11/2015.
 * Function to print out all numbers from 1 to <n>
 * who have exclusively prime factors (prime numbers should also be printed).
 *
 * runtime = BigO(n^1.5)
 */

public class PaloAltoChallenge {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

		/*
		 * declaring number entered, scanner, and array of booleans
		 * array of booleans to track if the array position number is prime
		 * example: array[n] = is n prime?
		 */
        int n;
        Scanner in = new Scanner(System.in);
        boolean[] array;

		/*
		 * user enters number
		 * if user enters a number less than 1, it prompts again
		 */
        System.out.print("Enter a number: ");
        n = in.nextInt();
        while(n < 1) {
            System.out.print("Try again, no negative numbers. Enter a number: ");
            n = in.nextInt();
        }


        //creating and initializing array
        array = new boolean[n+1];
        array[1] = true;

        //user function to print factors and set array values
        print("1 is allowed (prime)\n");
        for (int i = 2; i <= n; i++) {
            isAllowed(i, array);
        }
    }

    /*
     * sets array component if number input "n" is prime
     * prints factors of the number if possible
     * prints factors that are not prime if possible
     *
     * inputs:
     * >> integer n
     * >> array of booleans if numbers are prime
     */
    private static void isAllowed(int n, boolean[] array) {
        ArrayList<Integer> frontFactors = new ArrayList<Integer>();
        ArrayList<Integer> endFactors = new ArrayList<Integer>();
        List<Integer> newList;

        //prevalued boolean to allow in list
        boolean isAllowed = true;
        boolean isPrime = true;
        String str = n + " ";

        //checks the factors of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                //"n" has factor
                frontFactors.add(i);
                if (i != Math.sqrt(n)) {
                    //stores corresponding pair of values
                    endFactors.add(n / i);
                }

                //checks if factors are primes by looking at array to allow number in list
                if (!array[i] || !array[n/i]) {
                    isAllowed = false;
                }

                //not prime because function found factor for "n"
                isPrime = false;
            }
        }

        //sets the appropriate string depending on allowed in list or prime
        if (isAllowed) {
            str += "is allowed ";
            if (isPrime) {
                str += "(prime)";
            }
        } else {
            str += "is NOT allowed ";
        }

        //if not prime do this
        if (!isPrime) {
            //new array to combine front and back factors
            newList = new ArrayList<Integer>(frontFactors);

            //adding numbers backwards
            for (int i = endFactors.size() - 1; i >= 0 ; i--) {
                newList.add(endFactors.get(i));
            }

            //temp arraylist for factors that are not prime
            ArrayList<Integer> temp = new ArrayList<Integer>();

            //adds factors to string
            str += "(factors of 1,";
            for (int i = 0; i < newList.size(); i++) {
                str += newList.get(i) + ",";

                //if factor is not prime, add to templist
                if (!array[newList.get(i)]) {
                    temp.add(newList.get(i));
                }
            }
            str+= n + ")";

            //if not exclusively prime, add nonprime factors to string
            if (!isAllowed) {
                str += "(" + temp.get(0);
                for (int i = 1; i < temp.size(); i++) {
                    str += "," + temp.get(i);
                }
                if (temp.size() == 1) {
                    str += " is";
                } else {
                    str += " are";
                }
                str += " not prime)";
            }
        }

        //print string and set array value if prime or not to nth position
        print(str + "\n");
        array[n] = isPrime;
    }


    //utility function to print string
    private static void print(String s) {
        System.out.print(s);
    }
}
