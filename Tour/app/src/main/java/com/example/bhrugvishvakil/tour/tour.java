package com.example.bhrugvishvakil.tour;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tour extends AppCompatActivity {
    ArrayList<String> selectedItems=new ArrayList<String>();
    Button maps;
    Button custom1;
    LocationDb mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        ListView ch1=(ListView)findViewById(R.id.checkable_list);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        mydb=new LocationDb(this);
        AddDataMon();
        String[] items=viewAll();
       String[] a={items[0],items[1],items[2],items[3]};
        //String[] a={"Avinash","Thakur","Vakil"};
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.rowlayout,R.id.txt_lan,a);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem=((TextView)view).getText().toString();
                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }
                else
                {
                    selectedItems.add(selectedItem);
                }
            }
        });

        custom1=(Button)findViewById(R.id.custom);

        custom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIternary();
            }
        });

        maps=(Button) findViewById(R.id.button2);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=getIntent();
                String radius=j.getStringExtra("Radius");
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("Radius",radius);
                startActivity(i);
            }
        });

        /*Intent i=getIntent();
        String radius=i.getStringExtra("Radius");
        Toast.makeText(tour.this,radius, Toast.LENGTH_LONG).show();*/


    }
    void openIternary(){
        Intent intent=new Intent(this,CustomItenary.class);
        String[] a={"d","b","c"};
        intent.putExtra("name",selectedItems);
        startActivity(intent);
    }






    private void AddDataMon() {
       /* boolean isInserted= mydb.insertData("AmerFort");
        if(isInserted==true)
            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();*/
        mydb.insertDataMon("AmerFort",25,79);
        mydb.insertDataMon("HawaMahel",27.5,79.3);
        mydb.insertDataMon("JiagarhFort",28,78.5);
        mydb.insertDataMon("AviFort",26.8,75.6);
    }


    private String[] viewAll() {

        Cursor res=mydb.getAllData();
        if(res.getCount()==0){
            //show some message
            showMessage("Error","Nothing Found");
            return null;
        }

        String[] items=new String[10];
        StringBuffer buffer=new StringBuffer();
        int count=0;
        while (res.moveToNext()){
           /* buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");*/
            items[count]=res.getString(1);
          /*  buffer.append("Type :"+ res.getString(2)+"\n");
            buffer.append("Veg :"+ res.getString(3)+"\n");
            buffer.append("Xcor :"+ res.getString(4)+"\n");
            buffer.append("Ycor :"+ res.getString(5)+"\n");*/
            count++;
            if(count==4)
                break;

        }
        return items;
        // showMessage("Data",buffer.toString());
    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
