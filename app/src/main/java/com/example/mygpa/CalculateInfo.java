package com.example.mygpa;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CalculateInfo extends AppCompatActivity {

    ListView listView;
    List<String> scoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_info);

        listView = findViewById(R.id.list_view);

        scoresList = new ArrayList<>();
        scoresList.add("90 - 100");
        scoresList.add("80 - 89");
        scoresList.add("75 - 79");
        scoresList.add("70 - 74");
        scoresList.add("65 - 69");
        scoresList.add("60 - 64");
        scoresList.add("55 - 59");
        scoresList.add("50 - 54");
        scoresList.add("47 - 49");
        scoresList.add("44 - 46");
        scoresList.add("40 - 43");
        scoresList.add("30 - 39");
        scoresList.add("0 - 29");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.list_items, R.id.text_view2, scoresList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_items, parent, false);
                }

                ImageView imageView = convertView.findViewById(R.id.image_view);
                TextView scoreTextView = convertView.findViewById(R.id.text_view1);
                TextView descriptionTextView = convertView.findViewById(R.id.text_view2);

                String scoreRange = scoresList.get(position);
                ScoreDescription scoreDescription = getScoreDescription(scoreRange);

                imageView.setImageResource(scoreDescription.getImageResourceId());
                descriptionTextView.setText(scoreDescription.getDescription());
                scoreTextView.setText(scoreRange);

                return convertView;
            }
        };

        listView.setAdapter(adapter);
    }

    private ScoreDescription getScoreDescription(String scoreRange) {
        if (scoreRange.equals("90 - 100")) {
            return new ScoreDescription("Pass with distinction", R.drawable.aplus);
        } else if (scoreRange.equals("80 - 89")) {
            return new ScoreDescription("Pass with distinction", R.drawable.a);
        } else if (scoreRange.equals("75 - 79")) {
            return new ScoreDescription("Pass with credit", R.drawable.aminus);
        } else if (scoreRange.equals("70 - 74")) {
            return new ScoreDescription("Satisfactory Pass", R.drawable.bplus);
        } else if (scoreRange.equals("65 - 69")) {
            return new ScoreDescription("Satisfactory Pass", R.drawable.b);
        } else if (scoreRange.equals("60 - 64")) {
            return new ScoreDescription("Fail (Core Courses); Pass (Elective Courses)", R.drawable.bminus);
        } else if (scoreRange.equals("55 - 59")) {
            return new ScoreDescription("Fail (Core Courses); Pass (Elective Courses)", R.drawable.cplus);
        } else if (scoreRange.equals("50 - 54")) {
            return new ScoreDescription("Fail (Core Courses); Pass (Elective Courses)", R.drawable.c);
        } else if (scoreRange.equals("47 - 49")) {
            return new ScoreDescription("Fail", R.drawable.cminus);
        } else if (scoreRange.equals("44 - 46")) {
            return new ScoreDescription("Fail", R.drawable.dplus);
        } else if (scoreRange.equals("40 - 43")) {
            return new ScoreDescription("Fail", R.drawable.d);
        } else if (scoreRange.equals("30 - 39")) {
            return new ScoreDescription("Fail", R.drawable.e);
        } else {
            return new ScoreDescription("Fail", R.drawable.f);
        }
    }

    private static class ScoreDescription {
        private String description;
        private int imageResourceId;

        public ScoreDescription(String description, int imageResourceId) {
            this.description = description;
            this.imageResourceId = imageResourceId;
        }

        public String getDescription() {
            return description;
        }
        public int getImageResourceId() {
            return imageResourceId;
        }
    }
}
