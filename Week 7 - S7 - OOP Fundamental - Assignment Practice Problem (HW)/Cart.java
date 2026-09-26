class Cart {
    private final String cartId;
    private double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length && price >= 0) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}

public class ShoppingCartTest {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());       // 500.0
        System.out.println("Item Count: " + cart.getItemCount()); // 3
    }
}