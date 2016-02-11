package com.example.bonnie.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonnie on 2/10/2016.
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


}
