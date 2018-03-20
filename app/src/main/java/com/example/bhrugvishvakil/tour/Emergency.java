package com.example.bhrugvishvakil.tour;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Emergency extends AppCompatActivity {
    TextView Police2, Hospital2, Fire2, Medical2, Ambulance2;
    Button Police1, Hospital1, Fire1, Medical1, Ambulance1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        Police2 = (TextView) findViewById(R.id.Police);
        Hospital2 = (TextView) findViewById(R.id.Hospital);
        Fire2= (TextView) findViewById(R.id.Fire);
        Ambulance2 = (TextView) findViewById(R.id.Ambulance);
        Medical2 = (TextView) findViewById(R.id.Medical);
        Police1 = (Button) findViewById(R.id.Police1);
        Hospital1 = (Button) findViewById(R.id.Hospital1);
        Fire1 = (Button) findViewById(R.id.Fire1);
        Ambulance1 = (Button) findViewById(R.id.Ambulance1);

        Medical1 = (Button) findViewById(R.id.Medical1);
        Police2.setText("Gandhi Circle,Talvandi");
        Fire2.setText("Main Road,Bais Godam");
        Hospital2.setText("Near SMS stadium,Tonk Rd");
        Medical2.setText("A-27,Royal Medical Store");
        Ambulance2.setText("Ambulance");
        Police1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phno = "100";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phno,null));
                startActivity(i);
            }
        });
        Hospital1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phno = "7021723668";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phno,null));
                startActivity(i);
            }
        });
        Fire1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phno = "101";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phno,null));
                startActivity(i);
            }
        });
        Ambulance1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phno = "1298";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phno,null));
                startActivity(i);
            }
        });
        Medical1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phno = "7021723668";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phno,null));
                startActivity(i);
            }
        });

    }
}
