package hu.bme.aut.androidwallet.sqlite;
import hu.bme.aut.androidwallet.sqlite.PersistenceDataHelper;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<SaladItem> saladlist;
    private PersistenceDataHelper datahelper;

    public DataManager(){
        saladlist=new ArrayList<>();
        //datahelper=new PersistenceDataHelper(this);
    }
    public List<SaladItem> getData(){
        MakeDataUpToDate();
        return saladlist;
    }
    private void MakeDataUpToDate(){
        datahelper.open();
        saladlist=datahelper.restorePoints();
        datahelper.close();
    }
    public void SaveData(List<SaladItem> salad){
        datahelper.open();
        datahelper.persistPoints(salad);
        datahelper.close();

    }
    public void create(){

    }


}
