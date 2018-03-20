package com.example.bhrugvishvakil.tour;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
CustomSwipe customSwipe;
    private GoogleMap mMap;
TextView txt;
EditText rad;
LocationManager locationManager;
Button tour,fair,food,emerg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        customSwipe = new CustomSwipe(this );
        viewPager.setAdapter(customSwipe);
        tour = (Button)findViewById(R.id.tour);
        fair = (Button)findViewById(R.id.fair);
        food = (Button)findViewById(R.id.Food);
        emerg = (Button)findViewById(R.id.Emg);
        rad=(EditText)findViewById(R.id.Result);
        txt=(TextView) findViewById(R.id.textView);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                //instantiate the class latlng
                LatLng latLng = new LatLng(latitude, longitude);
                //instantiate the class, Geocoder
                Geocoder geocoder = new Geocoder(getApplicationContext());
                try {
                    List<Address> addresslist = geocoder.getFromLocation(latitude, longitude, 1);
                    String str = addresslist.get(0).getLocality();
                    txt.setText(str + " Welcomes You !!!!");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });


        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), tour.class);
                i.putExtra("Radius",rad.getText().toString());
                startActivity(i);

            }
        });
        fair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),fair.class);
                startActivity(i);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),food.class);
                startActivity(i);
            }
        });

        emerg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Emergency.class);
                startActivity(i);
            }
        });


    }
}
