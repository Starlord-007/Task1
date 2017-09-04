package com.weconnect.register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText fname, lname, email, pwd, pwd2, num, dob;
    CheckBox reading, writing, singing, dancing, cricket, football;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent i = new Intent(MainActivity.this, display.class);
        fname = (EditText) findViewById(R.id.FirstName);
        lname = (EditText) findViewById(R.id.LastName);
        email = (EditText) findViewById(R.id.Email);
        pwd = (EditText) findViewById(R.id.Password);
        pwd2 = (EditText) findViewById(R.id.ConfirmPassword);
        num = (EditText) findViewById(R.id.Number);
        dob = (EditText) findViewById(R.id.DOB);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Sex);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId) {
                    case R.id.Male:
                        RadioButton value = (RadioButton) findViewById(R.id.Male);
                        i.putExtra("sex",value.getText().toString());
                        break;
                    case R.id.Female:
                        RadioButton value2 = (RadioButton) findViewById(R.id.Female);
                        i.putExtra("sex",value2.getText().toString());
                        break;
                }
            }
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String temp = (String)(dayOfMonth+"/"+(monthOfYear + 1)+"/"+ year);
                                i.putExtra("date",temp);
                                dob.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        findViewById(R.id.Submit).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                final String name = fname.getText().toString();
                if (name.equals("")) {
                    fname.requestFocus();
                    fname.setError("First name can not be empty");
                    return;
                }
                i.putExtra("fname", name);

                final String name2 = lname.getText().toString();
                if (name2.equals("")) {
                    lname.requestFocus();
                    lname.setError("Last name can not be empty");
                    return;
                }
                i.putExtra("lname", name2);

                final String mail = email.getText().toString();
                if (mail.equals("")) {
                    email.requestFocus();
                    email.setError("Email can not be empty");
                    return;
                }
                if (!isValidEmail(mail)) {
                    email.requestFocus();
                    email.setError("Invalid Email");
                    return;
                }
                i.putExtra("email", mail);

                final String pass = pwd.getText().toString();
                if (pass.equals("") || pass.length()<6) {
                    pwd.requestFocus();
                    pwd.setError("Password must be at lest 6 characters long");
                    return;
                }
                i.putExtra("pwd", pass);

                final String pass2 = pwd2.getText().toString();
                if (!(pass2.equals(pass))) {
                    pwd2.requestFocus();
                    pwd2.setError("Password doesn't match");
                    return;
                }

                final String number = num.getText().toString();
                if (number.equals("")) {
                    num.requestFocus();
                    num.setError("Mobile number can not be empty");
                    return;
                }
                else if(num.length()<10){
                    num.requestFocus();
                    num.setError("Enter 10 digit Mobile number");
                    return;
                }
                i.putExtra("num", number);

                startActivity(i);

            }
        });

    }


    private boolean isValidEmail(String mail) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }


}
