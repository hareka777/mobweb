package hu.bme.aut.androidwallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import hu.bme.aut.androidwallet.sqlite.BasicSettings;
import hu.bme.aut.androidwallet.sqlite.OrderItem;
import hu.bme.aut.androidwallet.sqlite.PersistenceDataHelper;
import hu.bme.aut.androidwallet.sqlite.SaladItem;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton confirmButton;
    private LinearLayout listOfRows;
    private LayoutInflater inflater;
    private PersistenceDataHelper dataHelper;
    private List<SaladItem> saladlist;
    private OrderItem order;

    BasicSettings bs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initlist();
        dataHelper = new PersistenceDataHelper(this);


        confirmButton=findViewById(R.id.fab11);
        listOfRows = findViewById(R.id.list_of_rows);
        PreLoadData();
        order=new OrderItem();
        setListOfRows();
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<listOfRows.getChildCount();i++){
                    EditText et=listOfRows.getChildAt(i).findViewById(R.id.editText2);
                    int quantity=Integer.parseInt(et.getText().toString());

                    if(quantity>0){
                        SaladItem si=new SaladItem();
                       for(int j=0;j<saladlist.size();j++){
                           TextView tv=listOfRows.getChildAt(i).findViewById(R.id.row_salary_name);
                           if(saladlist.get(j).getName().equals(tv.getText())){
                               si=saladlist.get(j);
                           }
                       }
                       order.Add(si, quantity);
                    }
                }
               Intent toSum=new Intent(MainActivity.this, CheckOutActivity.class);
                //toSum.putExtra("saladlist", String.valueOf(saladlist));
                Map<String, Integer> myMap= new HashMap<String, Integer>();
                myMap=order.getOrderSimple(saladlist);

                toSum.putExtra("hashmap", (Serializable) myMap);
               startActivity(toSum);
            }
        });


    }
    public void restoreObjects(final List<SaladItem> salads) {
        this.saladlist = salads;
    }
    private void initlist(){
        this.saladlist=new ArrayList<>();

    }




    private void PreLoadData(){
        dataHelper.open();
        saladlist=dataHelper.restorePoints();
        dataHelper.close();
        if(saladlist.size()==0){
            saladlist=null;
            bs=new BasicSettings(this);

            saladlist=bs.getData();
            dataHelper.open();
            dataHelper.persistPoints(saladlist);
            dataHelper.close();

       }


}
private void setListOfRows(){


        for(int i=0;i<saladlist.size();i++){
    inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowItem = inflater.inflate(R.layout.salary_row, null);

            ImageView icon = rowItem.findViewById(R.id.salary_direction_icon);
            TextView rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
            TextView rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
            EditText editText=rowItem.findViewById(R.id.editText2);
            icon.setImageResource(saladlist.get(i).getPic());
            editText.setText(R.string.zero);
            rowItemSalaryName.setText(saladlist.get(i).getName());
            rowItemSalaryAmount.setText(getString(R.string.poundstring)+saladlist.get(i).getPrice()+"    ");
            listOfRows.addView(rowItem);


        }

}
}
