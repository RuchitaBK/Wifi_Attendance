package com.example.ruchita.wifi_attendance_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {


    Button add_student, update_student, add_teach, update_teach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        add_student = (Button) findViewById(R.id.add_stud);
        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Student.class);
                startActivity(intent);
            }
        });

        update_student = (Button) findViewById(R.id.update_Stud);
        update_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Update_Student.class);
                startActivity(intent);
            }
        });


        add_teach = (Button) findViewById(R.id.add_teacher);
        add_teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Teacher.class);
                startActivity(intent);
            }
        });

        update_teach = (Button) findViewById(R.id.update_teacher);
        update_teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Update_Teacher.class);
                startActivity(intent);
            }
        });


    }
}