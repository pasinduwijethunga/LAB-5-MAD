package com.example.lab5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5.DBHandler.DBHandler;

import java.util.ArrayList;

public class ListAll extends AppCompatActivity {
    ListView listView;
    ArrayList datalist;
    ArrayAdapter arrayAdapter;
    DBHandler ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);

        listView = findViewById(R.id.listall);
        ab = new DBHandler(getApplicationContext());
       datalist = ab.readAllInfo();

       arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,datalist);
       listView.setAdapter(arrayAdapter);






    }
}
