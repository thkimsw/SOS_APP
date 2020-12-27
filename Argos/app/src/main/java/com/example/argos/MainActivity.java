package com.example.argos;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private GpsTracker gpsTracker;
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    Button emergency,setting,submit,kakao;
    Switch c_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gpsTracker = new GpsTracker(MainActivity.this);
        //thread 가속도 센서
        emergency = findViewById(R.id.emergency);
        setting = findViewById(R.id.setting);
        c_state = findViewById(R.id.c_state);
        submit = findViewById(R.id.submit);
        kakao = findViewById(R.id.kakao);

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //비상벨
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //비상연락망 세팅
                Intent set = new Intent(getApplication(),peoples.class);
                startActivity(set);
            }
        });

        c_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // on,off
                //지속적 위치정보 보내기
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //긴급신고

                String message = "보낼 내용";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("sms_body", message );
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);

            }
        });
        kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "보낼 내용";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message );
                intent.setPackage("com.kakao.talk");
                startActivity(intent);
            }
        });
    }
}