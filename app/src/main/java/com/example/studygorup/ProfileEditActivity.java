package com.example.studygorup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studygorup.API.RetrofitHelper;
import com.example.studygorup.API.UserAPI;
import com.example.studygorup.DTO.GroupUpdate;
import com.example.studygorup.DTO.ResponseGroupID;
import com.example.studygorup.DTO.myUserUpdate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileEditActivity extends AppCompatActivity implements View.OnClickListener{

    // region 변수선언
    EditText editName, editAge;
    RadioGroup radioGroup;
    Spinner spinner;
    Button btnEdit;
    String[] item = {"초등과정","중등과정","고등과정","대학과정","기타"};
    String strName, strAge, strField, strGender;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        // region 변수연결
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        btnEdit = findViewById(R.id.btnEdit);
        // endregion

        btnEdit.setOnClickListener(this);


        editName.setText(getIntent().getStringExtra("userName"));
        editAge.setText(getIntent().getStringExtra("userAge"));

        spinner.setSelection(getIndex(spinner, strField));

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strField = item[i];
                Log.e("study",strField);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private int getIndex(Spinner spinner, String item) {
        for (int i=0; i<spinner.getCount(); i++){
            if(spinner.getItemAtPosition(i).toString().equalsIgnoreCase(item)){
                return i;
            }
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEdit:
                strAge = editAge.getText().toString();
                strName = editName.getText().toString();
                strField = spinner.getSelectedItem().toString();
                RadioButton rb = findViewById(radioGroup.getCheckedRadioButtonId());
                strGender = rb.getText().toString();
                if(strAge.equals("") || strName.equals("") || strField.equals("")){
                    Toast.makeText(this, "입력되지 않은 칸이 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d("TAG_AN", strName + " " + strAge + " " + strField + " " + strGender);
                    finish();
                }

                UserAPI userAPI = new RetrofitHelper().getUserAPI();
                userAPI.updateUser(
                        new myUserUpdate(strName,
                                strAge,
                                strGender,
                                strField,
                                getIntent().getIntExtra("userID",0))).enqueue(new Callback<ResponseGroupID>() {
                    @Override
                    public void onResponse(Call<ResponseGroupID> call, Response<ResponseGroupID> response) {
                        if (response.isSuccessful()){
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("userID", getIntent().getIntExtra("userID",0));
                            intent.putExtra("userName",getIntent().getStringExtra("userName"));
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseGroupID> call, Throwable t) {

                    }
                });

                break;
        }
    }
}