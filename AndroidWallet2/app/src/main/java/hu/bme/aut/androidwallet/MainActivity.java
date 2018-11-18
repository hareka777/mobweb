package hu.bme.aut.androidwallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import hu.bme.aut.androidwallet.sqlite.PersistenceDataHelper;
import hu.bme.aut.androidwallet.sqlite.SaladItem;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton confirmButton;
    private LinearLayout listOfRows;
    private LayoutInflater inflater;
    private PersistenceDataHelper dataHelper;
    private List<SaladItem> saladlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initlist();
        dataHelper = new PersistenceDataHelper(this);
        //dataHelper.open();
        //restorePersistedObjects();
        //if we just instelled the app we need to fill the database by salads

        confirmButton=findViewById(R.id.fab11);
        listOfRows = findViewById(R.id.list_of_rows);
        PreLoadData();

        //setListOfRows();
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent toSum=new Intent(MainActivity.this, Order.class);
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

    @Override
    protected void onResume() {
        super.onResume();
        //dataHelper.open();
    }

    @Override
    protected void onPause() {
        //dataHelper.close();
        super.onPause();
    }


    private void PreLoadData(){
        dataHelper.open();
        SaladItem salad=new SaladItem();
        salad.setName("American Macaroni Salad");
        salad.setPrice(20);
        salad.setBought(25);


        //salad.setPic("american_macaroni_salad");
        saladlist.add(salad);
        dataHelper.persistPoints(saladlist);
        dataHelper.close();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowItem = inflater.inflate(R.layout.salary_row, null);

        ImageView icon = rowItem.findViewById(R.id.salary_direction_icon);
        TextView rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        TextView rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);

        icon.setImageResource(R.drawable.american_macaroni_salad);

        rowItemSalaryName.setText("American Macaroni Salad");
        rowItemSalaryAmount.setText("£20");


        listOfRows.addView(rowItem);



        View rowItem1 = inflater.inflate(R.layout.salary_row, null);
        ImageView icon1 = rowItem1.findViewById(R.id.salary_direction_icon);
        TextView rowItemSalaryName1 = rowItem1.findViewById(R.id.row_salary_name);
        TextView rowItemSalaryAmount1 = rowItem1.findViewById(R.id.row_salary_amount);
        icon1.setImageResource(R.drawable.beef_salad_with_chicory_pear_and_parmigiano_reggiano);
        rowItemSalaryName1.setText("Beef salad");
        rowItemSalaryAmount1.setText("£35");
        listOfRows.addView(rowItem1);


        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.black_bean_asparagus_and_jicama_salad);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Aspargus salad");
        rowItemSalaryAmount.setText("£19");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.caprese_salad);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Caprese salad");
        rowItemSalaryAmount.setText("£24");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.chinese_chicken_salad);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Chinese chicken salad");
        rowItemSalaryAmount.setText("£27");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.italian_lentil_salad);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Italian salad");
        rowItemSalaryAmount.setText("£22");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.nicoise_salad);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Nicolise salad");
        rowItemSalaryAmount.setText("£34");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.panzanella);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Panzanella");
        rowItemSalaryAmount.setText("£25");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        icon.setImageResource(R.drawable.parmigiano_reggiano_pomegranate_and_wild_rocket_salad);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText("Pomegranate salad");
        rowItemSalaryAmount.setText("£26");
        listOfRows.addView(rowItem);

        rowItem = inflater.inflate(R.layout.salary_row, null);
        icon = rowItem.findViewById(R.id.salary_direction_icon);
        int id=R.drawable.peppered_tuna_with_nicoise_salad;
        icon.setImageResource(id);
        rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
        rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
        rowItemSalaryName.setText(" Peppered Tuna salad");
        rowItemSalaryAmount.setText("£28");
        listOfRows.addView(rowItem);

}
private void setListOfRows(){
        dataHelper.open();
        saladlist=null;
        restoreObjects(dataHelper.restorePoints());
        for(int i=0;i<saladlist.size();i++){
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowItem = inflater.inflate(R.layout.salary_row, null);
            ImageView icon = rowItem.findViewById(R.id.salary_direction_icon);

            TextView rowItemSalaryName = rowItem.findViewById(R.id.row_salary_name);
            TextView rowItemSalaryAmount = rowItem.findViewById(R.id.row_salary_amount);
            icon.setImageResource(R.drawable.beef_salad_with_chicory_pear_and_parmigiano_reggiano);
            //icon.setImageResource(saladlist.get(i).getPic());
            //int id = getResources().getIdentifier(saladlist.get(i).getName(), "drawable", getPackageName());
            //icon.setImageResource(id);
            rowItemSalaryName.setText(saladlist.get(i).getName());
            rowItemSalaryAmount.setText(saladlist.get(i).getPrice());


            listOfRows.addView(rowItem);
        }
        dataHelper.close();
}
}
