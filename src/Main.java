import Search.Node;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;

/**
 * Created by Andrew Cho on 10/11/2015.
 *
 * Linkedin interview
 */
public class Main {
    public static void main(String[] args) {
        HashMapTest();
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

    /*
     * Looks through array and flips only positive numbers
     * O(1)
     */
    public static void swapPositive(int[] array) {
        int position = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                if (position - i > 1) {
                    int size = i-position;
                    for (int j = i; j < size/2; j++) {
                        int temp = array[j];
                        array[j] = array[size-j];
                        array[size-j] = temp;
                    }
                }

                position = i;
            }
        }
    }

    public static void HashMapTest() {
        Hash.HashMap hashmap = new Hash.HashMap(100);
        hashmap = addHashElements(hashmap);
        getHashElements(hashmap);
    }

    public static Hash.HashMap addHashElements(Hash.HashMap hashmap) {
        Scanner in = new Scanner(System.in);
        int key = -1;
        int value = -1;
        Boolean badinput = false;

        do {
            System.out.print("Enter num key for element: ");
            try {
                key = in.nextInt();
                badinput = false;
            } catch (InputMismatchException exception) {
                System.out.println("/nneed to input number");
                badinput = true;
                continue;
            }

            if (key != -1) {
                do {
                    System.out.print("Enter int value for element: ");
                    try {
                        value = in.nextInt();
                        badinput = false;
                    } catch (InputMismatchException exception) {
                        System.out.println("need to input number");
                        badinput = true;
                    }
                } while (badinput);
            } else if (key == -1) {
                continue;
            }

            hashmap.addEntry(key, value);
        } while(badinput || key != -1);

        return hashmap;
    }

    public static void getHashElements(Hash.HashMap hashmap) {
        Scanner in = new Scanner(System.in);
        int key = -1;
        Boolean badinput = false;

        do {
            System.out.print("Enter num key for element to get: ");
            try {
                key = in.nextInt();
                badinput = false;
            } catch (InputMismatchException exception) {
                System.out.println("need to input number");
                badinput = true;
                continue;
            }
            System.out.println("hit if statement");
            System.out.println("bad input " + badinput);
            if (key != -1) {
                System.out.println("in non exit key");
                int value = hashmap.getValue(key);
                if (value != -1) {
                    System.out.println("The key " + key + " has value " + value);
                } else {
                    System.out.println("The key is not found");
                }
            }
            System.out.println("end of do while");
        } while(badinput || key != -1);
    }

    /*
    *create union and intersection
    *
     */
    public static void unionIntersection(List<Integer> A, List<Integer> B) {
        List<Integer> union = new ArrayList<Integer>();
        List<Integer> intersection = new ArrayList<Integer>();

        int indexA = 0;
        int indexB = 0;
        int size = A.size() + B.size();

        while(indexA != A.size() - 1 && indexB != B.size() - 1) {
            if (indexA - 1 == A.size()) {
                union.add(B.get(indexB));
                indexB++;
            } else if (indexB - 1 == B.size()) {
                union.add(A.get(indexA));
                indexA++;
            }

            if (A.get(indexA) < B.get(indexB)) {
                union.add(A.get(indexA));
                indexA++;
            } else if (A.get(indexA) > B.get(indexB)) {
                union.add(B.get(indexB));
                indexB++;
            } else {
                intersection.add(A.get(indexA));
                indexA++;
                indexB++;
            }
        }
    }

    /**
     * count how many flowers you can add to the garden
     * 
     * @param flowerbed
     * @param numberToPlace
     * @return
     */
    public static boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
        int count = 0;
        int flowers = 0;
        for (int i = 0; i < flowerbed.size(); i++) {
            if (!flowerbed.get(i)) {
                count++;
            } else {
                if (count > 1) {
                    if (count % 2 == 1) {
                        flowers += count /2;
                    }
                }
                count = 0;
            }
        }
        if (count == 2) {
            flowers++;
        }
        if (flowers >= numberToPlace) {
            return true;
        } else {
            return false;
        }
    }

}
