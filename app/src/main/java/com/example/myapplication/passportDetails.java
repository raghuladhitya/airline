package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class passportDetails extends Fragment {
    View mView;
    Button button;
    private String c1,s1,ci1,l1,l2,pinCode,Mobileno,Email1;
    private TextView c,s,ci;
    private Bundle bundle;
    private Spinner country,state,city;
    private TextInputLayout line1,line2,pincode,mobileno,email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.passport_details,container,false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;

        String star = getColoredSpanned(" *", "#FF0000");

        c.setText(Html.fromHtml(getColoredSpanned(c.getText().toString().trim(), "#000000") + " " + star));
        s.setText(Html.fromHtml(getColoredSpanned(s.getText().toString().trim(), "#000000") + " " + star));
        ci.setText(Html.fromHtml(getColoredSpanned(ci.getText().toString().trim(), "#000000") + " " + star));

        c = mView.findViewById(R.id.Country);
        s = mView.findViewById(R.id.State);
        ci = mView.findViewById(R.id.City);

        bundle = getArguments();

        button = mView.findViewById(R.id.Finished);
        line1=  mView.findViewById(R.id.line_1);
        line2 =  mView.findViewById(R.id.line_2);
        pincode =  mView.findViewById(R.id.Pincode);
        mobileno = mView.findViewById(R.id.Mobile_no);
        email =  mView.findViewById(R.id.Email);

        line1.getEditText().addTextChangedListener(new passportDetails.CustomTextWatcher(line1));
        line2.getEditText().addTextChangedListener(new passportDetails.CustomTextWatcher(line2));
        pincode.getEditText().addTextChangedListener(new passportDetails.CustomTextWatcher(pincode));
        mobileno.getEditText().addTextChangedListener(new passportDetails.CustomTextWatcher(mobileno));
        email.getEditText().addTextChangedListener(new passportDetails.CustomTextWatcher(email));

        city = mView.findViewById(R.id.CityET);
        state = mView.findViewById(R.id.StateET);
        country = mView.findViewById(R.id.CountryET);

        ArrayAdapter<CharSequence> city1= ArrayAdapter.createFromResource(this.getActivity(), R.array.VisaCategory, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> state1= ArrayAdapter.createFromResource(this.getActivity(), R.array.VisaType, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> country1 = ArrayAdapter.createFromResource(this.getActivity(), R.array.Country1, android.R.layout.simple_spinner_item);

        city.setAdapter(city1);
        state.setAdapter(state1);
        country.setAdapter(country1);

        l1 = line1.getEditText().getText().toString().trim();
        l2 = line2.getEditText().getText().toString().trim();
        pinCode = pincode.getEditText().getText().toString().trim();
        Mobileno = mobileno.getEditText().getText().toString().trim();
        Email1 = email.getEditText().getText().toString().trim();

        c1 = city.getSelectedItem().toString();
        s1 = state.getSelectedItem().toString();
        ci1 = country.getSelectedItem().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!c1.contentEquals("-Select-") && !s1.contentEquals("-Select-") &&
                        !ci1.contentEquals("-Select-") && !l1.isEmpty() && !l2.isEmpty() &&
                        !pinCode.isEmpty() && !Mobileno.isEmpty() && !Email1.isEmpty()){
                    bundle.putString("City",ci1);
                    bundle.putString("Country",c1);
                    bundle.putString("State",s1);
                    bundle.putString("line1",l1);
                    bundle.putString("line2",l2);
                    bundle.putString("pincode",pinCode);
                    bundle.putString("mobileNo",Mobileno);
                    bundle.putString("Email",Email1);

                    Intent i = new Intent(getContext(),DisplayActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
    private class CustomTextWatcher implements TextWatcher {
        private TextInputLayout mEditText;

        private CustomTextWatcher(TextInputLayout e) {
            mEditText = e;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (s.toString().isEmpty()) {
                mEditText.setError("Field Required");
                mEditText.setErrorEnabled(true);
            } else {
                mEditText.setErrorEnabled(false);
            }
        }
    }
}
