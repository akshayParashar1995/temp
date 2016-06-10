package com.example.akshay.warehouse.putaway;

import android.app.Activity;
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
import com.example.akshay.warehouse.models.Product;
import com.example.akshay.warehouse.models.Rtag;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by akshay on 16/12/15.
 */
public class FetchProductsForGivenRtag {


    public interface OnSuccessfulFetchingOfProducts{
        public void onResult();
    }

    public OnSuccessfulFetchingOfProducts delegate=null;

    public void fetchProducts(Rtag rtag, final Context context){
        String url = Constants.BASE_SERVER_URL + "api/receiveproductdetailsall/" + Globals.baseRequest.getUser()
                                + "/" + Globals.baseRequest.getPwd()+ "/" +rtag.getReceiveDetailsID();
        Log.i("url", url);
        PutawaySplashScreen.incrementNoOfVolleyRequests();
        Log.i("volley", "incremented to " + PutawaySplashScreen.noOfVolleyRequests);
        final boolean isCompleted=rtag.getStatus().equals("Completed")?true:false;
        final String title=rtag.getClientCode();
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("products", response.toString());
                        List<Product> products=new ArrayList<Product>();
                        try {

                            for (int i=0;i<response.length();i++) {
                                JSONObject jsonObject = (JSONObject) response.get(i);
                                int ReceiveProductDetailsID=jsonObject.getInt("ReceiveProductDetailsID");
                                String ClientCode=jsonObject.getString("ClientCode");
                                String RTagNo=jsonObject.getString("RTagNo");
                                int ReceiveDetailsID=jsonObject.getInt("ReceiveDetailsID");
                                int ProductMasterID=jsonObject.getInt("ProductMasterID");
                                String BatchNo=jsonObject.getString("BatchNo");
                                String LotNo=jsonObject.getString("LotNo");
                                String BarcodeNo=jsonObject.getString("BarcodeNo");
                                String MFGDate= jsonObject.getString("MFGDate");
                                String EXPDate=jsonObject.getString("EXPDate");
                                int QuantitytoReceive=jsonObject.getInt("QuantitytoReceive");
                                int QuantityReceived=jsonObject.getInt("QuantityReceived");
                                String BarcodeNo1=jsonObject.getString("BarcodeNo1");
                                String CreatedBy=jsonObject.getString("CreatedBy");
                                String CreatedDate=jsonObject.getString("CreatedDate");
                                String ProductCode=jsonObject.getString("ProductCode");
                                String ColdStorage=jsonObject.getString("ColdStorage");
                                String ProductClassCode=jsonObject.getString("ProductClassCode");
                                int ProductClassID=jsonObject.getInt("ProductClassID");
                                String ReceiveStatus=jsonObject.getString("ReceiveStatus");
                                String location=jsonObject.getString("location");
                                Product product=new Product(ReceiveProductDetailsID,ClientCode,RTagNo,ReceiveDetailsID,ProductMasterID,BatchNo,LotNo,
                                                            BarcodeNo,MFGDate,EXPDate,QuantitytoReceive,QuantityReceived,BarcodeNo1,CreatedBy,
                                                            CreatedDate,ProductCode,ColdStorage,ProductClassCode,ProductClassID,ReceiveStatus,
                                                            location,isCompleted,title);

                                products.add(product);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(context, "loaded clients list", Toast.LENGTH_LONG).show();
                        Globals.productsForCurrentlySelelctedRtag=products;
                        PutawaySplashScreen.decrementNoOfVolleyRequests();
                        Log.i("volley", "decremented to " + PutawaySplashScreen.noOfVolleyRequests);
                        delegate.onResult();


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

