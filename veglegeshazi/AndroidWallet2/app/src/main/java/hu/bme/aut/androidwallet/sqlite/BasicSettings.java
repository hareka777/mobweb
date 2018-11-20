package hu.bme.aut.androidwallet.sqlite;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.androidwallet.R;

public class BasicSettings {
    List<SaladItem> saladlist;
    public BasicSettings(){
        saladlist=new ArrayList<>();
    }
    public List<SaladItem> getData(){
        InitData();
        return saladlist;
    }
    private void  InitData(){
        SaladItem salad=new SaladItem();
        salad.setName("American Macaroni Salad");
        salad.setPic(R.drawable.american_macaroni_salad);
        salad.setPrice(20);
        salad.setBought(164);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Beef Salad");
        salad.setPic(R.drawable.beef_salad_with_chicory_pear_and_parmigiano_reggiano);
        salad.setPrice(35);
        salad.setBought(24);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Bean And Aspargus Salad");
        salad.setPic(R.drawable.black_bean_asparagus_and_jicama_salad);
        salad.setPrice(42);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Caprese Salad");
        salad.setPic(R.drawable.caprese_salad);
        salad.setPrice(18);
        salad.setBought(42);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Chinese Checken Salad");
        salad.setPic(R.drawable.chinese_chicken_salad);
        salad.setPrice(32);
        salad.setBought(174);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Italian Salad");
        salad.setPic(R.drawable.italian_lentil_salad);
        salad.setPrice(26);
        salad.setBought(38);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Nicoise Salad");
        salad.setPic(R.drawable.nicoise_salad);
        salad.setPrice(24);
        salad.setBought(95);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Panzanella");
        salad.setPic(R.drawable.panzanella);
        salad.setPrice(29);
        salad.setBought(102);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Pomegranate Salad");
        salad.setPic(R.drawable.parmigiano_reggiano_pomegranate_and_wild_rocket_salad);
        salad.setPrice(32);
        salad.setBought(45);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Tuna Salad");
        salad.setPic(R.drawable.peppered_tuna_with_nicoise_salad);
        salad.setPrice(37);
        salad.setBought(199);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Potato Salad");
        salad.setPic(R.drawable.red_white_and_blue_potato_salad);
        salad.setPrice(25);
        salad.setBought(25);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Blueberry and Coleslaw Salad");
        salad.setPic(R.drawable.red_white_and_blueberry_coleslaw);
        salad.setPrice(30);
        salad.setBought(22);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("ChicoryWine Vinaigrette Salad");
        salad.setPic(R.drawable.rocket_chicory_salad_with_white_wine_vinaigrette);
        salad.setPrice(32);
        salad.setBought(29);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("The Lady's Warm Potato Salad");
        salad.setPic(R.drawable.the_lady_s_warm_potato_salad);
        salad.setPrice(31);
        salad.setBought(197);
        saladlist.add(salad);
        salad=new SaladItem();
        salad.setName("Vietnamese Chicken Salad");
        salad.setPic(R.drawable.vietnamese_chicken_salad_1);
        salad.setPrice(39);
        salad.setBought(177);
        saladlist.add(salad);

    }




}
