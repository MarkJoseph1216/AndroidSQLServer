package com.example.androidappwithsqlserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.androidappwithsqlserver.Class.GetData;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView_Data;
    Button btnGet;
    SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_Data = (ListView) findViewById(R.id.listView_Data);
        btnGet = (Button) findViewById(R.id.btnGet);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Map<String,String>> MyDataList = null;
                GetData myData = new GetData();
                MyDataList = myData.getData();

                String[] fromWhere = {"ID", "Country", "Capital"};
                int[] viewWhere = {R.id.ID, R.id.Country, R.id.Capital};
                simpleAdapter = new SimpleAdapter(MainActivity.this, MyDataList,R.layout.listview_layout, fromWhere, viewWhere);
                listView_Data.setAdapter(simpleAdapter);

            }
        });
    }
}
