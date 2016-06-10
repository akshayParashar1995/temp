package com.example.akshay.warehouse.user_login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.akshay.warehouse.MenuGrid;
import com.example.akshay.warehouse.Utils.AppController;
import com.example.akshay.warehouse.extras.Constants;
import com.example.akshay.warehouse.extras.Globals;
import com.example.akshay.warehouse.requests.BaseRequest;
import com.example.akshay.warehouse.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akshay on 14/12/15.
 */
public class LoginRequest extends Activity {

    private String password, userName;
    private static final String TAG = "Login async";
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        password = (String) getIntent().getExtras().get("Password");
        userName = (String) getIntent().getExtras().get("UserName");
        BaseRequest baseRequest = new BaseRequest(userName, password);
        Globals.baseRequest=baseRequest;
        String url = Constants.BASE_SERVER_URL + "api/login/" + baseRequest.getUser() + "/" + baseRequest.getPwd();
        Log.i("url", url);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Processing Login ...");
        pDialog.show();

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("login", response.toString());
                        try {

                            JSONObject jsonObject = (JSONObject) response.get(0);
                            String userName = jsonObject.getString("UserName");
                            int userId = jsonObject.getInt("UserID");
                            int ClientMasterID=jsonObject.getInt("ClientMasterID");
                            int putaway=jsonObject.getInt("putaway");
                            int predelivery=jsonObject.getInt("predelivery");
                            int picking=jsonObject.getInt("picking");
                            int cyclecount=jsonObject.getInt("cyclecount");
                            User loggedUser=new User(userId,userName,ClientMasterID,putaway,predelivery,picking,cyclecount);

                            Globals.loggedUser=loggedUser;

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(getApplicationContext(),"Welcome "+Globals.loggedUser.getUserName(),Toast.LENGTH_LONG).show();
                        pDialog.hide();
                        Intent i=new Intent();
                        i.setClass(getApplicationContext(), MenuGrid.class);
                        startActivity(i);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Log.i("error", error.getMessage());
                pDialog.hide();

            }
        });
        AppController.getInstance().getRequestQueue().add(req);
    }
}
