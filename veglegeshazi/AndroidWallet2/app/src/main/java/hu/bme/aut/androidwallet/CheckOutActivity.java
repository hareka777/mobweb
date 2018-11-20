package hu.bme.aut.androidwallet;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.bme.aut.androidwallet.fragments.CkeckoutFragment;
import hu.bme.aut.androidwallet.sqlite.OrderItem;
import hu.bme.aut.androidwallet.sqlite.PersistenceDataHelper;
import hu.bme.aut.androidwallet.sqlite.SaladItem;

public class CheckOutActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);



        ViewPager vpProfile = findViewById(R.id.viewpager444);

        vpProfile.setAdapter(new PagerAdapter(getSupportFragmentManager()));





    }





}
