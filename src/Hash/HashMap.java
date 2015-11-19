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
        size = size;
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
    }

    public void deleteEntry() {

    }

    public int getValue(int key) {

        return -1;
    }
}
