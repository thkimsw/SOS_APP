package com.example.argos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class peoples extends AppCompatActivity {
    TextView t_one,t_two,t_three,name;
    Button add,delete;
    String index = "" , n_phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peoples);

        t_one = findViewById(R.id.t_one);
        t_two = findViewById(R.id.t_two);
        t_three = findViewById(R.id.t_three);
        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n_phone = t_one.getText().toString()+t_two.getText().toString()+t_three.getText().toString();
                index = name.getText().toString();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n_phone = t_one.getText().toString()+t_two.getText().toString()+t_three.getText().toString();
                index = name.getText().toString();
            }
        });

    }
}