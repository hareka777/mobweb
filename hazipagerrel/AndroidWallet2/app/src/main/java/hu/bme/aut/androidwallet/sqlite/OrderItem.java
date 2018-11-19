package hu.bme.aut.androidwallet.sqlite;


import java.util.HashMap;
import java.util.Map;

public class OrderItem {
    Map<SaladItem, Integer> order;
    public OrderItem(){
        order=new HashMap<SaladItem, Integer>();
    }
    public void Add(SaladItem salad, int quantity){
        if(order.containsKey(salad)){
            order.remove(salad);

        }
        if(quantity!=0){
            order.put(salad, quantity);
        }

    }
    public Map<SaladItem, Integer> getOrder(){
        return order;
    }
}
