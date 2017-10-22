package com.example.ruchita.wifi_attendance_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Teacher extends AppCompatActivity implements View.OnClickListener{
    Button update_data,back_up;
    EditText name,id,subject,username,password;
    DatabaseTeacher mydb_teach;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__teacher);

        mydb_teach = new DatabaseTeacher(this);
        update_data=(Button) findViewById(R.id.Update_Data);
        update_data.setOnClickListener(this);

        id=(EditText)findViewById(R.id.Teach_ID);
        name=(EditText)findViewById(R.id.Teach_Name);
        subject=(EditText)findViewById(R.id.Teach_sub);
        username=(EditText)findViewById(R.id.teach_un);
        //  password=(EditText)findViewById(R.id.Teach_pwd);

        back_up=(Button) findViewById(R.id.backup_button);
        back_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),Admin.class);
                startActivity(intent2);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Update_Data)
        {

            int r = Integer.parseInt(id.getText().toString());
            String n = name.getText().toString();
            String s = subject.getText().toString();
            String u=username.getText().toString();
            // String p=password.getText().toString();

            boolean isUpdate = mydb_teach.updateTeacherData(r,n,s,u,u);
            if(isUpdate == true)
               Toast.makeText(Update_Teacher.this,"Data Updated Successfully",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Update_Teacher.this,"Data not Updated",Toast.LENGTH_LONG).show();

        }

    }
}
