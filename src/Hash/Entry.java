package Hash;

/**
 * Created by Andrew Cho on 11/19/2015.
 */
public class Entry {
    private int key;
    private int value;
    private Entry next;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
