package Search;

/**
 * Created by Andrew Cho on 11/11/2015.
 */
public class Depth {
    public Boolean search(Node head, int value) {
        Node start = head;
        start.setCovered(true);
        for (int i = 0; i < head.getmChildren().size(); i++) {
            if (start.getCovered()) {
                if (search(start.getmChildren().get(i), value)) {
                    return true;
                }
            }
        }

        return start.getmValue() == value;
    }
}
