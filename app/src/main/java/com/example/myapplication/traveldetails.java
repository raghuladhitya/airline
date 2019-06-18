package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class traveldetails extends Fragment {
    View mView;
    private TextInputLayout OriginCity, AirlineName1, FlightNo1, ArrDate, PNR1;
    private TextInputLayout DestinationCity, AirlineName2, FlightNo2, DepartureDate, PNR2;

    String origincity, airlineName1, flightNo1, arrDate, pnr1;
    String destinationcity, airlineName2, flightNo2, departuredate, pnr2;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.travel_details_page, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        button = (Button) mView.findViewById(R.id.Proceed_Button);

        OriginCity =  mView.findViewById(R.id.origin_city);
        AirlineName1 =  mView.findViewById(R.id.Edit_airline1);
        FlightNo1 =  mView.findViewById(R.id.edit_flightno1);
        ArrDate = mView.findViewById(R.id.arrival_date);
        PNR1 =  mView.findViewById(R.id.PNR_code1);

        DestinationCity =  mView.findViewById(R.id.Destination_city);
        AirlineName2 = mView.findViewById(R.id.Edit_airline2);
        FlightNo2 = mView.findViewById(R.id.edit_flightno2);
        DepartureDate =  mView.findViewById(R.id.Departure_date);
        PNR2 = mView.findViewById(R.id.PNR_code2);
/*
        origincity = OriginCity.getEditText().toString().trim();
        airlineName1 = AirlineName1.getEditText().toString().trim();
        flightNo1 = FlightNo1.getEditText().toString().trim();
        arrDate = ArrDate.getEditText().toString().trim();
        pnr1 = PNR1.getEditText().toString().trim();

        destinationcity = DestinationCity.getEditText().toString().trim();
        airlineName2 = AirlineName2.getEditText().toString().trim();
        flightNo2 = FlightNo2.getEditText().toString().trim();
        departuredate = DepartureDate.getEditText().toString().trim();
        pnr2 = PNR2.getEditText().toString().trim();
*/

        OriginCity.getEditText().addTextChangedListener(new CustomTextWatcher(OriginCity));
        AirlineName1.getEditText().addTextChangedListener(new CustomTextWatcher(AirlineName1));
        FlightNo1.getEditText().addTextChangedListener(new CustomTextWatcher(FlightNo1));
        ArrDate.getEditText().addTextChangedListener(new CustomTextWatcher(ArrDate));
        PNR1.getEditText().addTextChangedListener(new CustomTextWatcher(PNR1));

        DestinationCity.getEditText().addTextChangedListener(new CustomTextWatcher(DestinationCity));
        AirlineName2.getEditText().addTextChangedListener(new CustomTextWatcher(AirlineName2));
        FlightNo2.getEditText().addTextChangedListener(new CustomTextWatcher(FlightNo2));
        DepartureDate.getEditText().addTextChangedListener(new CustomTextWatcher(DepartureDate));
        PNR2.getEditText().addTextChangedListener(new CustomTextWatcher(PNR2));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!OriginCity.getEditText().getText().toString().isEmpty() && !AirlineName1.getEditText().getText().toString().isEmpty()
                        && !FlightNo1.getEditText().getText().toString().isEmpty() && !ArrDate.getEditText().getText().toString().isEmpty()
                        && !PNR1.getEditText().getText().toString().isEmpty() && !DestinationCity.getEditText().getText().toString().isEmpty()
                        && !AirlineName2.getEditText().getText().toString().isEmpty() && !FlightNo2.getEditText().getText().toString().isEmpty()
                        && !DepartureDate.getEditText().getText().toString().isEmpty() && !PNR2.getEditText().getText().toString().isEmpty()) {
                    getFragmentManager().beginTransaction().replace(R.id.Fragment_container, new uploadDocuments()).addToBackStack(null).commit();
                }
            }
        });
    }

   /* private void CheckFields() {

        // This  below if Conditional Statements is for the Arrival Details

        if (origincity.isEmpty()) {
            OriginCity.setError("Field Required");
        } else {
            OriginCity.setError(null);
        }
        if (airlineName1.isEmpty()) {
            AirlineName1.setError("Field Required");
        } else {
            AirlineName1.setError(null);
        }
        if (flightNo1.isEmpty()) {
            FlightNo1.setError("Field Required");
        } else {
            FlightNo1.setError(null);
        }
        if (arrDate.isEmpty()) {
            ArrDate.setError("Field Required");
        } else {
            ArrDate.setError(null);
        }
        if (pnr1.isEmpty()) {
            PNR1.setError("Field Required");
        } else {
            PNR1.setError(null);
        }

        // This  below if Conditional Statements is for the Departure Details


        if (destinationcity.isEmpty()) {
            DestinationCity.setError("Field Required");
        } else {
            DestinationCity.setError(null);
        }
        if (airlineName2.isEmpty()) {
            AirlineName2.setError("Field Required");
        } else {
            AirlineName2.setError(null);
        }
        if (flightNo2.isEmpty()) {
            FlightNo2.setError("Field Required");
        } else {
            FlightNo2.setError(null);
        }
        if (departuredate.isEmpty()) {
            DepartureDate.setError("Field Required");
        } else {
            DepartureDate.setError(null);
        }
        if (pnr2.isEmpty()) {
            PNR2.setError("Field Required");
        } else {
            PNR2.setError(null);
        }

    }
    */

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
    private boolean PNRCheck(String num){
        return num.matches("[A-Z0-9]+");
    }
}
