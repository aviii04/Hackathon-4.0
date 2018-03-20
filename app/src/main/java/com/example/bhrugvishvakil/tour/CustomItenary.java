package com.example.bhrugvishvakil.tour;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomItenary extends AppCompatActivity {
    ListView li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_itenary);
        Intent i=getIntent();
        ArrayList<String> re=i.getStringArrayListExtra("name");

        //String[] a=new String[];
        //a[0]=re[0];
        // String s=Arrays.toString(re.toArray());
        //Toast.makeText(Main2Activity.this,re.get(0),Toast.LENGTH_LONG).show();
        li=(ListView)findViewById(R.id.list_set);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(CustomItenary.this,android.R.layout.simple_list_item_1,re);
        li.setAdapter(adapter);
    }
}


