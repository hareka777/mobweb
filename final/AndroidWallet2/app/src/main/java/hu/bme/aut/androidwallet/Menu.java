package hu.bme.aut.androidwallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button s;
    Button p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        s=findViewById(R.id.button4);
        p=findViewById(R.id.button5);
                s.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent toSum=new Intent(Menu.this, MainActivity.class);
                        startActivity(toSum);
                    }
                });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSum=new Intent(Menu.this, PopularActivity.class);
                startActivity(toSum);
            }
        });

    }
}
