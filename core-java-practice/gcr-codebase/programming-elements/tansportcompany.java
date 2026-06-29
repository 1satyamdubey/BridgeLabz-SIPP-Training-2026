abstract class Vehicle {
    public abstract double fuelCost(double km);
}

class Car extends Vehicle {
    private static final double RATE_PER_KM = 10.0;

    @Override
    public double fuelCost(double km) {
        return RATE_PER_KM * km;
    }
}

class Bus extends Vehicle {
    private static final double RATE_PER_KM = 7.5;

    @Override
    public double fuelCost(double km) {
        return RATE_PER_KM * km;
    }
}

class Bike extends Vehicle {
    private static final double RATE_PER_KM = 3.0;

    @Override
    public double fuelCost(double km) {
        return RATE_PER_KM * km;
    }
}

class ElectricCar extends Vehicle {
    private static final double ELECTRIC_RATE_PER_KM = 4.0;

    @Override
    public double fuelCost(double km) {
        return ELECTRIC_RATE_PER_KM * km;
    }
}

public class tansportcompany {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car(),
            new Bus(),
            new Bike(),
            new ElectricCar() // added without changing fleet-processing logic
        };

        double distance = 100.0;
        System.out.println("Transport company fleet fuel costs for " + distance + " km:");

        for (Vehicle vehicle : fleet) {
            double cost = vehicle.fuelCost(distance);
            System.out.println(vehicle.getClass().getSimpleName() + " cost: " + cost);
        }

        // Example of instanceof before casting (safe downcast)
        Vehicle firstVehicle = fleet[0];
        if (firstVehicle instanceof Car) {
            Car car = (Car) firstVehicle;
            System.out.println("Verified instance of Car, cost for 50 km: " + car.fuelCost(50));
        }
    }
}
