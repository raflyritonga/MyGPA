package com.example.mygpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InsertGrade extends AppCompatActivity {

    Spinner spinnerGrade;
    List<String> gradeList;
    EditText editSemester, editCourseCode;
    Button submitBtn;
    double gradeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_grade);

        editSemester = findViewById(R.id.editSemester);
        editCourseCode = findViewById(R.id.editCourseCode);
        submitBtn = findViewById(R.id.submitBtn);
        spinnerGrade = findViewById(R.id.spinnerGrade);


        gradeList = new ArrayList<>();
        gradeList.add("A+");
        gradeList.add("A");
        gradeList.add("A-");
        gradeList.add("B+");
        gradeList.add("B");
        gradeList.add("B-");
        gradeList.add("C+");
        gradeList.add("C");
        gradeList.add("C-");
        gradeList.add("D+");
        gradeList.add("D");
        gradeList.add("E");
        gradeList.add("F");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_dropdown_item, gradeList);
        spinnerGrade.setAdapter(adapter);

        spinnerGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
	            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
                String grade = gradeList.get(position);

                switch (grade){
                    case "A+":
                        gradeValue = 4.00;
                        break;
                    case "A":
                        gradeValue = 4.00;
                        break;
                    case "A-":
                        gradeValue = 3.67;
                        break;
                    case "B+":
                        gradeValue = 3.33;
                        break;
                    case "B":
                        gradeValue = 3.00;
                        break;
                    case "B-":
                        gradeValue = 2.67;
                        break;
                    case "C+":
                        gradeValue = 2.33;
                        break;
                    case "C":
                        gradeValue = 2.00;
                        break;
                    case "C-":
                        gradeValue = 1.67;
                        break;
                    case "D+":
                        gradeValue = 1.33;
                        break;
                    case "D":
                        gradeValue = 1.00;
                        break;
                    case "E":
                        gradeValue = 0.67;
                        break;
                    case "F":
                        gradeValue = 0;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {}
        });

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                String semesterStr = editSemester.getText().toString().trim();
                int semester = Integer.parseInt(semesterStr);
                String courseCode = editCourseCode.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "Semester: " + semester + " course code: " + courseCode + " score: " + gradeValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}