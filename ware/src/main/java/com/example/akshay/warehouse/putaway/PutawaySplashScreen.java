package com.example.akshay.warehouse.putaway;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.akshay.warehouse.MenuGrid;
import com.example.akshay.warehouse.putaway.putaway_search.FetchClientsList;
import com.example.akshay.warehouse.requests.RtagRequest;

/**
 * Created by akshay on 16/12/15.
 */
public class PutawaySplashScreen extends Activity {

    public static int noOfVolleyRequests = 0;

    public static void incrementNoOfVolleyRequests() {
        noOfVolleyRequests++;
    }

    public static void decrementNoOfVolleyRequests() {
        noOfVolleyRequests--;
    }
    private final String TAG="putaway_splash_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noOfVolleyRequests=0;
        RtagRequest defaultRtagSearchRequst=new RtagRequest(0,0,"0","15-10-2015","15-12-2015",0,0);
        FetchingFilteredRtags.fetchRtags(getApplicationContext(),defaultRtagSearchRequst,TAG);
        FetchClientsList.fetchClientList(getApplicationContext());
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    Log.i("Sleeping","here2");
                    while (noOfVolleyRequests != 0) {
                        sleep(300);
                        Log.i("Sleeping","here");
                    }
                } catch (InterruptedException e) {
                        Log.i("screen","interruptedException");
                } finally {

                    Intent i=new Intent();
                    i.setClass(getApplicationContext(), PutAwayList.class);
                    startActivity(i);
                }
            }
        };
        splashTread.start();
    }
}