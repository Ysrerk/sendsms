package com.yasarerkan.sms_send;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Messagemodel> list;
    Messageadapter messageadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definition();
        loadlist();
        defineadapter();
        connectadapterwithlistview();
    }

    public void definition(){

        listView=findViewById(R.id.lstv);

    }
    public void loadlist(){
        list=new ArrayList<>();

        Messagemodel ms1=new Messagemodel("John","5642563625");
        Messagemodel ms2=new Messagemodel("Tom","1649546625");
        Messagemodel ms3=new Messagemodel("Michael","874642625");
        Messagemodel ms4=new Messagemodel("Enny","3242563625");
        Messagemodel ms5=new Messagemodel("Peter","262563625");
        list.add(ms1);
        list.add(ms2);
        list.add(ms3);
        list.add(ms4);
        list.add(ms5);
    }

    public void defineadapter(){
        messageadapter=new Messageadapter(list,this,this);


    }
    public void connectadapterwithlistview(){

        listView.setAdapter(messageadapter);
    }

}
