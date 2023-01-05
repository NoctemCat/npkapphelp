package com.example.npkapp;

import static com.example.npkapp.HomeActivity.getResId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.npkapp.detail.DetailActivity;

public class NumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nums);

        for (int i = 0; i < 33; i++){
            int btnId = getResId("num"+ i +"_btn", R.id.class);

            if(btnId == -1){
                continue;
            }
            Button btnTemp = findViewById(btnId);
            int btnIndex = i;
            btnTemp.setOnClickListener(view -> {
                Intent intent = new Intent(NumsActivity.this, DetailActivity.class);

                intent.putExtra("btnIndex", btnIndex);
                intent.putExtra("typeDetail", "num");
                startActivity(intent);
            });
        }
    }
}