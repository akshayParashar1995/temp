package com.example.akshay.warehouse.putaway.putaway_search;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.akshay.warehouse.Utils.AppController;
import com.example.akshay.warehouse.extras.Constants;
import com.example.akshay.warehouse.extras.Globals;
import com.example.akshay.warehouse.models.Client;
import com.example.akshay.warehouse.putaway.PutawaySplashScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akshay on 16/12/15.
 */
public class FetchClientsList {
    public static void fetchClientList(final Context context){

        String url = Constants.BASE_SERVER_URL + "api/client/" + Globals.baseRequest.getUser() + "/" + Globals.baseRequest.getPwd();
        Log.i("url", url);

        PutawaySplashScreen.incrementNoOfVolleyRequests();
        Log.i("volley", "incremented to " + PutawaySplashScreen.noOfVolleyRequests);
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("login", response.toString());
                        List<Client> spinnerDropdownList=new ArrayList<Client>();
                        try {

                            for (int i=0;i<response.length();i++) {
                                JSONObject jsonObject = (JSONObject) response.get(i);
                                int ClientMasterID = jsonObject.getInt("ClientMasterID");
                                String ClientCode = jsonObject.getString("ClientCode");
                                int status = jsonObject.getInt("Status");
                                Client client = new Client(ClientMasterID, ClientCode, status);
                                spinnerDropdownList.add(client);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(context, "loaded clients list", Toast.LENGTH_LONG).show();
                        Globals.spinnerClientsList=spinnerDropdownList;
                        PutawaySplashScreen.decrementNoOfVolleyRequests();
                        Log.i("volley", "decremented to " + PutawaySplashScreen.noOfVolleyRequests);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error fetching clients list", "Error: " + error.getMessage());
                Log.i("error", error.getMessage());
                PutawaySplashScreen.decrementNoOfVolleyRequests();
            }
        });
        AppController.getInstance().getRequestQueue().add(req);
    }

}
