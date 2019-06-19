package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class GeneralInformation extends Fragment {
    View mView;
    int rid;
    Bundle bundle;
    private Button button;
    private RadioGroup rg;
    private int Visatype, Country, Visacategory, Purposeofvisit, Processpriority, Nationality, Noofapplications;
    private TextView visaType, country, visaCategory, purposeOfVisit, processPriority, nationality, noOfApplicants;
    private Spinner visaTypeET, countryET, visaCategoryET, purposeOfVisitET, processPriorityET, nationalityET, noOfApplicantsET;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.general_information, container, false);

        rg = (RadioGroup) mView.findViewById(R.id.checkbox1);

        visaType = (TextView) mView.findViewById(R.id.VisaType);
        country = (TextView) mView.findViewById(R.id.Country);
        visaCategory = (TextView) mView.findViewById(R.id.VisaCategory);
        purposeOfVisit = (TextView) mView.findViewById(R.id.Purpose_of_Visit);
        processPriority = (TextView) mView.findViewById(R.id.Process_Priority);
        nationality = (TextView) mView.findViewById(R.id.Nationality);
        noOfApplicants = (TextView) mView.findViewById(R.id.No_of_Applicants);

        visaTypeET = (Spinner) mView.findViewById(R.id.VisaTypeET);
        countryET = (Spinner) mView.findViewById(R.id.CountryET);
        visaCategoryET = (Spinner) mView.findViewById(R.id.VisaCategoryET);
        purposeOfVisitET = (Spinner) mView.findViewById(R.id.PurposeofVisitET);
        processPriorityET = (Spinner) mView.findViewById(R.id.ProcessPriorityET);
        nationalityET = (Spinner) mView.findViewById(R.id.NationalityET);
        noOfApplicantsET = (Spinner) mView.findViewById(R.id.NoofApplicantsET);

        button = (Button) mView.findViewById(R.id.Proceed_Button2);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;

        bundle = new Bundle();
        String star = getColoredSpanned(" *", "#FF0000");

        visaType.setText(Html.fromHtml(getColoredSpanned(visaType.getText().toString().trim(), "#000000") + " " + star));
        country.setText(Html.fromHtml(getColoredSpanned(country.getText().toString().trim(), "#000000") + " " + star));
        visaCategory.setText(Html.fromHtml(getColoredSpanned(visaCategory.getText().toString().trim(), "#000000") + " " + star));
        purposeOfVisit.setText(Html.fromHtml(getColoredSpanned(purposeOfVisit.getText().toString().trim(), "#000000") + " " + star));
        processPriority.setText(Html.fromHtml(getColoredSpanned(processPriority.getText().toString().trim(), "#000000") + " " + star));
        nationality.setText(Html.fromHtml(getColoredSpanned(nationality.getText().toString().trim(), "#000000") + " " + star));
        noOfApplicants.setText(Html.fromHtml(getColoredSpanned(noOfApplicants.getText().toString().trim(), "#000000") + " " + star));

        ArrayAdapter<CharSequence> category = ArrayAdapter.createFromResource(this.getActivity(), R.array.VisaCategory, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> visatype = ArrayAdapter.createFromResource(this.getActivity(), R.array.VisaType, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> country = ArrayAdapter.createFromResource(this.getActivity(), R.array.Country1, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> process = ArrayAdapter.createFromResource(this.getActivity(), R.array.ProcessPriority, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> nationality = ArrayAdapter.createFromResource(this.getActivity(), R.array.Nationality, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> noofapp = ArrayAdapter.createFromResource(this.getActivity(), R.array.noofApplicants, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> purposeofvisit = ArrayAdapter.createFromResource(this.getActivity(), R.array.Nationality, android.R.layout.simple_spinner_item);

        visaTypeET.setAdapter(visatype);
        countryET.setAdapter(country);
        visaCategoryET.setAdapter(category);
        purposeOfVisitET.setAdapter(purposeofvisit);
        nationalityET.setAdapter(nationality);
        noOfApplicantsET.setAdapter(noofapp);
        processPriorityET.setAdapter(process);


        Visatype = visaCategoryET.getSelectedItemPosition();
        Country = countryET.getSelectedItemPosition();
        Visacategory = visaCategoryET.getSelectedItemPosition();
        Purposeofvisit = purposeOfVisitET.getSelectedItemPosition();
        Processpriority = processPriorityET.getSelectedItemPosition();
        Nationality = nationalityET.getSelectedItemPosition();
        Noofapplications = noOfApplicantsET.getSelectedItemPosition();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                        rid = checkedId;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rid == R.id.rb1) {

                    if (Visatype != 1 && Country != 1 &&
                            Visacategory != 1 && Processpriority != 1 &&
                            Purposeofvisit != 1 && Nationality != 1 &&
                            Noofapplications != 1) {

                        bundle.putString("reference","1");
                        bundle.putString("visacategory", visaCategoryET.getSelectedItem().toString().trim());
                        bundle.putString("country", countryET.getSelectedItem().toString().trim());
                        bundle.putString("visatype", visaTypeET.getSelectedItem().toString().trim());
                        bundle.putString("processpriority", processPriorityET.getSelectedItem().toString().trim());
                        bundle.putString("purposeofvisit", purposeOfVisitET.getSelectedItem().toString().trim());
                        bundle.putString("nationality", nationalityET.getSelectedItem().toString().trim());
                        bundle.putString("noofapplicants", noOfApplicantsET.getSelectedItem().toString().trim());
                        traveldetails td = new traveldetails();
                        td.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Fragment_container, td).addToBackStack(null).commit();
                    }
                } else if (rid == R.id.rb2) {

                    if (Visatype != 1 && Country != 1 &&
                            Visacategory != 1 && Processpriority != 1 &&
                            Purposeofvisit != 1 && Nationality != 1 &&
                            Noofapplications != 1) {

                        bundle.putString("reference","2");
                        bundle.putString("visacategory", visaCategoryET.getSelectedItem().toString().trim());
                        bundle.putString("country", countryET.getSelectedItem().toString().trim());
                        bundle.putString("visatype", visaTypeET.getSelectedItem().toString().trim());
                        bundle.putString("processpriority", processPriorityET.getSelectedItem().toString().trim());
                        bundle.putString("purposeofvisit", purposeOfVisitET.getSelectedItem().toString().trim());
                        bundle.putString("nationality", nationalityET.getSelectedItem().toString().trim());
                        bundle.putString("noofapplicants", noOfApplicantsET.getSelectedItem().toString().trim());
                        personalDetails pd = new personalDetails();
                        pd.setArguments(bundle);
                        Log.v("Hell11",bundle + "");
                        getFragmentManager().beginTransaction().replace(R.id.Fragment_container, pd).addToBackStack(null).commit();
                    }
                }
            }
        });
    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;

    }

    //  tv_result.setText("Nothing selected from Radio Group.");
}


