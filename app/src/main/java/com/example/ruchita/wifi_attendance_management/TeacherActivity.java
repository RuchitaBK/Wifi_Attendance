package com.example.ruchita.wifi_attendance_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.*;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TeacherActivity extends AppCompatActivity implements View.OnClickListener{

    Button attendance, sms;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        attendance = (Button) findViewById(R.id.button4);
        attendance.setOnClickListener(this);

     /*   Intent i=getIntent();
        String name = i.getStringExtra("Name");

        t=(TextView)findViewById(R.id.textView4);
        t.setText(name);*/



    }

    public void onClick(View v)
    {
        if(v.getId()  == R.id.button4)
        {
            Intent i = new Intent(TeacherActivity.this, AccessPointActivity.class);
            startActivity(i);
        }

    }
}
