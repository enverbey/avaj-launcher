package src.main.java.simulation.weather;

import java.util.ArrayList;
import java.util.List;
import src.main.java.simulation.aircraft.Flyable;
import src.main.java.simulation.util.LogManager;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        LogManager.towerRegisterLog(
            p_flyable.getType(), 
            p_flyable.getName(),
            p_flyable.getID());
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        LogManager.towerUnregisterLog(
            p_flyable.getType(), 
            p_flyable.getName(),
            p_flyable.getID());

    }

    protected void conditionChanged() {
        List<Flyable> copy = new ArrayList<>(observers);
        for (Flyable flyable : copy) {
            flyable.updateConditions();
        }
    }
}