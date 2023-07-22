package com.example.mygpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class AllCourses extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    List<String> courseNameList, courseCodeList ;
    List<Integer> courseCreditsList, courseSemList;
    ArrayAdapter<String> adapter; // Move the adapter declaration to class level

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);

        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);

        courseNameList = new ArrayList<>();
        courseCodeList = new ArrayList<>();
        courseSemList = new ArrayList<>();
        courseCreditsList = new ArrayList<>();

        courseNameList.add("Software Engineering");
        courseCodeList.add("CSC577");
        courseSemList.add(4);
        courseCreditsList.add(3);

        courseNameList.add("Mobile App Development");
        courseCodeList.add("CSC557");
        courseSemList.add(4);
        courseCreditsList.add(3);

        courseNameList.add("Object Oriented Programming");
        courseCodeList.add("CSC557");
        courseSemList.add(4);
        courseCreditsList.add(3);

        adapter = new ArrayAdapter<String>(this, R.layout.list_courses, R.id.courseName, courseNameList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_courses, parent, false);
                }

                TextView courseNameTextView = convertView.findViewById(R.id.courseName);
                TextView descriptionTextView = convertView.findViewById(R.id.courseDescription);
                TextView creditsTextView = convertView.findViewById(R.id.courseCredits);

                // Get the student data at the current position
                String courseName = courseNameList.get(position);
                String courseCode = courseCodeList.get(position);
                String courseSem = courseSemList.get(position).toString();
                String courseCredit = courseCreditsList.get(position).toString();

                // Set the student data to the respective views
                courseNameTextView.setText(courseName);
                descriptionTextView.setText(courseCode + " - Semester " + courseSem);
                creditsTextView.setText(courseCredit);

                return convertView;
            }
        };
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the query text submit if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true; // Change to true to indicate the event has been consumed
            }
        });
    }
}