package workWithFinal;

public class ShoppingCart {

    private final Item[] items;
    private int count = 0;

    public ShoppingCart(int capacity) {
        this.items = new Item[capacity];
    }

    public void addItem(Item item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("No more space");
        }
    }

    public void printCart() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].getName());
        }
    }
}
