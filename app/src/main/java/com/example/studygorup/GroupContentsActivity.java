package com.example.studygorup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class GroupContentsActivity extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback, View.OnClickListener{

    GoogleMap mMap;
    LatLng latLng;
    Marker gMarker = null;

    Geocoder geocoder;
    List<Address> listAddress;
    Address address;

    String strAddress;

    // region 변수 선언
    TextView textDue, textTitle, textInfo, textTag;
    Button btnApplay;
    //endregion

    String strDue, strTitle, strInfo, strTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_contents);

        //region 변수 연결
        textDue = findViewById(R.id.textDue);
        textTitle = findViewById(R.id.textTitle);
        textInfo = findViewById(R.id.textInfo);
        textTag = findViewById(R.id.textTag);
        btnApplay = findViewById(R.id.btnGroupApplay);
        //endregion

        /*
        textDue.setText(strDue);
        textTitle.setText(strTitle);
        textInfo.setText(strInfo);
        textTag.setText(strTag);
         */

        btnApplay.setOnClickListener(this);

        strAddress = "광주광역시 광산구 목련로";

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGroupApplay:
                Toast.makeText(this, "참가 신청 했습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        setDefaultLocation();

        geocoder = new Geocoder(this);

        try {
            listAddress = geocoder.getFromLocationName(strAddress, 10);
            address = listAddress.get(0);
            latLng = new LatLng(address.getLatitude(), address.getLongitude());
            Log.d("TAG_AN", latLng.toString()+" "+address.getPremises());

            setCurrentLocation(latLng, strAddress, "스터디 그룹 이름");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setDefaultLocation() {
        LatLng DEFAULT_LOCATION = new LatLng(37.56, 126.97);
        String markerTitle = "위치정보 가져올 수 없음";
        String markerSnippet = "위치 퍼미션과 GPS 활성 요부 확인하세요";


        if (gMarker != null) gMarker.remove();

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(DEFAULT_LOCATION);
        markerOptions.title(markerTitle);
        markerOptions.snippet(markerSnippet);
        markerOptions.draggable(true);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        gMarker = mMap.addMarker(markerOptions);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 15);
        mMap.moveCamera(cameraUpdate);
    }

    public void setCurrentLocation(LatLng latLng, String markerTitle, String markerSnippet) {


        if (gMarker != null) gMarker.remove();


        LatLng gLatLng = latLng;

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(gLatLng);
        markerOptions.title(markerTitle);
        markerOptions.snippet(markerSnippet);
        markerOptions.draggable(true);


        gMarker = mMap.addMarker(markerOptions);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(gLatLng);
        mMap.moveCamera(cameraUpdate);

    }
}