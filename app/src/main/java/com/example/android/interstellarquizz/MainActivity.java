package com.example.android.interstellarquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String badAnswers = "";
    String errors = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void printResults (View view){
        EditText nameBox = (EditText) findViewById(R.id.nameField);
        String name = nameBox.getText().toString();
        if (name.equals("")) {
            Toast toast = Toast.makeText(this, "You forget to give your name traveler", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        //these methods check the answers

        questionOne();
        questionTwo();
        questionThree();
        questionFour();

        name += " you scored: " + score;
        displayText(name);

    }

    /**
     * This method checks if question one is correct or incorrect.
     * If it is correct it adds +1 to a score if not it adds information
     * to variable badAnswers about bad answer. If nothing is selected it adds
     * information to variable errors that nothing is selected in question 1.
     */

    private void questionOne(){

        // Is the button now checked?
        RadioButton qOneA1 = (RadioButton) findViewById(R.id.q1Answer1);
        boolean q1Answer1 = qOneA1.isChecked();
        RadioButton qOneA2 = (RadioButton) findViewById(R.id.q1Answer2);
        boolean q1Answer2 = qOneA2.isChecked();
        RadioButton qOneA3 = (RadioButton) findViewById(R.id.q1Answer3);
        boolean q1Answer3 = qOneA3.isChecked();

        if (q1Answer1) score ++;
            else if (q1Answer2) badAnswers += "Wrong answer in question 1. ";
                else if (q1Answer3) badAnswers += "Wrong answer in question 1. ";
                    else errors += "You didn't check your answer in question 1. ";
    }

    /**
     * This method checks if question two is correct or incorrect.
     * If it is correct it adds +1 to a score if not it adds information
     * to variable badAnswers about bad answer. If nothing is selected it adds
     * information to variable errors that nothing is selected in question 2.
     */

    private void questionTwo(){

        // Is the button now checked?
        RadioButton qTwoA1 = (RadioButton) findViewById(R.id.q2Answer1);
        boolean q2Answer1 = qTwoA1.isChecked();
        RadioButton qTwoA2 = (RadioButton) findViewById(R.id.q2Answer2);
        boolean q2Answer2 = qTwoA2.isChecked();
        RadioButton qTwoA3 = (RadioButton) findViewById(R.id.q2Answer3);
        boolean q2Answer3 = qTwoA3.isChecked();

        if (q2Answer1) badAnswers += "Wrong answer in question 2. ";
        else if (q2Answer2) badAnswers += "Wrong answer in question 2. ";
        else if (q2Answer3)  score ++;
        else errors += "You didn't check your answer in question 2. ";
    }

    /**
     * This method checks which of CheckBoxes are checked. Then it takes
     * this information and checks if the correct combination of CheckBoxes
     * was chosen. If so it adds one point to variable score. If not it
     * adds information about wrong answer to variable badAnswers.
     * If nothing is chosen it adds information to variable errors
     * that nothing was chosen.
     */

    private void questionThree(){
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        boolean check1 = checkBox1.isChecked();
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean check2 = checkBox2.isChecked();
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        boolean check3 = checkBox3.isChecked();

        if (check1 && check2 && !check3) score++;
        //if nothing is selected
        else if (!check1&&!check2&&!check3) errors += "You didn't check your answer in question 3. ";
        else badAnswers += "Wrong answer in question 3. ";
    }

    /**
     * This method checks if question two is correct or incorrect.
     * If it is correct it adds +1 to a score if not it adds information
     * to variable badAnswers about bad answer. If nothing is selected it adds
     * information to variable errors that nothing is selected in question 2.
     */

    private void questionFour(){

        // Is the button now checked?
        RadioButton qFourA1 = (RadioButton) findViewById(R.id.q4Answer1);
        boolean q4Answer1 = qFourA1.isChecked();
        RadioButton qFourA2 = (RadioButton) findViewById(R.id.q4Answer2);
        boolean q4Answer2 = qFourA2.isChecked();
        RadioButton qFourA3 = (RadioButton) findViewById(R.id.q4Answer3);
        boolean q4Answer3 = qFourA3.isChecked();

        if (q4Answer1) badAnswers += "Wrong answer in question 4. ";
        else if (q4Answer2) score ++;
        else if (q4Answer3) badAnswers += "Wrong answer in question 4. ";
        else errors += "You didn't check your answer in question 4. ";
    }

    private void displayText(String name){
        TextView finalScore = (TextView) findViewById(R.id.results);

        if (badAnswers.equals("") && errors.equals("")) {
            String perfect = "PERFECT SCORE!";
            Toast toast = Toast.makeText(this, perfect, Toast.LENGTH_SHORT);
            toast.show();
            finalScore.setText(name);
        }
        else {
            Toast toast = Toast.makeText(this, badAnswers + errors, Toast.LENGTH_LONG);
            toast.show();
            finalScore.setText(name);
        }

        badAnswers = "";
        errors= "";
        score = 0;

    }


}
