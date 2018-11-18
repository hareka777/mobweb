package hu.bme.aut.androidwallet.sqlite;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

public class SaladItem {
    private String name;
    private int price;
    private int pic;
    private int bought;
    public SaladItem(){

    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPic() {
        return pic;
    }

    public int getBought() {
        return bought;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }

    public void setName(String name) {
        this.name = name;
    }


}
