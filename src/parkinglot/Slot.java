package parkinglot;

public class Slot {

    private boolean isTaken;

    public Slot(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
