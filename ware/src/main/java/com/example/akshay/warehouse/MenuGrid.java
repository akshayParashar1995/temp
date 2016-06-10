package com.example.akshay.warehouse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.akshay.warehouse.extras.Globals;
import com.example.akshay.warehouse.putaway.PutAwayList;
import com.example.akshay.warehouse.putaway.PutawaySplashScreen;

public class MenuGrid extends AppCompatActivity implements View.OnClickListener{

    Bitmap bmp1;

    TextView tvputaway, tvpredelivery, tvpicking, tvcyclecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

      //  bmp1 = BitmapFactory.decodeResource(getResources(), R.mipmap.putawayportrait);

       tvputaway=(TextView)findViewById(R.id.activity_menu_tvputaway);
        tvpredelivery=(TextView)findViewById(R.id.activity_menu_tvputpredelivery);
        tvpicking=(TextView)findViewById(R.id.activity_menu_tvpicking);
        tvcyclecount=(TextView)findViewById(R.id.activity_menu_tvcyclecount);
        if(Globals.loggedUser.getPicking()==0)
            tvpicking.setVisibility(View.GONE);
        if(Globals.loggedUser.getPredelivery()==0)
            tvpredelivery.setVisibility(View.GONE);
        if(Globals.loggedUser.getPutaway()==0)
            tvputaway.setVisibility(View.GONE);
        if(Globals.loggedUser.getCyclecount()==0)
            tvcyclecount.setVisibility(View.GONE);
        tvputaway.setOnClickListener(this);
        tvpredelivery.setOnClickListener(this);
        tvpicking.setOnClickListener(this);
        tvcyclecount.setOnClickListener(this);

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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

        switch (v.getId())
        {
            case R.id.activity_menu_tvputaway:
                //putaway

                Intent i=new Intent();
                i.setClass(getApplicationContext(), PutawaySplashScreen.class);
                startActivity(i);
                break;
            case R.id.activity_menu_tvputpredelivery:
                //predelivery

                break;
            case R.id.activity_menu_tvpicking:
                //picking

                break;
            case R.id.activity_menu_tvcyclecount:
                //cyclecount

                break;
        }

    }
}
