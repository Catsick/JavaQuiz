package com.example.bonnie.javaquiz;

/**
 * Created by Bonnie on 2/08/2016. commit for later pull.
 */
public class Question {
    private int mTextResId;
    private boolean mAnswer;
    public boolean wasAnsweredCorrect;

public Question(int textResId, boolean answer) {
    mTextResId = textResId;
    mAnswer = answer;
    boolean wasAnsweredCorrect = false;
}

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswerTrue(boolean answer) {
        mAnswer = answer;
    }
}
