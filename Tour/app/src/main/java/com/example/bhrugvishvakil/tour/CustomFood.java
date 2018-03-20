package com.example.bhrugvishvakil.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomFood extends AppCompatActivity {
    ListView lifood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_food);
        Intent i=getIntent();
        ArrayList<String> re=i.getStringArrayListExtra("name");

        //String[] a=new String[];
        //a[0]=re[0];
        // String s=Arrays.toString(re.toArray());
        //Toast.makeText(Main2Activity.this,re.get(0),Toast.LENGTH_LONG).show();
        lifood=(ListView)findViewById(R.id.list_set1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(CustomFood.this,android.R.layout.simple_list_item_1,re);
        lifood.setAdapter(adapter);
    }
}
