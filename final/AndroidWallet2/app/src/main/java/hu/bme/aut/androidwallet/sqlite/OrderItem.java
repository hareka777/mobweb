package hu.bme.aut.androidwallet.sqlite;


import java.util.HashMap;
import java.util.List;
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
    public Map<String, Integer> getOrderSimple(List<SaladItem> mylist){
        Map<String, Integer> myHash=new HashMap<String, Integer>();
        for(int i=0;i<mylist.size();i++){
            if(order.containsKey(mylist.get(i))){
                myHash.put(mylist.get(i).getName(), order.get(mylist.get(i)));
            }

        }
        return myHash;
    }
}
