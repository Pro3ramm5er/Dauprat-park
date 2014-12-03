package dpark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Room implements Iterable<String> {
    public String background = "";
    public List<String> objectsIDs = new ArrayList<String>();
    public String name = "";
    public int Max_pl_levels; //

    public Room(String name) {
        this.name = name;
    }

    @Override
    public Iterator<String> iterator() {
        return objectsIDs.listIterator();
    }

    public void update() {
    }
}
