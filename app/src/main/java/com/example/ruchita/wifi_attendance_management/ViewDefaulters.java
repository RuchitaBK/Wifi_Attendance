package com.example.ruchita.wifi_attendance_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ViewDefaulters extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_defaulters);

        Database_Helper db = new Database_Helper(this);

        textView =  (TextView) findViewById(R.id.textView4);

        List<Student> contacts = db.getAllContacts();

        textView.setText("Defaulter students are \n\n");

        for (Student cn : contacts) {
            // String log1 = "Rollno: "+cn.getID()+" ,Name: " + cn.getName() + " ,Branch: " + cn.getBranch()+ "Address: " +cn.getAddress();
            // String log = log1+ "Phone: "+cn.getMobile_no()+ "Div: "+cn.getDiv()+"Password: "+cn.getPassword()+"Attd: "+cn.getAttendance();
                if(cn.getAttendance()<10)
                textView.append(cn.getID() + " "+ cn.getName()+"\n");


        }
    }
}
