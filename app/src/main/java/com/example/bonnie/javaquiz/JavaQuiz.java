package com.example.bonnie.javaquiz;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private static final String keyIndex = "index";
    private static final String TAG = "QuizActivity";
    QuestionBank QBank = new QuestionBank();


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()called");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle)called");
        setContentView(R.layout.activity_java_quiz);


        Question currentQuestion;
        if (savedInstanceState != null && savedInstanceState.getInt(keyIndex) > 0) {
            currentQuestion = QBank.getQuestionAtIndex(savedInstanceState.getInt(keyIndex));
        } else {
            currentQuestion = QBank.getNextQuestion();
        }


        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(currentQuestion.getTextResId());
        mFalseButton = (Button) findViewById(R.id.false_button);
        mTrueButton = (Button) findViewById(R.id.true_button);
        setUpQuestion(currentQuestion);

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
                checkIsComplete();
                setUpQuestion(QBank.getNextQuestion());
            }
        });


    }

    public void checkIsComplete(){
        if (QBank.checkIfComplete()){
            Intent congratsIntent = new Intent(JavaQuiz.this, Congrats.class);
            JavaQuiz.this.startActivity(congratsIntent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(keyIndex, QBank.getCurrentIndex());
    }

    private void setUpQuestion(Question currentQuestion) {
        mQuestionTextView.setText(currentQuestion.getTextResId());

        if (currentQuestion.isAnswer()) {
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QBank.getQuestionAtIndex(QBank.getCurrentIndex()).wasAnsweredCorrect = true;
                    checkIsComplete();
                    Toast.makeText(JavaQuiz.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();
                }
            });

            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QBank.getQuestionAtIndex(QBank.getCurrentIndex()).wasAnsweredCorrect = false;
                    checkIsComplete();
                    Toast.makeText(JavaQuiz.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QBank.getQuestionAtIndex(QBank.getCurrentIndex()).wasAnsweredCorrect = false;
                    checkIsComplete();
                    Toast.makeText(JavaQuiz.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();
                }
            });

            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QBank.getQuestionAtIndex(QBank.getCurrentIndex()).wasAnsweredCorrect = true;
                    checkIsComplete();
                    Toast.makeText(JavaQuiz.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

