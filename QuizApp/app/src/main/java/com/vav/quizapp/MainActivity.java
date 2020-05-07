package com.vav.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonYes, buttonNo;
    ImageButton buttonNext;
    TextView questionTextView,nextText,totalPoints;
    private int currenQuestionIndex = 0, totalPointsText=0;

    private Question[] questionArray = new Question[] {
            new Question(R.string.question_class, false),
            new Question(R.string.question_oop_invention, true),
            new Question(R.string.question_first_language, false),
            new Question(R.string.question_additional_feature, true),
            new Question(R.string.question_oop_implementation, false),
            new Question(R.string.question_reusability, true),
            new Question(R.string.question_multiple_inheritance, false),
            new Question(R.string.question_oop_rules, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonYes = findViewById(R.id.button_true);
        buttonNo = findViewById(R.id.button_false);
        buttonNext = findViewById(R.id.button_next);
        questionTextView = findViewById(R.id.question_text_view);
        nextText = findViewById(R.id.next_text);
        totalPoints = findViewById(R.id.total_points);
        questionTextView.setText(questionArray[currenQuestionIndex].getQuestionResId());
        totalPoints.setText(String.valueOf(totalPointsText));


        nextText.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        buttonNo.setOnClickListener(this);
        buttonYes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_false:
                    checkAnswer(false);
            break;

            case R.id.button_true:
                    checkAnswer(true);
                break;
            case R.id.button_next: case R.id.next_text:
                currenQuestionIndex = (currenQuestionIndex+1) % questionArray.length;
                updateQuestion();
                if (currenQuestionIndex==0){
                    totalPointsText=0;
                    totalPoints.setText("0");
                }
                break;

        }
    }

    private void updateQuestion(){
        Log.d("CURRENT", "index: "+ currenQuestionIndex);
        questionTextView.setText(questionArray[currenQuestionIndex].getQuestionResId());
    }

    private void checkAnswer(boolean userChoseCorrect){
        boolean answerIsTrue = questionArray[currenQuestionIndex].isAnswerTrue();

        int toastMessageId;
        if (userChoseCorrect == answerIsTrue){
            totalPointsText+=10;
            totalPoints.setText(String.valueOf(totalPointsText));
            toastMessageId = R.string.correct_answer;
        }
        else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }

}
