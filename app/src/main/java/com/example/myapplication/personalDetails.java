package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

public class personalDetails extends Fragment {
    View mView;
    private Spinner gender;
    private Button button;
    private Bundle bundle;
    private TextInputLayout title,firstName,middleName,lastName,dateofBirth,countryofBirth,cityofBirth;
    private TextInputLayout martialStatus,profession_Or_Designation,religion,educationalQualification;
    private TextInputLayout userrefNo,nationality,prenationalityifAny,pancardNo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.personal_details,container,false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;

        button = mView.findViewById(R.id.next);

        bundle = getArguments();
        title = mView.findViewById(R.id.title);
        firstName = mView.findViewById(R.id.FirstName);
        middleName = mView.findViewById(R.id.MiddleName);
        lastName = mView.findViewById(R.id.LastName);
        dateofBirth = mView.findViewById(R.id.DateofBirth);
        countryofBirth = mView.findViewById(R.id.CountryofBirth);
        cityofBirth = mView.findViewById(R.id.CityofBirth);
        martialStatus = mView.findViewById(R.id.MartialStatus);
        profession_Or_Designation = mView.findViewById(R.id.Profession_Designation);
        religion = mView.findViewById(R.id.Religion);
        educationalQualification = mView.findViewById(R.id.Education_Qualification);
        userrefNo = mView.findViewById(R.id.UserrefNo);
        nationality = mView.findViewById(R.id.Nationality);
        prenationalityifAny = mView.findViewById(R.id.Prenationality);
        pancardNo = mView.findViewById(R.id.PanCardNo);

        gender = mView.findViewById(R.id.GenderChoose);

        title.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(title));
        firstName.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(firstName));
        middleName.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(middleName));
        lastName.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(lastName));
        dateofBirth.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(dateofBirth));

        countryofBirth.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(countryofBirth));
        cityofBirth.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(cityofBirth));
        martialStatus.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(martialStatus));
        profession_Or_Designation.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(profession_Or_Designation));
        religion.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(religion));

        educationalQualification.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(educationalQualification));
        userrefNo.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(userrefNo));
        nationality.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(nationality));
        prenationalityifAny.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(prenationalityifAny));
        pancardNo.getEditText().addTextChangedListener(new personalDetails.CustomTextWatcher(pancardNo));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("title",title.getEditText().getText().toString().trim());
                bundle.putString("firstName",firstName.getEditText().getText().toString().trim());
                bundle.putString("middleName",middleName.getEditText().getText().toString().trim());
                bundle.putString("lastName",lastName.getEditText().getText().toString().trim());
                bundle.putString("dateofBirth",dateofBirth.getEditText().getText().toString().trim());

                bundle.putString("countryofBirth",countryofBirth.getEditText().getText().toString().trim());
                bundle.putString("cityofBirth",cityofBirth.getEditText().getText().toString().trim());
                bundle.putString("martialStatus",martialStatus.getEditText().getText().toString().trim());
                bundle.putString("profession_Or_Designation",profession_Or_Designation.getEditText().getText().toString().trim());
                bundle.putString("religion",religion.getEditText().getText().toString().trim());

                bundle.putString("educationalQualification",educationalQualification.getEditText().getText().toString().trim());
                bundle.putString("userrefNo",userrefNo.getEditText().getText().toString().trim());
                bundle.putString("nationality",nationality.getEditText().getText().toString().trim());
                bundle.putString("prenationalityifAny",prenationalityifAny.getEditText().getText().toString().trim());
                bundle.putString("pancardNo",pancardNo.getEditText().getText().toString().trim());

                passportDetails pd = new passportDetails();
                pd.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,pd).addToBackStack(null).commit();

            }
        });
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
