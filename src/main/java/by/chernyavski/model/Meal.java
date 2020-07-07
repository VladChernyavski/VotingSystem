package by.chernyavski.model;

public class Meal extends AbstractBaseEntity{

    private String dishName;

    private Double price;

    public Meal(){

    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "dishName='" + dishName + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
