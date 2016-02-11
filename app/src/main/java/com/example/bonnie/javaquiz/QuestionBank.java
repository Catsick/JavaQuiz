package com.example.bonnie.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonnie on 2/08/2016.
 */
public class QuestionBank {
    public List<Question> mQuestionList = new ArrayList<>();
    public int mCurrentIndex = 0;


    public QuestionBank() {
        mQuestionList.add(new Question(R.string.questionMarshmallow, true));
        mQuestionList.add(new Question(R.string.question_sweets, false));
        mQuestionList.add(new Question(R.string.question_order, true));
        mQuestionList.add(new Question(R.string.question_source, false));
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public void setQuestionList(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        mCurrentIndex = currentIndex;
    }
}
