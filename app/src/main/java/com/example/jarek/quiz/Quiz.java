package com.example.jarek.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.LinkedList;

public class Quiz extends AppCompatActivity {

    private LinkedList<Integer> correctAnswersIDs;
    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        score = 0;
        correctAnswersIDs = new LinkedList<>();
        Button scoreButton = (Button) findViewById(R.id.showScore);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scoreText = "Wynik: " + getScore().toString();
                Toast.makeText(getApplicationContext(),scoreText,Toast.LENGTH_LONG)
                        .show();
            }
        });
        correctAnswersIDs.add(R.id.Londyn);
        correctAnswersIDs.add(R.id.NY);
        correctAnswersIDs.add(R.id.Sydney);
        correctAnswersIDs.add(R.id.Kair);
        correctAnswersIDs.add(R.id.Paryz);
    }

    public Integer getScore() {
        score = 0;
        for (Integer id : correctAnswersIDs) {
            if (((RadioButton) findViewById(id)).isChecked())
                score++;
        }
        return score;
    }
}