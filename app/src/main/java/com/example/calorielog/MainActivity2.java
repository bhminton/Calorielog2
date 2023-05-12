package com.example.calorielog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
     Calendar calendar;
      TextView textView;
      SimpleDateFormat simpleDateFormat;
      String Date;
    ArrayAdapter dailyLogArrayAdapter;
    ListView lv_resultlist;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);

        ListView lv_resultlist = findViewById(R.id.lv_resultlist);
        DBHelper dbHelper = new DBHelper(MainActivity2.this);
        dailyLogArrayAdapter = new ArrayAdapter<>

                (MainActivity2.this ,  android.R.layout.simple_list_item_1,dbHelper.getEverything());
        lv_resultlist.setAdapter(dailyLogArrayAdapter);
        calendar = Calendar.getInstance();
        simpleDateFormat= new SimpleDateFormat( "MM-dd-yyyy");
        Date = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, Date, Toast.LENGTH_SHORT).show();

    }
}