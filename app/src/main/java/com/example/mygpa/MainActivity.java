package com.example.mygpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calcBtn, deanBtn, allCoursesBtn, insertBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, CalculateInfo.class);
                startActivity(intent);
            }
        });

        deanBtn = findViewById(R.id.deanBtn);
        deanBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, DeanList.class);
                startActivity(intent);
            }
        });

        allCoursesBtn = findViewById(R.id.allCoursesBtn);
        allCoursesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, AllCourses.class);
                startActivity(intent);
            }
        });

        insertBtn = findViewById(R.id.insertBtn);
        insertBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, InsertGrade.class);
                startActivity(intent);
            }
        });
    }
}