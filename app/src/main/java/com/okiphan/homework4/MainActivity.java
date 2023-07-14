package com.okiphan.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextScore1;
    private EditText editTextScore2;
    private RadioGroup radioGroupStudentType;
    private Button buttonCalculateGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextScore1 = findViewById(R.id.editTextScore1);
        editTextScore2 = findViewById(R.id.editTextScore2);
        radioGroupStudentType = findViewById(R.id.radioGroupStudentType);
        buttonCalculateGrade = findViewById(R.id.buttonCalculateGrade);

        // Set click listener for the button
        buttonCalculateGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        // Get scores from EditText fields
        double score1 = Double.parseDouble(editTextScore1.getText().toString());
        double score2 = Double.parseDouble(editTextScore2.getText().toString());

        double total;
        RadioButton radioButton = findViewById(radioGroupStudentType.getCheckedRadioButtonId());
        String studentType = radioButton.getText().toString();

        // Calculate total based on student type
        if (studentType.equals("Undergraduate")) {
            total = score1 * 0.3 + score2 * 0.7;
        } else {
            total = score1 * 0.5 + score2 * 0.5;
        }

        String grade;

        // Determine the grade based on the total
        if (total >= 90) {
            grade = "A";
        } else if (total >= 80) {
            grade = "B";
        } else if (total >= 70) {
            grade = "C";
        } else if (total >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Clear the EditText fields
        editTextScore1.setText("");
        editTextScore2.setText("");

        // Start the ResultActivity and pass the grade
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("grade", grade);
        startActivity(intent);
    }
}
