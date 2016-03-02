package com.example.bonnie.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Congrats extends AppCompatActivity {
    private static final String CORRECT_ANSWERS =
            "com.example.bonnie.javaquiz.correct_answers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent congrats = getIntent();
        String correctAnswers = congrats.getStringExtra("correctAnswers");


        TextView tvView = (TextView) findViewById(R.id.results_text_view);

        Intent intent = getIntent();

        tvView.setText("Your name is: " + correctAnswers);
    }
}
