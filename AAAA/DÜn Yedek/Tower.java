import java.util.ArrayList;
import java.util.List;

import aircraft.Flyable;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        //TODO REGISTER MESAJI GÖNDERİLECEK
    }

    public void unregister(Flyable p_flyable) {
        System.out.println("UNREGİSTERS");
        System.out.println("before : " + observers.size());
        if (p_flyable == null) {
            System.out.println("p_flyable is null");
            return;
        }
        observers.remove(p_flyable);
        System.out.println("after : " + observers.size());
        //TODO  UNREGISTER MESAJI GÖNDERİLECEk
    }

    protected void conditionChanged()
    {
        List<Flyable> copy = new ArrayList<>(observers);
        for (Flyable fly : copy)
        {
            fly.updateConditions();
        }
    }
}