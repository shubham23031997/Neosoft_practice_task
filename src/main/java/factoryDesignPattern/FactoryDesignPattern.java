package factoryDesignPattern;



abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "wheel" + this.getWheel();
    }
}

class Bike extends Vehicle {
    int wheel;

    public Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        // TODO Auto-generated method stub
        return this.wheel;
    }

    public String toString() {
        return "bike : " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;

    public Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        // TODO Auto-generated method stub
        return this.wheel;
    }

    public String toString() {
        return "car : " + this.getWheel();
    }
}

class VehicleFactory {

    public static Vehicle getInstance(String type, int wheel) {

        if (type.equalsIgnoreCase("car")) {
            return new Car(wheel);
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike(wheel);
        }
        return null;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);
        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}
