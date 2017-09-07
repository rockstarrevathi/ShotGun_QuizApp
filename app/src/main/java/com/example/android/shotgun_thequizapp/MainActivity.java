package com.example.android.shotgun_thequizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * calculate points on submit button clicked
     */
    public void onSubmitCalculatePoints(View v) {
        int points = 0;

        //Get the name of the customer
        TextView customerNameEdit = (TextView) findViewById(R.id.customer_name);
        String name = customerNameEdit.getText().toString();
        /**
         * question 1
         */
        EditText editTextQestion1Answer = (EditText) findViewById(R.id.question1_answer_server);
        String stringAnswer = editTextQestion1Answer.getText().toString();
        boolean correct = "100".equals(stringAnswer);
        if (correct) {
            points++;
        }
        /**
         * question 2
         */
        RadioButton radioButtonQuestion2Answer3 = (RadioButton) findViewById(R.id.question2_answer3);
        if (radioButtonQuestion2Answer3.isChecked()) {
            points++;
        }
        /**
         * question 3
         */
        CheckBox checkBoxQuestion3Answer1 = (CheckBox) findViewById(R.id.question3_answer1);
        CheckBox checkBoxQuestion3Answer2 = (CheckBox) findViewById(R.id.question3_answer2);
        CheckBox checkBoxQuestion3Answer3 = (CheckBox) findViewById(R.id.question3_answer3);
        CheckBox checkBoxQuestion3Answer4 = (CheckBox) findViewById(R.id.question3_answer4);
        if (checkBoxQuestion3Answer1.isChecked() && checkBoxQuestion3Answer2.isChecked() &&
                !(checkBoxQuestion3Answer3.isChecked()) && !(checkBoxQuestion3Answer4.isChecked())) {
            points++;
        }
        /**
         * question 4
         */
        RadioButton radioButtonQuestion4Answer3 = (RadioButton) findViewById(R.id.question4_answer3);
        if (radioButtonQuestion4Answer3.isChecked()) {
            points++;
        }
        /**
         * show score text
         */

        TextView textViewScore = (TextView) findViewById(R.id.text_score);
        textViewScore.setVisibility(View.VISIBLE);
        if (points == 4) {

            Toast.makeText(this, name + " Congratulations!! Way to go :)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, name + " score is: " + points + " out of 4", Toast.LENGTH_SHORT).show();
        }

    }

}
