package com.oneguycoding.android.geoquiz;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;

	private static final TrueFalse[] sQuestionBank;

	static {
		sQuestionBank = new TrueFalse[]{
				new TrueFalse(R.string.q_oceans, true),
				new TrueFalse(R.string.q_mideast, false),
				new TrueFalse(R.string.q_africa, false),
				new TrueFalse(R.string.q_americas, true),
				new TrueFalse(R.string.q_asia, true),
		};
	}

	private int mCurrentIndex = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);

		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);

		mTrueButton = (Button) findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer(true);
			}
		});
		mFalseButton = (Button) findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer(false);
			}
		});

		mNextButton = (Button)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateQuestion();
			}
		});

		updateQuestion();
	}

	private void updateQuestion() {
		mCurrentIndex = (mCurrentIndex + 1) % sQuestionBank.length;
		int question = sQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}

	private void checkAnswer(boolean userPressedTrue) {
		boolean answerIsTrue = sQuestionBank[mCurrentIndex].isTrueQuestion();

		int messageResId = 0;
		if (userPressedTrue == answerIsTrue) {
			messageResId = R.string.correct_toast;
		} else {
			messageResId = R.string.incorrect_toast;
		}

		Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}
}
