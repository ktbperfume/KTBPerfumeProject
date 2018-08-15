package entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MyPC
 */
public class Cart {

    private HashMap<String, Item> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<String, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<String, Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<String, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public void insertToCart(String key, Item item) {
        boolean bln = cartItems.containsKey(key);
        if (bln) {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartItems.put(item.getProduct().getProductId(), item);
        } else {
            cartItems.put(item.getProduct().getProductId(), item);
        }
    }
    
    public void subToCart(String key, Item item) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            if (quantity_old <= 1) {
                cartItems.remove(key);
            } else {
                item.setQuantity(quantity_old - 1);
                cartItems.put(key, item);
            }
        }
    }
    
    public void removeToCart(String key) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            cartItems.remove(key);
        }
    }
    
    public int countItem() {
        return cartItems.size();
    }
    
    public double subTotalCart() {
        double count = 0;
        // count = price * quantity
        for (Map.Entry<String, Item> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        return count;
    }
    
    public double GrandTotalCart() {
        double count = 0;
        // count = price * quantity
        for (Map.Entry<String, Item> list : cartItems.entrySet()) {
            double sub = list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
            count += sub + sub*0.1;
        }
        return count;
    }
    
    

}
