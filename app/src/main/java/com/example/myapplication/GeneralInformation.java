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
    Bundle bundle;
    private Button button;
    private RadioGroup rg;
    private String Visatype, Country, Visacategory, Purposeofvisit, Processpriority, Nationality, Noofapplications;
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


        Visatype = visaCategoryET.getSelectedItem().toString();
        Country = countryET.getSelectedItem().toString();
        Visacategory = visaCategoryET.getSelectedItem().toString();
        Purposeofvisit = purposeOfVisitET.getSelectedItem().toString();
        Processpriority = processPriorityET.getSelectedItem().toString();
        Nationality = nationalityET.getSelectedItem().toString();
        Noofapplications = noOfApplicantsET.getSelectedItem().toString();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the checked Radio Button ID from Radio Grou[
                int selectedRadioButtonID = rg.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID == 1) {
                    if (!Visatype.contentEquals("-Select-") && !Country.contentEquals("-Select-") &&
                            !Visacategory.contentEquals("-Select-") && !Processpriority.contentEquals("-Select-") &&
                            !Purposeofvisit.contentEquals("-Select-") && Nationality.contentEquals("-Select-") &&
                            !Noofapplications.contentEquals("-Select-")) {
                        bundle.putInt("reference",1);
                        bundle.putString("visacategory",Visacategory);
                        bundle.putString("country",Country);
                        bundle.putString("visatype",Visatype);
                        bundle.putString("processpriority",Processpriority);
                        bundle.putString("purposeofvisit",Purposeofvisit);
                        bundle.putString("nationality",Nationality);
                        bundle.putString("noofapplicants",Noofapplications);
                        bundle.putString("noofapplicants",Noofapplications);
                        traveldetails td = new traveldetails();
                        td.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Fragment_container,td).addToBackStack(null).commit();
                    }
                } else if (selectedRadioButtonID == 2) {
                    if (!Visatype.contentEquals("-Select-") && !Country.contentEquals("-Select-") &&
                            !Visacategory.contentEquals("-Select-") && !Processpriority.contentEquals("-Select-") &&
                            !Purposeofvisit.contentEquals("-Select-") && Nationality.contentEquals("-Select-") &&
                            !Noofapplications.contentEquals("-Select-")) {
                        bundle.putInt("reference",2);
                        bundle.putString("visacategory",Visacategory);
                        bundle.putString("country",Country);
                        bundle.putString("visatype",Visatype);
                        bundle.putString("processpriority",Processpriority);
                        bundle.putString("purposeofvisit",Purposeofvisit);
                        bundle.putString("nationality",Nationality);
                        bundle.putString("noofapplicants",Noofapplications);
                        passportDetails pd = new passportDetails();
                        pd.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Fragment_container,pd).addToBackStack(null).commit();
                        //  tv_result.setText("Nothing selected from Radio Group.");
                    }
                }
                Log.v("hi", selectedRadioButtonID + " ");
            }
        });
    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}
