package com.example.bonnie.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonnie on 2/08/2016 commit for later pull
 */
public class QuestionBank {
    private List<Question> mQuestionList = new ArrayList<>();
    private int mCurrentIndex = -1;


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

    public Question getNextQuestion(){
        if (mCurrentIndex < mQuestionList.size()-1) {
            mCurrentIndex++;
        }
        return mQuestionList.get(mCurrentIndex);
    }
    public Question getPreviousQuestion(){
        if (mCurrentIndex > 0) {
            mCurrentIndex--;
        }
        return mQuestionList.get(mCurrentIndex);
    }
}
