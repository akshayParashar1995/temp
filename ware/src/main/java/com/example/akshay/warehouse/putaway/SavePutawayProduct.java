package com.example.akshay.warehouse.putaway;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.akshay.warehouse.Utils.AppController;
import com.example.akshay.warehouse.extras.Constants;
import com.example.akshay.warehouse.requests.SavePutawayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akshay on 20/12/15.
 */
public class SavePutawayProduct {

    private Context context;

    public void saveProduct(SavePutawayRequest savePutawayRequest, final Context context){
        String url= Constants.BASE_SERVER_URL+"api/SavePutaway/"+savePutawayRequest.getUser() +"/"+savePutawayRequest.getPwd()
                        +"/"+ savePutawayRequest.getDetailid() +"/"+ savePutawayRequest.getProductclass() +"/"+
                        savePutawayRequest.getBarcode() +"/"+ savePutawayRequest.getLocation();
        this.context=context;
        PutawaySplashScreen.incrementNoOfVolleyRequests();
        Log.i("volley", "incremented to " + PutawaySplashScreen.noOfVolleyRequests);
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("saving", response.toString());
                        String status="default";
                        try {

                            JSONObject jsonObject = (JSONObject) response.get(0);
                            status = jsonObject.getString("status");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(context, status , Toast.LENGTH_LONG).show();
                        PutawaySplashScreen.decrementNoOfVolleyRequests();
                        Log.i("volley", "decremented to " + PutawaySplashScreen.noOfVolleyRequests);
                        String responseMessage=getDecodedResponseStringFromStatus(status);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("SavePutaway", "Error: " + error.getMessage());
                Log.i("error while saving",""+ error.getMessage());
                PutawaySplashScreen.decrementNoOfVolleyRequests();
                Log.i("volley", "decremented to " + PutawaySplashScreen.noOfVolleyRequests);
            }
        });
        AppController.getInstance().getRequestQueue().add(req);
    }

    private String getDecodedResponseStringFromStatus(String status){

        String response="default";

        if (status.equals("3"))
        {
            Toast.makeText(context,Constants.PRODUCT_CLASS_INCOMPATIBLE , Toast.LENGTH_LONG).show();
            response=Constants.PRODUCT_CLASS_INCOMPATIBLE;
        }
        else if (status.equals("4"))
        {
            Toast.makeText(context, Constants.BARCODE_MATCH_FAILED, Toast.LENGTH_SHORT).show();
            response=Constants.BARCODE_MATCH_FAILED;
        }
        else if (status.equals("0"))
        {
            Toast.makeText(context,Constants.SAVING_FAILED, Toast.LENGTH_SHORT).show();
            response=Constants.SAVING_FAILED;
        }
        else
        {   Toast.makeText(context,Constants.SAVING_SUCCESS, Toast.LENGTH_SHORT).show();
            response=Constants.SAVING_SUCCESS;
        }
        Log.i("saving",response);
        return response;
    }
}
