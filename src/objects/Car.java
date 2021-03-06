package objects;

public class Car {
    private String registrationNo;
    private String color;
    private int spot;

    public Car(String registrationNo, String color) {
        this.registrationNo = registrationNo;
        this.color = color;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }
}
