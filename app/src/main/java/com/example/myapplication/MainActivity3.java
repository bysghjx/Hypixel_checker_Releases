package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button button;
    String id;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        radioGroup = findViewById(R.id.RG_select);
        button = findViewById(R.id.back);
        radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        sp = getSharedPreferences("api_data",0);
        editor = sp.edit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.Rb_Bed_Info:{
                         id ="bw";
                        MainActivity7.select = id;
                        break;
                    }
                    case R.id.Rb_Player_Info:{
                        id = "player";
                        MainActivity7.select = id;
                        break;
                    }
                    case R.id.Rb_Mm_Info:{
                         id = "Mm";
                        MainActivity7.select = id;
                        break;
                    }
                    case R.id.Rb_SkyWars_Info:{
                         id = "SkyWars";
                        MainActivity7.select = id;
                        break;
                    }
                    case R.id.Rb_Duels_Info:{
                         id = "Duel";
                        MainActivity7.select = id;
                        break;
                    }
                    case R.id.Rb_UHC_Info:{
                        id = "UHC";
                        MainActivity7.select = id;
                        break;
                    }
                    default:{
                         id = "player";
                        MainActivity7.select = id;
                        break;
                    }
                }
            }
        });

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this,MainActivity7.class);
            startActivity(intent);
        });


    }
}
