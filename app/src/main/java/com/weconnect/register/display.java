package com.weconnect.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class display extends MainActivity {

    TextView fname, lname, email, pwd, num, sex, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent in = getIntent();

        fname = (TextView) findViewById(R.id.FirstName);
        lname = (TextView) findViewById(R.id.LastName);
        email = (TextView) findViewById(R.id.Email);
        num = (TextView) findViewById(R.id.Number);
        pwd = (TextView) findViewById(R.id.Password);
        sex = (TextView) findViewById(R.id.Sex);
        dob = (TextView) findViewById(R.id.DOB);

        String name = in.getExtras().getString("fname");
        fname.setText(name);
        String name2 = in.getExtras().getString("lname");
        lname.setText(name2);
        String mail = in.getExtras().getString("email");
        email.setText(mail);
        String number = in.getExtras().getString("num");
        num.setText(number);
        String password = in.getExtras().getString("pwd");
        pwd.setText(password);
        String sex1 = in.getExtras().getString("sex");
        sex.setText(sex1);
        String date = in.getExtras().getString("date");
        dob.setText(date);


    }
}
