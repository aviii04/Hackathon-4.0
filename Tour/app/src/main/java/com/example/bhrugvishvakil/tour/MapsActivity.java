package com.example.bhrugvishvakil.tour;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {




    private GoogleMap mMap;
    LocationManager locationManager;
    LocationDb mydb;
String radius;
    double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mydb = new LocationDb(this);

        Intent i = getIntent();
        radius = i.getStringExtra("Radius");
        Toast.makeText(getApplicationContext(), radius, Toast.LENGTH_LONG).show();
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
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {


            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    //instantiate the class latlng
                    LatLng latLng = new LatLng(latitude, longitude);
                    //instantiate the class, Geocoder
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresslist = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addresslist.get(0).getLocality() + " , " + addresslist.get(0).getAddressLine(0);
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
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
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
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
                        str = str + " " + addresslist.get(0).getCountryName();
                        str = str + " " + addresslist.get(0).getLocality();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
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
        }

        //====================================================
        Cursor pointer = mydb.SearchData();
        int count = pointer.getCount();
        String y = new String();
        Toast.makeText(MapsActivity.this, "Table " + Integer.toString(count), Toast.LENGTH_LONG).show();
        while (pointer.moveToNext()) {
            //x = Double.toString(pointer.getDouble(2));
            //y=pointer.getString(1);
            Toast.makeText(MapsActivity.this, y, Toast.LENGTH_LONG).show();
            if (!findRange(pointer.getDouble(2), pointer.getDouble(3))) {
                LatLng latLng = new LatLng(pointer.getDouble(2), pointer.getDouble(3));
                mMap.addMarker(new MarkerOptions().position(latLng).title("Destination"));
            }
            // }

            //=================================================
            // double alatitude=latitude,alongitude=longitude;


            //boolean result=findRange(alatitude,alongitude);
            //Toast.makeText(MapsActivity.this,Boolean.toString(result),Toast.LENGTH_LONG).show();
        }
    }
    boolean findRange(double alat,double alon){

        float dist= (float)Math.acos(Math.sin(Math.toRadians(latitude))*Math.sin(Math.toRadians(alat))+Math.cos(Math.toRadians(latitude))*Math.cos(Math.toRadians(alat))*Math.cos(Math.toRadians(longitude)-Math.toRadians(alon)))*6371;
        Toast.makeText(MapsActivity.this,Float.toString(dist),Toast.LENGTH_LONG).show();
        //Toast.makeText(MapsActivity.this,Double.toString(lat),Toast.LENGTH_LONG).show();

        // float distanceInMeters = results[0];
        // boolean isWithin10km = distanceInMeters <= 10000;
        boolean isWithin10km = dist <= Float.parseFloat(radius);
        return isWithin10km;


    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

    }
}
