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
    TextView questionTextView;
    private int currenQuestionIndex = 0;

    private Question[] questionArray = new Question[] {
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonYes = findViewById(R.id.button_true);
        buttonNo = findViewById(R.id.button_false);
        buttonNext = findViewById(R.id.button_next);
        questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questionArray[currenQuestionIndex].getQuestionResId());
        buttonNext.setOnClickListener(this);
        buttonNo.setOnClickListener(this);
        buttonYes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_false:
                Toast.makeText(MainActivity.this,"You've clicked FALSE",Toast.LENGTH_SHORT).show();
            break;

            case R.id.button_true:
                Toast.makeText(MainActivity.this,"You've clicked TRUE",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_next:
                Log.d("CURRENT", "index: "+ currenQuestionIndex);
                questionTextView.setText(questionArray[currenQuestionIndex].getQuestionResId());
                currenQuestionIndex = (currenQuestionIndex+1) % questionArray.length;
                break;

        }
    }
}
