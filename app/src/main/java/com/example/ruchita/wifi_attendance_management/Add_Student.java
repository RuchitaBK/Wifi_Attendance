package com.example.ruchita.wifi_attendance_management;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 05-10-2017.
 */

public class Add_Student extends AppCompatActivity implements View.OnClickListener {

    Button save,back;
    EditText name,roll,branch,div,year,add1,mobile,attend;
    Database_Helper mydb_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);

        mydb_new = new Database_Helper(this);

        save=(Button) findViewById(R.id.save);
        save.setOnClickListener(this);
        back=(Button) findViewById(R.id.back);

        roll=(EditText)findViewById(R.id.writeroll);
        name=(EditText)findViewById(R.id.writename);
        branch=(EditText)findViewById(R.id.writebranch);
        div=(EditText)findViewById(R.id.writediv);
        year=(EditText)findViewById(R.id.writeyear);
        add1=(EditText)findViewById(R.id.writeaddress);
        mobile=(EditText)findViewById(R.id.writemobile);

        back=(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Admin.class);
                startActivity(intent);
            }
        });


    }


    public void onClick(View v) {

        if(v.getId() == R.id.save)
        {

            int r = Integer.parseInt(roll.getText().toString());
            if(roll.getText().toString().length()<0)
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }
//logic

            String n = name.getText().toString();
            if(TextUtils.isEmpty(n))
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }
            String b = branch.getText().toString();
            if(TextUtils.isEmpty(b))
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }
            String d=div.getText().toString();
            if(TextUtils.isEmpty(d))
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }
            String y=year.getText().toString();
            if(TextUtils.isEmpty(y))
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }
            String a=add1.getText().toString();
            if(TextUtils.isEmpty(a))
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }
            String m=mobile.getText().toString();
            if(TextUtils.isEmpty(m))
            {
                Toast.makeText(Add_Student.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                return;
            }

            boolean isInserted = mydb_new.insertRecord(r,n,b,d,y,a,m,n);
            if(isInserted == true) {
                Toast.makeText(Add_Student.this, "Data Inserted", Toast.LENGTH_LONG).show();
                Intent i =new Intent(Add_Student.this,SMSActivity.class);
                i.putExtra("phn",m);
                startActivity(i);
            }
            else
                Toast.makeText(Add_Student.this,"Data not Inserted",Toast.LENGTH_LONG).show();

        }
    }
}

