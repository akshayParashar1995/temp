package com.kredito;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by akshay on 8/2/16.
 */
public class Signup extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText otpEditText;
    private EditText passwordEditText;
    private EditText promoEditText;
    private TextView termsAndConditionsText;
    private TextInputLayout nameTextInputLayout;
    private TextInputLayout emailTextInputLayout;
    private TextInputLayout passTextInputLayout;
    private TextInputLayout promoTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initialiseFields();

    }

    private void initialiseFields(){
        nameEditText= (EditText) findViewById(R.id.et_name);
        emailEditText= (EditText) findViewById(R.id.et_name);
        phoneEditText= (EditText) findViewById(R.id.et_name);
        otpEditText= (EditText) findViewById(R.id.et_name);
        passwordEditText= (EditText) findViewById(R.id.et_name);
        promoEditText= (EditText) findViewById(R.id.et_promo_code);
        termsAndConditionsText= (TextView) findViewById(R.id.tv_terms_conditions);
        nameTextInputLayout= (TextInputLayout) findViewById(R.id.input_layout_name);
        emailTextInputLayout= (TextInputLayout) findViewById(R.id.input_layout_email);
        passTextInputLayout= (TextInputLayout) findViewById(R.id.input_layout_password);
        promoTextInputLayout= (TextInputLayout) findViewById(R.id.input_layout_promo);

        termsAndConditionsText.setText(Html.fromHtml("By Signing up, you agree to <b> Terms And Conditions </b> of <b><u>Kredito</u><b>"));
//
//        nameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE||actionId == EditorInfo.IME_ACTION_DONE ||
//                        event.getAction() == KeyEvent.ACTION_DOWN &&
//                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//                    if (!event.isShiftPressed()) {
//                        // the user is done typing
//                        Log.i("test", "nchange name");
//
//                        nameTextInputLayout.setHint("Name                     " + Html.fromHtml("<b>Great one!!!</b>"));
//                    }
//                    return true;
//                }
//                return false;
//            }
//        });
//        emailEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE||actionId == EditorInfo.IME_ACTION_DONE ||
//                        event.getAction() == KeyEvent.ACTION_DOWN &&
//                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//                    if (!event.isShiftPressed()) {
//                        Log.i("test", "echange name");
//                        emailTextInputLayout.setHint("Email                   " + Html.fromHtml("<b>hey there</b>"));
//                    }
//                    return true;
//                }
//                return false;
//            }
//        });

//        nameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus&&!nameEditText.getText().toString().equals("")) {
//                    Log.i("test","change name");
//                        nameTextInputLayout.setHint("Name                     " + Html.fromHtml("<i>Great one!!!</i>"));
//                    } else {
//                    Log.i("test","reset name");
//                        nameTextInputLayout.setHint("Name");
//                    }
//            }
//        });
//        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus&&!emailEditText.getText().toString().equals("")) {
//                    Log.i("test","change email");
//                        emailTextInputLayout.setHint("Email                   " + Html.fromHtml("<i>hey there</i>"));
//                    } else {
//                    Log.i("test","reset email");
//                        emailTextInputLayout.setHint("Email");
//                    }
//            }
//        });
//        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    if (!passwordEditText.getText().toString().equals("")) {
//                        Log.i("test","change pass");
//                        passTextInputLayout.setHint("Password                 " + Html.fromHtml("<i>Top Secret :p</i>"));
//                    } else {
//                        Log.i("test","reset pass");
//
//                        passTextInputLayout.setHint("Password");
//                    }
//                }
//            }
//        });
//        promoEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    if (!promoEditText.getText().toString().equals("")) {
//                        Log.i("test","change promo");
//                        promoTextInputLayout.setHint("Promotional Code        " + Html.fromHtml("<i>Congo !!</i>"));
//                    } else {
//                        Log.i("test","reset promo");
//
//                        promoTextInputLayout.setHint("Promotional Code");
//                    }
//                }
//            }
//        });
    }

}
