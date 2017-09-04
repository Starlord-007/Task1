package com.weconnect.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.lang.String;

public class display extends MainActivity {

    TextView fname, lname, email, pwd, num, sex, dob, hobbies;
    ArrayList<String> array = new ArrayList<> ();

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
        hobbies = (TextView) findViewById(R.id.Hobbies);

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


        String check1 = in.getExtras().getString("check1");
        if(!(check1==null)){
            array.add(check1);
        }
        String check2 = in.getExtras().getString("check2");
        if(!(check2==null)){
            array.add(check2);
        }
        String check3 = in.getExtras().getString("check3");
        if(!(check3==null)){
            array.add(check3);
        }
        String check4 = in.getExtras().getString("check4");
        if(!(check4==null)){
            array.add(check4);
        }
        String check5 = in.getExtras().getString("check5");
        if(!(check5==null)){
            array.add(check5);
        }
        String check6 = in.getExtras().getString("check6");
        if(!(check6==null)){
            array.add(check6);
        }

        hobbies.setText(array.toString().replaceAll("\\[|\\]", ""));


    }
}
