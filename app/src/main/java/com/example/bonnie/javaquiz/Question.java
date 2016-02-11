package com.example.bonnie.javaquiz;

/**
 * Created by Bonnie on 2/08/2016
 */
public class Question {
    private int mTextResId;
    private boolean mAnswer;

public Question(int textResId, boolean answer) {
    mTextResId = textResId;
    mAnswer = answer;
}

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswer;
    }

    public void setAnswerTrue(boolean answer) {
        mAnswer = answer;
    }
}
