package com.example.akshay.warehouse.user_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akshay.warehouse.R;

import mehdi.sakout.fancybuttons.FancyButton;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FancyButton blogin;
    private EditText userNameEditText;
    private EditText passwordEditTExt;
    private String password,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEditText= (EditText) findViewById(R.id.user_name_edittext);
        passwordEditTExt=(EditText)findViewById(R.id.password_edittext);
        blogin=(FancyButton)findViewById(R.id.activity_main_blogin);
        blogin.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        password=passwordEditTExt.getText().toString();
        userName=userNameEditText.getText().toString();
        if(password.equals("")||userName.equals("")){
            Toast.makeText(getApplicationContext(),"enter all fields",Toast.LENGTH_LONG).show();
        }
        else{
            Intent i=new Intent();
            i.setClass(getApplicationContext(), LoginRequest.class);
            i.putExtra("Password",password);
            i.putExtra("UserName",userName);
            startActivity(i);
        }

    }
}
