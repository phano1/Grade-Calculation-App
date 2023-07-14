package com.okiphan.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewGrade;
    private Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize textViewGrade and buttonReturn by finding the respective views in the layout.
        textViewGrade = findViewById(R.id.textViewGrade);
        buttonReturn = findViewById(R.id.buttonReturn);

        // Retrieve the grade value passed from the previous activity using an Intent.
        Intent intent = getIntent();
        String grade = intent.getStringExtra("grade");

        // Set the retrieved grade value to the textViewGrade to display it.
        textViewGrade.setText(grade);

        // Set an OnClickListener for the buttonReturn to handle the click event.
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            // Finish the current activity and return to the previous activity.
            public void onClick(View v) {
                finish();
            }
        });
    }
}
