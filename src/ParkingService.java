import objects.Car;
import parkinglot.Parking;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParkingService {
    private Parking parking;

    public ParkingService(int capacity) {
        this.parking = new Parking(capacity);
    }

    public void park(String color, String regNo) {
        Car car = new Car(regNo, color);

        int availableSlot = parking.getAvailableSlot();

        if (availableSlot != -1) {
            parking.occupySlot(availableSlot, car);
        }
    }

    public void leave(int spot) {
        parking.freeSlot(spot);
    }

    public void registrationNumbersForCarsWithColour(String color) {
        System.out.println(
            Arrays.stream(parking.getCars())
                .filter(e -> e.getColor().equals(color))
                .map(car -> car.getRegistrationNo())
                .collect(Collectors.joining( ", " ))
        );
    }

    public void slotNumbersForCarsWithColour(String color) {
        System.out.println(
            Arrays.stream(parking.getCars())
                .filter(e -> e.getColor().equals(color))
                .map(car -> String.valueOf(car.getSpot()))
                .collect(Collectors.joining( ", " ))
        );
    }

    public void slotNumberForRegistrationNumber(String regNo) {
        for (Car car : parking.getCars()) {
            if (car.getRegistrationNo().equals(regNo)) {
                System.out.println(car.getSpot());
                return;
            }
        }
    }
}
