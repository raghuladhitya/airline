package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    Intent i;
    Bundle bundle;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18;
    TextView t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33;
    TextView t34,t35,t36,t37,t38,t39,t40;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        i = getIntent();
        bundle = i.getExtras();

        t1 = findViewById(R.id.T1);
        t2 = findViewById(R.id.T2);
        t3 = findViewById(R.id.T3);
        t4 = findViewById(R.id.T4);
        t5 = findViewById(R.id.T5);
        t6 = findViewById(R.id.T6);
        t7 = findViewById(R.id.T7);
        t8 = findViewById(R.id.T8);
        t9 = findViewById(R.id.T9);
        t10 = findViewById(R.id.T10);
        t11 = findViewById(R.id.T11);
        t12 = findViewById(R.id.T12);
        t13 = findViewById(R.id.T13);
        t14 = findViewById(R.id.T14);
        t15 = findViewById(R.id.T15);
        t16 = findViewById(R.id.T16);
        t17 = findViewById(R.id.T17);
        t18 = findViewById(R.id.T18);
        t19 = findViewById(R.id.T19);
        t20 = findViewById(R.id.T20);
        t21 = findViewById(R.id.T21);
        t22 = findViewById(R.id.T22);
        t23 = findViewById(R.id.T23);
        t24 = findViewById(R.id.T24);
        t25 = findViewById(R.id.T25);
        t26 = findViewById(R.id.T26);
        t27 = findViewById(R.id.T27);
        t28 = findViewById(R.id.T28);
        t29 = findViewById(R.id.T29);
        t30 = findViewById(R.id.T30);
        t31 = findViewById(R.id.T31);
        t32 = findViewById(R.id.T32);
        t33 = findViewById(R.id.T33);
        t34 = findViewById(R.id.T34);
        t35 = findViewById(R.id.T35);
        t36 = findViewById(R.id.T36);
        t37 = findViewById(R.id.T37);
        t38 = findViewById(R.id.T38);
        t39 = findViewById(R.id.T39);
        t40 = findViewById(R.id.T40);

        t1.setText(bundle.getString("visacategory"));
        t2.setText(bundle.getString("country"));
        t3.setText(bundle.getString("visatype"));
        t4.setText(bundle.getString("processpriority"));
        t5.setText(bundle.getString("purposeofvisit"));
        t6.setText(bundle.getString("nationality"));
        t7.setText(bundle.getString("noofapplicants"));
        String ref = bundle.getString("reference");

        if(ref.equals("1")) {

            t8.setText(bundle.getString("origincity"));
            t9.setText(bundle.getString("airlineName1"));
            t10.setText(bundle.getString("flightNo1"));
            t11.setText(bundle.getString("arrDate"));
            t12.setText(bundle.getString("pnr1"));

            t13.setText(bundle.getString("destinationcity"));
            t14.setText(bundle.getString("airlineName2"));
            t15.setText(bundle.getString("flightNo2"));
            t16.setText(bundle.getString("departuredate"));
            t17.setText(bundle.getString("pnr2"));

            t18.setText(bundle.getString("title"));
            t19.setText(bundle.getString("firstName"));
            t20.setText(bundle.getString("middleName"));
            t21.setText(bundle.getString("lastName"));
            t22.setText(bundle.getString("dateofBirth"));

            t23.setText(bundle.getString("countryofBirth"));
            t24.setText(bundle.getString("cityofBirth"));
            t25.setText(bundle.getString("martialStatus"));
            t26.setText(bundle.getString("profession_Or_Designation"));
            t27.setText(bundle.getString("religion"));

            t28.setText(bundle.getString("educationalQualification"));
            t29.setText(bundle.getString("userrefNo"));
            t30.setText(bundle.getString("nationality"));
            t31.setText(bundle.getString("prenationalityifAny"));
            t32.setText(bundle.getString("pancardNo"));

            t33.setText(bundle.getString("City"));
            t34.setText(bundle.getString("Country"));
            t35.setText(bundle.getString("State"));
            t36.setText(bundle.getString("line1"));
            t37.setText(bundle.getString("line2"));
            t38.setText(bundle.getString("pincode"));
            t39.setText(bundle.getString("mobileNo"));
            t40.setText(bundle.getString("Email"));

        }else if(ref.equals("2")) {

            t18.setText(bundle.getString("title"));
            t19.setText(bundle.getString("firstName"));
            t20.setText(bundle.getString("middleName"));
            t21.setText(bundle.getString("lastName"));
            t22.setText(bundle.getString("dateofBirth"));

            t23.setText(bundle.getString("countryofBirth"));
            t24.setText(bundle.getString("cityofBirth"));
            t25.setText(bundle.getString("martialStatus"));
            t26.setText(bundle.getString("profession_Or_Designation"));
            t27.setText(bundle.getString("religion"));

            t28.setText(bundle.getString("educationalQualification"));
            t29.setText(bundle.getString("userrefNo"));
            t30.setText(bundle.getString("nationality"));
            t31.setText(bundle.getString("prenationalityifAny"));
            t32.setText(bundle.getString("pancardNo"));

            t33.setText(bundle.getString("City"));
            t34.setText(bundle.getString("Country"));
            t35.setText(bundle.getString("State"));
            t36.setText(bundle.getString("line1"));
            t37.setText(bundle.getString("line2"));
            t38.setText(bundle.getString("pincode"));
            t39.setText(bundle.getString("mobileNo"));
            t40.setText(bundle.getString("Email"));

        }
    }
}
