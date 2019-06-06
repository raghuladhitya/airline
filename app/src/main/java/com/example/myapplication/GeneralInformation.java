package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;

public class GeneralInformation extends Fragment {
    View mView;
    private TextView visaType,country,visaCategory,purposeOfVisit,processPriority,nationality,noOfApplicants;
    private EditText edittext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.general_information,container,false);

        visaType = (TextView)mView.findViewById(R.id.VisaType);
        country = (TextView)mView.findViewById(R.id.Country);
        visaCategory = (TextView)mView.findViewById(R.id.VisaCategory);
        purposeOfVisit = (TextView)mView.findViewById(R.id.Purpose_of_Visit);
        processPriority = (TextView)mView.findViewById(R.id.Process_Priority);
        nationality = (TextView)mView.findViewById(R.id.Nationality);
        noOfApplicants = (TextView)mView.findViewById(R.id.No_of_Applicants);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;

        String star = getColoredSpanned(" *","#FF0000");

        visaType.setText(Html.fromHtml(getColoredSpanned(visaType.getText().toString().trim(), "#000000") +" "
                + star));
        country.setText(Html.fromHtml(getColoredSpanned(country.getText().toString().trim(), "#000000") +" "
                + star));
        visaCategory.setText(Html.fromHtml(getColoredSpanned(visaCategory.getText().toString().trim(), "#000000") +" "
                + star));
        purposeOfVisit.setText(Html.fromHtml(getColoredSpanned(purposeOfVisit.getText().toString().trim(), "#000000") +" "
                + star));
        processPriority.setText(Html.fromHtml(getColoredSpanned(processPriority.getText().toString().trim(), "#000000") +" "
                + star));
        nationality.setText(Html.fromHtml(getColoredSpanned(nationality.getText().toString().trim(), "#000000") +" "
                + star));
        noOfApplicants.setText(Html.fromHtml(getColoredSpanned(noOfApplicants.getText().toString().trim(), "#000000") +" "
                + star));

    }
    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}
