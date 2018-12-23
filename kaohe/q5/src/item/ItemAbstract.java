package item;

public abstract class ItemAbstract {
    String name;
    int price;
    ItemAbstract(String name,int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
