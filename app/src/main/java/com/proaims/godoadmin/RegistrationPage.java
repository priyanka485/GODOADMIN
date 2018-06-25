package com.proaims.godoadmin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class RegistrationPage extends Activity {

    EditText et_organisation_name, et_organisation_code, et_organisation_email, et_phonenumber, et_license_startdate,
            et_license_endate, et_no_license, et_address;
    Switch sw_status;
    Spinner sp_type;
    Button btn_register;

    String s_organisation_name, s_organisation_code, s_organisation_email, s_phonenumber, s_license_startdate,
            s_license_endate, s_no_license, s_address;
    String[] types = {"Delivery Management", "Task Management", "Facility Management"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        et_organisation_name = findViewById(R.id.et_organisation_name);
        et_organisation_code = findViewById(R.id.et_organisation_code);
        et_organisation_email = findViewById(R.id.et_organisation_email);
        et_phonenumber = findViewById(R.id.et_phonenumber);
        et_license_startdate = findViewById(R.id.et_license_startdate);
        et_license_endate = findViewById(R.id.et_license_endate);
        et_no_license = findViewById(R.id.et_no_license);
        et_address = findViewById(R.id.et_address);

        sw_status = findViewById(R.id.sw_status);
        sw_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        sp_type = findViewById(R.id.sp_type);
        ArrayAdapter<CharSequence> langAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, types);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(langAdapter);

        sp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_register = findViewById(R.id.btnLogin);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s_organisation_name = et_organisation_name.getText().toString();
                s_organisation_code = et_organisation_code.getText().toString();
                s_organisation_email = et_organisation_email.getText().toString();
                s_phonenumber = et_phonenumber.getText().toString();
                s_license_startdate = et_license_startdate.getText().toString();
                s_license_endate = et_license_endate.getText().toString();
                s_no_license = et_no_license.getText().toString();
                s_address = et_address.getText().toString();
            }
        });


    }
}
