package com.oneguycoding.android.geoquiz;

/**
 * Created by steeve on 10/31/15.
 */
public class TrueFalse {
	private int mQuestion;
	private boolean mTrueQuestion;

	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}
}
