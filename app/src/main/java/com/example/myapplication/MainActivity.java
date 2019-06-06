package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.LinearLayout);
        button = (Button)findViewById(R.id.NextFrame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new GeneralInformation()).commit();
                button.setVisibility(View.GONE);
                linearLayout.setBackgroundColor(Color.BLUE);
            }
        });

    }
}
