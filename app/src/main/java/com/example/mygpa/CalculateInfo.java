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

        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.list_item_calculate_info, R.id.description_text_view, scoresList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_item_calculate_info, parent, false);
                }

                ImageView imageView = convertView.findViewById(R.id.image_view);
                TextView descriptionTextView = convertView.findViewById(R.id.description_text_view);
                TextView scoreTextView = convertView.findViewById(R.id.score_text_view);

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
        } else {
            return new ScoreDescription("Fail (Core Courses); Pass (Elective Courses)", R.drawable.cplus);
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
