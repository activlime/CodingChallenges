package BreathFirst;

import java.util.ArrayList;

/**
 * Created by Andrew Cho on 11/10/2015.
 */
public class Node {
    private Node mParent;
    private ArrayList<Node> mChildren = new ArrayList<Node>();

    private int mValue;

    public Node (Node parent, ArrayList children, int value) {
        mValue = value;
    }

    public Node getmParent() {
        return mParent;
    }

    public void setmParent(Node mParent) {
        this.mParent = mParent;
    }

    public ArrayList<Node> getmChildren() {
        return mChildren;
    }

    public void setmChildren(ArrayList<Node> mChildren) {
        this.mChildren = mChildren;
    }

    public int getmValue() {
        return mValue;
    }

    public void setmValue(int mValue) {
        this.mValue = mValue;
    }
}
