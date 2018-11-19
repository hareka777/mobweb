package hu.bme.aut.androidwallet;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        ViewPager vpProfile = findViewById(R.id.viewpager444);
        vpProfile.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }
}
