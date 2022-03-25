package parkinglot;

import objects.Car;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Parking {
    private Slot [] slots;
    private Car [] cars;
    private Set<Integer> available;

    public Car [] getCars () {
        return this.cars;
    }

    public Parking (int capacity) {
        this.slots = new Slot[capacity];
        this.cars = new Car[capacity];
        this.available = new TreeSet<>();

        Arrays.fill(this.slots, new Slot(false));

        for (int i = 1; i <= capacity; i++) {
            this.available.add(i);
        }
    }

    public int getAvailableSlot() {
        if (!this.available.iterator().hasNext()) {
            return -1;
        }

        return this.available.iterator().next();
    }

    private boolean isSlotFree(int i) {
        return !this.slots[i-1].isTaken();
    }

    public boolean occupySlot(int i, Car car) {
        if (this.isSlotFree(i)) {
            this.slots[i - 1] = new Slot(true);
            this.cars[i - 1] = car;
            car.setSpot(i);
            this.available.remove(i);

            return true;
        }

        return false;
    }

    public boolean freeSlot(int i) {
        if (this.isSlotFree(i)) {
            return false;
        }

        this.slots[i - 1].setTaken(false);
        this.cars[i - 1] = null;
        this.available.add(i);

        return true;
    }
}
