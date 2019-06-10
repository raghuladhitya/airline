package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class traveldetails extends Fragment {
    View mView;
    private EditText OriginCity, AirlineName1, FlightNo1, ArrDate, PNR1;
    private EditText DestinationCity, AirlineName2, FlightNo2, DepartureDate, PNR2;

    String origincity, airlineName1, flightNo1, arrDate, pnr1;
    String destinationcity, airlineName2, flightNo2, departuredate, pnr2;
    private Button button;
    private TextView OriginCityTV, AirlineName1TV, FlightNo1TV, ArrDateTV, PNR1TV;
    private TextView DestinationCityTV, AirlineName2TV, FlightNo2TV, DepartureDateTV, PNR2TV;

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

        String star = getColoredSpanned(" *", "#FF0000");

        button = (Button) mView.findViewById(R.id.Proceed_Button);

        OriginCityTV = (TextView) mView.findViewById(R.id.origincity);
        AirlineName1TV = (TextView) mView.findViewById(R.id.airlinename);
        FlightNo1TV = (TextView) mView.findViewById(R.id.flightno1);
        ArrDateTV = (TextView) mView.findViewById(R.id.arrivaldate);
        PNR1TV = (TextView) mView.findViewById(R.id.PNR1);

        DestinationCityTV = (TextView) mView.findViewById(R.id.destinationcity);
        AirlineName2TV = (TextView) mView.findViewById(R.id.airlinename2);
        FlightNo2TV = (TextView) mView.findViewById(R.id.flightno2);
        DepartureDateTV = (TextView) mView.findViewById(R.id.departuredate);
        PNR2TV = (TextView) mView.findViewById(R.id.PNR2);

        OriginCity = (EditText) mView.findViewById(R.id.origin_city);
        AirlineName1 = (EditText) mView.findViewById(R.id.Edit_airline1);
        FlightNo1 = (EditText) mView.findViewById(R.id.edit_flightno1);
        ArrDate = (EditText) mView.findViewById(R.id.arrival_date);
        PNR1 = (EditText) mView.findViewById(R.id.PNR_code1);

        DestinationCity = (EditText) mView.findViewById(R.id.Destination_city);
        AirlineName2 = (EditText) mView.findViewById(R.id.Edit_airline2);
        FlightNo2 = (EditText) mView.findViewById(R.id.edit_flightno2);
        DepartureDate = (EditText) mView.findViewById(R.id.Departure_date);
        PNR2 = (EditText) mView.findViewById(R.id.PNR_code2);

        origincity = OriginCity.getText().toString().trim();
        airlineName1 = AirlineName1.getText().toString().trim();
        flightNo1 = FlightNo1.getText().toString().trim();
        arrDate = ArrDate.getText().toString().trim();
        pnr1 = PNR1.getText().toString().trim();

        destinationcity = DestinationCity.getText().toString().trim();
        airlineName2 = AirlineName2.getText().toString().trim();
        flightNo2 = FlightNo2.getText().toString().trim();
        departuredate = DepartureDate.getText().toString().trim();
        pnr2 = PNR2.getText().toString().trim();

        OriginCityTV.setText(Html.fromHtml(getColoredSpanned(OriginCityTV.getText().toString().trim(), "#000000") + " " + star));
        AirlineName1TV.setText(Html.fromHtml(getColoredSpanned(AirlineName1TV.getText().toString().trim(), "#000000") + " " + star));
        FlightNo1TV.setText(Html.fromHtml(getColoredSpanned(FlightNo1TV.getText().toString().trim(), "#000000") + " " + star));
        ArrDateTV.setText(Html.fromHtml(getColoredSpanned(ArrDateTV.getText().toString().trim(), "#000000") + " " + star));
        PNR1TV.setText(Html.fromHtml(getColoredSpanned(PNR1TV.getText().toString().trim(), "#000000") + " " + star));

        DestinationCityTV.setText(Html.fromHtml(getColoredSpanned(DestinationCityTV.getText().toString().trim(), "#000000") + " " + star));
        AirlineName2TV.setText(Html.fromHtml(getColoredSpanned(AirlineName2TV.getText().toString().trim(), "#000000") + " " + star));
        FlightNo2TV.setText(Html.fromHtml(getColoredSpanned(FlightNo2TV.getText().toString().trim(), "#000000") + " " + star));
        DepartureDateTV.setText(Html.fromHtml(getColoredSpanned(DepartureDateTV.getText().toString().trim(), "#000000") + " " + star));
        PNR2TV.setText(Html.fromHtml(getColoredSpanned(PNR2TV.getText().toString().trim(), "#000000") + " " + star));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!origincity.isEmpty() && !airlineName1.isEmpty() && !flightNo1.isEmpty() &&
                        !arrDate.isEmpty() && !pnr1.isEmpty() && !destinationcity.isEmpty() &&
                        !airlineName2.isEmpty() && !flightNo2.isEmpty() && !departuredate.isEmpty() &&
                        !pnr2.isEmpty()) {
                    getFragmentManager().beginTransaction().replace(R.id.Fragment_container, new uploadDocuments()).addToBackStack(null).commit();
                } else {
                    CheckFields();
                }
            }
        });
        CheckFields();
    }

    private void CheckFields() {

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

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}
