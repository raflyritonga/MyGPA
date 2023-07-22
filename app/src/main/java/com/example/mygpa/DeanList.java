package com.example.mygpa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DeanList extends AppCompatActivity {

    ListView listView;
    List<String> studentNameList, studentIdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dean_list);

        listView = findViewById(R.id.list_view);

        studentNameList = new ArrayList<>();
        studentIdList = new ArrayList<>();

        // Add student names and IDs to the lists
        studentNameList.add("Budi");
        studentIdList.add("001");

        studentNameList.add("Anto");
        studentIdList.add("002");

        studentNameList.add("Sari");
        studentIdList.add("003");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_items, R.id.text_view1, studentNameList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_items, parent, false);
                }

                TextView studentNameTextView = convertView.findViewById(R.id.text_view1);
                TextView studentIdTextView = convertView.findViewById(R.id.text_view2);
                ImageView studentImageView = convertView.findViewById(R.id.image_view);

                // Get the student data at the current position
                String studentName = studentNameList.get(position);
                String studentId = studentIdList.get(position);

                // Set the student data to the respective views
                studentNameTextView.setText(studentName);
                studentNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

                studentIdTextView.setText(studentId);
                studentNameTextView.setTextColor(Color.parseColor("#2743FD"));
                studentImageView.setImageResource(R.drawable.default_image); // Set the fixed image here

                return convertView;
            }
        };
        listView.setAdapter(adapter);
    }
}