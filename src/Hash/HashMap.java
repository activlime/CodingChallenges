package Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Cho on 11/19/2015.
 */
public class HashMap {
    private int size;
    private Entry[] entries;

    public HashMap(int size) {
        this.size = size;
        entries = new Entry[size];
    }

    private int getHash(int key) {
        return key%size;
    }

    public void addEntry(int key, int value) {
        Entry newEntry = new Entry(key, value);
        int hash = getHash(key);
        Entry element = entries[hash];
        if (element != null) {
            while(element.getNext() != null) {
                element = element.getNext();
            }
            element.setNext(newEntry);
        }
        entries[hash] = newEntry;
        System.out.println("" + key + ": " + entries[hash].getValue());
    }

    public void deleteEntry() {

    }

    public int getValue(int key) {
        int hash = getHash(key);
        Entry temp = this.entries[hash];
        while(temp != null) {
            if (temp.getKey() == key) {
                return temp.getValue();
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }
}
