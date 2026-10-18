public class Drink {

    private double price;
    private String name;

    public Drink(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setPrice(double newPrice){
        if (newPrice <= 0){
            throw new IllegalArgumentException("Pris kan ikke være 0 eller mindre....");
        }
        price = newPrice;
    }

    public double getPrice(){
        return price;
    }

}
