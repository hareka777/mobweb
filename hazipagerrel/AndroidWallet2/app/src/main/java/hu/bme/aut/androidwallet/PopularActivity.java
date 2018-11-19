package hu.bme.aut.androidwallet;

import android.os.BaseBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.androidwallet.sqlite.BasicSettings;
import hu.bme.aut.androidwallet.sqlite.PersistenceDataHelper;
import hu.bme.aut.androidwallet.sqlite.SaladItem;

public class PopularActivity extends AppCompatActivity {
    PersistenceDataHelper datahelper;
    private PieChart chartSalad;
    private List<SaladItem> saladlist;
    private BasicSettings bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        saladlist=new ArrayList<>();
        datahelper=new PersistenceDataHelper(this);
        MakeDataUpToDate();
        chartSalad = findViewById(R.id.chartHoliday);
        loadChartData();
    }

    public List<SaladItem> getData(){
        MakeDataUpToDate();
        return saladlist;
    }
    private void MakeDataUpToDate(){
        datahelper.open();
        saladlist=datahelper.restorePoints();
        datahelper.close();
        if(saladlist.size()<=5){
            saladlist=null;
            bs=new BasicSettings();
            saladlist=bs.getData();
        }

    }


    private void loadChartData() {



        PieDataSet dataSet = new PieDataSet(SetEntries(), "Top 5 Salad");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        chartSalad.setData(data);
        chartSalad.invalidate();
    }
    private int SumValue(){
        int toReturn=0;
        for(int i=0;i<saladlist.size();i++){
            toReturn=toReturn+saladlist.get(i).getBought();
        }
        return toReturn;
    }
    private List<PieEntry> SetEntries(){
        MakeDataUpToDate();
        List<PieEntry> entries = new ArrayList<>();
        int sumValue=SumValue();
        int maxValue=0;
        String name="";
        for (int i=0;i<5;i++){

            maxValue=0;
            for ( int j=0;j<saladlist.size();j++){
                if(saladlist.get(i).getBought()>maxValue){
                    maxValue=saladlist.get(i).getBought();
                    name=saladlist.get(i).getName();
                }

            }
            entries.add(new PieEntry(maxValue,name));
            sumValue=sumValue-maxValue;

        }

        sumValue=sumValue-maxValue;
        entries.add(new PieEntry(sumValue, "Others"));
        return entries;
    }
}
