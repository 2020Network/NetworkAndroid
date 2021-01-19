package com.example.studygorup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studygorup.API.GroupAPI;
import com.example.studygorup.API.RetrofitHelper;
import com.example.studygorup.DTO.GroupUpdate;
import com.example.studygorup.DTO.JoinGroup;
import com.example.studygorup.DTO.ResponseGroupID;
import com.example.studygorup.DTO.ResponseMygroup;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupContentsActivity extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback{

    GoogleMap mMap;
    LatLng latLng;
    Marker gMarker = null;

    Geocoder geocoder;
    List<Address> listAddress;
    Address address;

    String strAddress;

    // region 변수 선언
    TextView textDue, textTitle, textInfo, textTag;
    TextView btnApplay;
    TextView cancel;
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
        cancel = findViewById(R.id.cancel);
        //endregion
        String age1 = getIntent().getStringExtra("groupAge1");
        String age2 = getIntent().getStringExtra("groupAge2");
        String gender = getIntent().getStringExtra("groupGender");

        textTitle.setText(getIntent().getStringExtra("groupTitle"));
        textInfo.setText(getIntent().getStringExtra("groupContent"));
        textTag.setText("나이 :" + age2 + "세 이상" + age1 + "세 미만 성별 : " + gender);

        /*btnApplay.setOnClickListener(this);
        GroupAPI groupAPI = new RetrofitHelper().getGroupAPI();
        groupAPI.yougroup(getIntent().getIntExtra("groupID",0)).enqueue(new Callback<ResponseMygroup>() {
            @Override
            public void onResponse(Call<ResponseMygroup> call, Response<ResponseMygroup> response) {
                if (response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<ResponseMygroup> call, Throwable t) {

            }
        });*/
        strAddress = getIntent().getStringExtra("groupLocation");

        btnApplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupAPI groupAPI = new RetrofitHelper().getGroupAPI();
                Log.d("userID", String.valueOf(getIntent().getIntExtra("userID",0)));
                Log.d("groupID",String.valueOf(getIntent().getIntExtra("groupID",0)));
                Log.d("userName",getIntent().getStringExtra("userName"));
                groupAPI.groupJoin(new JoinGroup(getIntent().getIntExtra("userID",0),getIntent().getIntExtra("groupID",0),getIntent().getStringExtra("userName"))).enqueue(new Callback<ResponseGroupID>() {
                    @Override
                    public void onResponse(Call<ResponseGroupID> call, Response<ResponseGroupID> response) {
                        if (response.isSuccessful()){
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("userID",getIntent().getIntExtra("userID",0));
                            Toast.makeText(getApplicationContext(),"참가신청 완료",Toast.LENGTH_SHORT).show();
                            intent.putExtra("userName",getIntent().getStringExtra("userName"));
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseGroupID> call, Throwable t) {
                        Log.e("error",t.toString());
                    }
                });
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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