package com.example.bonnie.javaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JavaQuiz extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mQuestionTextView;
    private int QuestionBank;




    QuestionBank QBank = new QuestionBank();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_quiz);

        Question currentQuestion = QBank.getNextQuestion();
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(currentQuestion.getTextResId());
        mFalseButton = (Button) findViewById(R.id.false_button);
        mTrueButton = (Button) findViewById(R.id.true_button);

        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpQuestion(QBank.getPreviousQuestion());
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpQuestion(QBank.getNextQuestion());
            }
        });
    }
    private void setUpQuestion(Question currentQuestion)
        {
            mQuestionTextView.setText(currentQuestion.getTextResId());

            if(currentQuestion.isAnswer()) {

                mTrueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(JavaQuiz.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                });

                mFalseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(JavaQuiz.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{

                mTrueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(JavaQuiz.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                });

                mFalseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(JavaQuiz.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
}

