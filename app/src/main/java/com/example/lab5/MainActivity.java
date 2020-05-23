package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab5.DBHandler.DBHandler;

import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    EditText un,pw;
    Button add,select,delete,update,sign,searchbtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.buttonadd);
        select = (Button) findViewById(R.id.buttonslct);
        delete = (Button) findViewById(R.id.buttondelete);
        update = (Button) findViewById(R.id.buttonupdate);
        sign = (Button) findViewById(R.id.buttonsign);
        un = (EditText) findViewById(R.id.editTextun);
        pw = (EditText) findViewById(R.id.editTextpw);
        searchbtn = (Button) findViewById(R.id.buttonsrchup);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler  dbHandler = new DBHandler(getApplicationContext());
                long newID =  dbHandler.AddInfo(un.getText().toString(),pw.getText().toString());
                Toast.makeText(MainActivity.this, "Add Successfull"+newID, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


            }
        });

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler  dbHandler = new DBHandler(getApplicationContext());
                List user = dbHandler.readAllInfo(un.getText().toString());

                if (user.isEmpty()){
                    Toast.makeText(MainActivity.this, "user not found", Toast.LENGTH_SHORT).show();
                    un.setText(null);
                    pw.setText(null);
                }
                else{
                    Toast.makeText(MainActivity.this, "user found"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    un.setText(user.get(0).toString());
                    pw.setText(user.get(1).toString());
                }
            }
        });



            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DBHandler  dbHandler = new DBHandler(getApplicationContext());

                    Boolean status = dbHandler.updateInfo(un.getText().toString(),pw.getText().toString());

                    if (status){
                        Toast.makeText(MainActivity.this, "update sucessfully", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(MainActivity.this, "update faild", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBHandler  dbHandler = new DBHandler(getApplicationContext());
                    dbHandler.deleteInfo(un.getText().toString());
                    Toast.makeText(MainActivity.this, "user deleted", Toast.LENGTH_SHORT).show();
                }
            });

            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBHandler  dbHandler = new DBHandler(getApplicationContext());
                    if (dbHandler.loginUser(un.getText().toString(),pw.getText().toString())){
                        Toast.makeText(MainActivity.this, "Sucssusfully ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid User Name or Passwrod ", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListAll.class);
                startActivity(intent);
            }
        });
    }
}
