package com.example.ruchita.wifi_attendance_management;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button login,btntest, button;
    EditText username, password;
    Database_Helper db;
    DatabaseTeacher db_teacher;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database_Helper(this);
        db_teacher = new DatabaseTeacher(this);

        username = (EditText) findViewById(R.id.editText5);
        password = (EditText) findViewById(R.id.editText6);

        login = (Button) findViewById(R.id.button2);
        login.setOnClickListener(this);


        //db.insertRecord(2, "Manali", "Computer", "B", "Third", "45:34:23", "2323", "Manali");

        progressDialog=new ProgressDialog(this);
        progressDialog.setIndeterminate(false);
        progressDialog.setMessage("Please wait while processing");

      /*  Log.wtf("Reading: ", "Reading all contacts..");
        List<Student> contacts = db.getAllContacts();

        for (Student cn : contacts) {
            // String log1 = "Rollno: "+cn.getID()+" ,Name: " + cn.getName() + " ,Branch: " + cn.getBranch()+ "Address: " +cn.getAddress();
            // String log = log1+ "Phone: "+cn.getMobile_no()+ "Div: "+cn.getDiv()+"Password: "+cn.getPassword()+"Attd: "+cn.getAttendance();

            String log = cn.getName()+ "  "+cn.getAttendance();

            db.deleteContact(cn.getID());
            Log.wtf("Name: ", log);

        }
        */
    }

    public void onClick(View v) {





        if (v.getId() == R.id.button2) {


            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.equals(""))
                username.setError("Username cannot be empty");

            if(pass.equals(""))
                password.setError("Password cannot be empty");

            if (name.equals("admin") && pass.equals("admin")) {
                performsignIn();

            }

            if(name.equals("teacher")&& pass.equals("teacher"))
            {

                Intent i = new Intent(LoginActivity.this, TeacherActivity.class);
                startActivity(i);
            }
            /*else {
                int flag = db.getRecord(name);
                if (flag == 1) {
                    Intent i = new Intent(LoginActivity.this, StudentActivity.class);
                    startActivity(i);

                }
                else {
                    int flagt = db_teacher.getRecord(name);
                    if(flagt == 1)
                    // if (name.equals("teacher") && pass.equals("teacher"))
                    {
                        Intent i = new Intent(LoginActivity.this, TeacherActivity.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }*/

        }
    }

    private  void performsignIn()
    {
        new SignIntask().execute(username.getText().toString(),password.getText().toString());

    }

    private  void showProgressDisalog(Boolean mustimp)
    {
        if(mustimp)
        {
            progressDialog.show();
        }
        else
        {
            progressDialog.dismiss();
        }


    }
    private  void showAlert(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setNegativeButton("Lets Start", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();



                Intent im = new Intent(LoginActivity.this, Admin.class);
                startActivity(im);

            }
        });
        builder.show();
    }


    class SignIntask extends AsyncTask<String,Void,Boolean>
    {
        String tempusername ="admin";
        String temppassword="admin";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDisalog(true);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            showProgressDisalog(false);
            if(aBoolean)
            {
                showAlert("Welcome Admin ","You have successfully Login");
            }
            else
            {
                showAlert("Failed","Username /password is Incorrect");
            }
        }



        @Override
        protected Boolean doInBackground(String... strings) {
            String username = strings[0];
            String password =strings[1];
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return username.contentEquals(tempusername) && password.contentEquals(temppassword);

            //  return true;

        }
    }
}
