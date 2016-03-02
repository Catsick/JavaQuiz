package com.example.bonnie.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonnie on 2/08/2016 commit for later pull
 */
public class QuestionBank {
    public List<Question> mQuestionList = new ArrayList<>();
    public int mCurrentIndex = -1;



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
    public Question getQuestionAtIndex(int index){
        mCurrentIndex=index;
        return mQuestionList.get(index);
    }

    protected int correctQues() {
        int mResults=0;
        for (Question item : mQuestionList){
            if (item.wasAnsweredCorrect){
              mResults ++;
            }
        }
        return mResults;
    }
}
