import java.util.List;

/**
 * Created by andrcho on 1/7/2016.
 *
 * Keeps three arrays in one array
 *
 * O(1)
 */
public class ThreeArray {
    int onesize = 0;
    int twosize = 0;
    int threesize = 0;
    int bound = 50;

    Integer[] arr = new Integer[bound];

    public ThreeArray() {
        presetArray();
        addTwo(2);
        printArray();
    }

    private void presetArray() {
        for (int i = 0; i < bound; i++) {
            arr[i] = 0;
        }
    }

    public void addOne(int num) {
        int size = size();
        if (size >= bound) {
            doubleArray();
        }

        arr[size] = arr[onesize];

        int twototal = onesize + twosize;
        arr[twototal] = arr[size];
        arr[onesize] = num;

        onesize++;
    }

    public void addTwo(int num) {
        int size = size();
        if (size >= bound) {
            doubleArray();
        }

        int twototal = onesize+twosize;
        int temp = arr[twototal];
        arr[twototal] = num;
        arr[size] = temp;
        twosize++;
    }

    public void addThree(int num) {
        int size = size();
        if (size >= bound) {
            doubleArray();
        }

        arr[size] = num;
        threesize++;
    }

    private void doubleArray() {
        Integer[] newArray = new Integer[bound*2];
        for (int i = 0; i < bound; i++) {
            newArray[i] = arr[i];
        }

        arr = newArray;

        bound *= 2;
    }

    private int size() {
        return onesize + twosize + threesize;
    }

    public void printArray() {
        for (int i = 0; i < size(); i++) {
            System.out.println(arr[i]);
        }
    }
}
