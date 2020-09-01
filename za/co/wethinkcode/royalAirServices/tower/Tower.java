package za.co.wethinkcode.royalAirServices.tower;

import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> aircrafts = new ArrayList<>();

    public void register(Flyable flyable) {
        aircrafts.add(flyable);
    }
    public void unregister(Flyable flyable) {
        aircrafts.remove(aircrafts.indexOf(flyable));
    }
    protected void conditionsChanged() {
        for (int i = 0; i < aircrafts.size(); i++) {
            aircrafts.get(i).updateConditions();
        }
    }
}