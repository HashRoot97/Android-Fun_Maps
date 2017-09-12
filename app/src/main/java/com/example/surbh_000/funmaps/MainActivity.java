package com.example.surbh_000.funmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,View.OnClickListener {
    GoogleMap googleMap;
    boolean mapReady=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMap=(Button)findViewById(R.id.btnMap);
        Button btnHybrid=(Button)findViewById(R.id.btnHybrid);
        Button btnSatellite=(Button)findViewById(R.id.btnSatellite);
        btnMap.setOnClickListener(this);
        btnHybrid.setOnClickListener(this);
        btnSatellite.setOnClickListener(this);
        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady=true;
        googleMap=map;
        LatLng Delhi=new LatLng(40.7484,-73.5837);
        CameraPosition target=CameraPosition.builder().target(Delhi).zoom(14).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public void onClick(View view) {
        if(mapReady){
            if(view.getId()==R.id.btnMap)googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            if(view.getId()==R.id.btnSatellite)googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            if(view.getId()==R.id.btnHybrid)googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }
    }
}
