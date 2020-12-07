package com.example.studygorup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ProfileEditActivity extends AppCompatActivity implements View.OnClickListener{

    // region 변수선언
    EditText editName, editAge;
    RadioGroup radioGroup;
    Spinner spinner;
    Button btnEdit;

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

        strField = "고등학교 과정";
        strName = "안수빈";
        strAge = "18";

        editName.setText(strName);
        editAge.setText(strAge);
        spinner.setSelection(getIndex(spinner, strField));

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
                break;
        }
    }
}