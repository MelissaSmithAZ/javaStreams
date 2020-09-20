package beans;

public class CarDTO {
    private final double price;

    public CarDTO(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static CarDTO map(Car car){
        return new CarDTO(car.getPrice());
    }
}
