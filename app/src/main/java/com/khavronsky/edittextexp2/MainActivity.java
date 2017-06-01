package com.khavronsky.edittextexp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Booms";

    @BindView(R.id.first_layout)
    View firstLayout;

    @BindView(R.id.second_layout)
    View secondLayout;

    @BindView(R.id.first_radio_btn)
    RadioButton mFirstRadioButton;

    @BindView(R.id.second_radio_btn)
    RadioButton mSecondRadioButton;

    @BindView(R.id.first_edit_text)
    EditText mFirstEditText;

    @BindView(R.id.second_edit_text)
    EditText mSecondEditText;

    @BindView(R.id.recreate_btn)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFirstEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                rbSwitcher(v);
            }
        });
        mSecondEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                rbSwitcher(v);
            }
        });
    }

    @OnClick({R.id.first_layout,
            R.id.second_layout,
            R.id.first_radio_btn,
            R.id.second_radio_btn,
            R.id.first_edit_text,
            R.id.second_edit_text,
            R.id.recreate_btn})
    void rbSwitcher(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.first_layout:
                Log.d(TAG, "first_layout: ");
                mFirstRadioButton.setChecked(true);
                mSecondRadioButton.setChecked(false);
                mFirstEditText.requestFocus();
                mSecondEditText.clearFocus();
                break;
            case R.id.second_layout:
                Log.d(TAG, "second_layout: ");
                mFirstRadioButton.setChecked(false);
                mSecondRadioButton.setChecked(true);

                mFirstEditText.clearFocus();
                mSecondEditText.requestFocus();
                break;
            case R.id.first_radio_btn:
                Log.d(TAG, "first_radio_btn: ");
                mFirstRadioButton.setChecked(true);
                mSecondRadioButton.setChecked(false);
                mFirstEditText.requestFocus();
                mSecondEditText.clearFocus();
                break;
            case R.id.second_radio_btn:
                Log.d(TAG, "second_radio_btn: ");
                mFirstRadioButton.setChecked(false);
                mSecondRadioButton.setChecked(true);
                mFirstEditText.clearFocus();
                mSecondEditText.requestFocus();
                break;
            case R.id.first_edit_text:
                Log.d(TAG, "first_edit_text: ");
                mFirstRadioButton.setChecked(true);
                mSecondRadioButton.setChecked(false);
                break;
            case R.id.second_edit_text:
                Log.d(TAG, "second_edit_text: ");
                mFirstRadioButton.setChecked(false);
                mSecondRadioButton.setChecked(true);
                break;
            case R.id.recreate_btn:
                finish();
                this.startActivity(getIntent());
                break;
        }
    }
}
