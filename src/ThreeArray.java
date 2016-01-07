import java.util.List;

/**
 * Created by andrcho on 1/7/2016.
 */
public class ThreeArray {
    int one = 0;
    int two = 0;
    int three = 0;
    int onesize = 0;
    int twosize = 0;
    int threesize = 0;
    int bound = 50;

    Integer[] arr = new Integer[bound];

    public ThreeArray() {

    }

    public void addOne(int num) {
        int size = size();
        if (size == 0) {
            arr[size] = num;
            one++;
        } else {

        }
    }

    public void addTwo(int num) {
        int size = size();
        if (size >= bound) {
           bound *= 2;
        }

        int sizetwo = onesize+twosize;
        int temp = arr[sizetwo];
        arr[sizetwo] = num;
        arr[size] = temp;
        twosize++;
    }

    private int size() {
        return onesize + twosize + threesize;
    }
}
