package com.example.ruchita.wifi_attendance_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Teacher extends AppCompatActivity implements View.OnClickListener{



    Button add_data,back_b;
    EditText name,id,subject,username,password;
    DatabaseTeacher mydb_teach;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__teacher);

        mydb_teach = new DatabaseTeacher(this);
        add_data=(Button) findViewById(R.id.add_Data);
        add_data.setOnClickListener(this);

        id=(EditText)findViewById(R.id.Teach_ID);
        name=(EditText)findViewById(R.id.Teach_Name);
        subject=(EditText)findViewById(R.id.Teach_sub);
        username=(EditText)findViewById(R.id.teach_un);
        // password=(EditText)findViewById(R.id.Teach_pwd);

        back_b=(Button) findViewById(R.id.back_button);
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),Admin.class);
                startActivity(intent1);
            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.add_Data)
        {
            int r = Integer.parseInt(id.getText().toString());
            String n = name.getText().toString();
            String s = subject.getText().toString();
            String u=username.getText().toString();
            // String p=password.getText().toString();

            boolean isInserted = mydb_teach.insert_Teacher_Record(r,n,s,u,u);
            if(isInserted == true)
                Toast.makeText(Add_Teacher.this,"Data Inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Add_Teacher.this,"Data not Inserted",Toast.LENGTH_LONG).show();

        }


    }
}

