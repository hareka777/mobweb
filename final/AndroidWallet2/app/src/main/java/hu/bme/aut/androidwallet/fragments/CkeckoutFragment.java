package hu.bme.aut.androidwallet.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.bme.aut.androidwallet.Menu;
import hu.bme.aut.androidwallet.Order;
import hu.bme.aut.androidwallet.PopularActivity;
import hu.bme.aut.androidwallet.R;
import hu.bme.aut.androidwallet.sqlite.PersistenceDataHelper;
import hu.bme.aut.androidwallet.sqlite.SaladItem;


public class CkeckoutFragment extends Fragment {

private List<SaladItem> saladlist;
private LinearLayout listOfRows;
private PersistenceDataHelper dataHelper;
private Map<String, Integer> finalorder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ckeckout, container, false);

        TextView tv2 = rootView.findViewById(R.id.text2);
        listOfRows=rootView.findViewById(R.id.list_of_rows99);
        Button ck=rootView.findViewById(R.id.acceptbtn);
        RadioButton radioButton=rootView.findViewById(R.id.cashid);
        radioButton.toggle();
        final CheckBox box= rootView.findViewById(R.id.checkboxapply);
        ck.setText(R.string.conf);
        ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(box.isChecked()==true){
                    SaveOrder();
                    Intent toSum=new Intent(getActivity(), Order.class);
                    startActivity(toSum);
                }


            }
        });
        dataHelper=new PersistenceDataHelper(getActivity());
        dataHelper.open();
        saladlist=dataHelper.restorePoints();
        dataHelper.close();
        finalorder=(HashMap) getActivity().getIntent().getSerializableExtra("hashmap");
        FillRows();
        TextView finalprice=rootView.findViewById(R.id.finalprice);
        finalprice.setText("£ "+sumOrder());
        return rootView;
    }
    private void SaveOrder(){
        for(int i=0;i<saladlist.size();i++){
            if(finalorder.containsKey(saladlist.get(i).getName()))
            {

                int q=finalorder.get(saladlist.get(i).getName());
               saladlist.get(i).setBought(saladlist.get(i).getBought()+q);
            }


        }
        dataHelper.open();
        dataHelper.persistPoints(saladlist);
        dataHelper.close();
    }
    private void FillRows(){
        for(int i=0;i<saladlist.size();i++){
            if(finalorder.containsKey(saladlist.get(i).getName()))
            {
                LayoutInflater inflater1=(LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View rowItem = inflater1.inflate(R.layout.checkout_row, null);

                ImageView icon = rowItem.findViewById(R.id.salary_direction_icon1);
                TextView rowItemSalaryName = rowItem.findViewById(R.id.orderName);
                TextView rowItemSalaryAmount = rowItem.findViewById(R.id.orderQuantity);


                icon.setImageResource(saladlist.get(i).getPic());
                rowItemSalaryName.setText(saladlist.get(i).getName());
                int q=finalorder.get(saladlist.get(i).getName());
                rowItemSalaryAmount.setText(getString(R.string.qq)+q);

                listOfRows.addView(rowItem);


            }


        }
    }
    private int sumOrder(){
        int sum=0;
        for(int i=0;i<saladlist.size();i++){
            if(finalorder.containsKey(saladlist.get(i).getName()))
            {
                sum+=saladlist.get(i).getPrice()*finalorder.get(saladlist.get(i).getName());

            }


        }
        return sum;
    }


}