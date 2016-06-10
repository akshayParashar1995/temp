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
    import com.example.akshay.warehouse.extras.Globals;
    import com.example.akshay.warehouse.models.Client;
    import com.example.akshay.warehouse.models.Rtag;
    import com.example.akshay.warehouse.putaway.putaway_search.CustomClientSpinnerAdapter;
    import com.example.akshay.warehouse.requests.RtagRequest;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.ArrayList;
    import java.util.List;

    /**
     * Created by akshay on 15/12/15.
     */
    public class FetchingFilteredRtags {

        public interface AsyncResponse {
            void processFinish();
        }
        public static AsyncResponse delegate=null;

        public static void fetchRtags(final Context context,RtagRequest rtagRequest, final String TAG){
            final List<Rtag> rtags =new ArrayList<Rtag>();
            String url = Constants.BASE_SERVER_URL + "api/rtag/" + Globals.baseRequest.getUser() + "/" + Globals.baseRequest.getPwd()
                            + "/" +rtagRequest.getClient()+ "/" +rtagRequest.getWarehouse()+ "/" +rtagRequest.getRtagno()
                            + "/" +rtagRequest.getEtd()+ "/" +rtagRequest.getEta()+ "/" +rtagRequest.getTotalrows()
                            + "/" +rtagRequest.getCreateddate();
            Log.i(" rtag fetch default url", url);

            PutawaySplashScreen.incrementNoOfVolleyRequests();
            Log.i("volley", "incremented to " + PutawaySplashScreen.noOfVolleyRequests);
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d("login", response.toString());
                            try {


                                for (int i=0;i<response.length();i++) {
                                    JSONObject jsonObject = (JSONObject) response.get(i);

                                     String ReferenceNo=jsonObject.getString("ReferenceNo");
                                     String DateClosed=jsonObject.getString("DateClosed");
                                     String DateOpened=jsonObject.getString("DateOpened");
                                     int VersionNo=jsonObject.getInt("VersionNo");
                                     int ReceiveDetailsID=jsonObject.getInt("ReceiveDetailsID");
                                     String Status=jsonObject.getString("Status");
                                     String OrderType=jsonObject.getString("OrderType");
                                     String PutAwayStatus=jsonObject.getString("PutAwayStatus");
                                     String rtagstarttime=jsonObject.getString("rtagstarttime");
                                     String rtagendtime=jsonObject.getString("rtagendtime");
                                     int RTagMins=jsonObject.getInt("RTagMins");
                                     String putawaystarttime=jsonObject.getString("putawaystarttime");
                                     String putawayendtime=jsonObject.getString("putawayendtime");
                                    int PutAwayDuration=0;
                                     if(!jsonObject.isNull("PutAwayDuration")) {
                                         PutAwayDuration = jsonObject.getInt("PutAwayDuration");
                                     }
                                     int TotalRTagDuration=0;
                                     if(!jsonObject.isNull("TotalRTagDuration")){
                                        TotalRTagDuration=jsonObject.getInt("TotalRTagDuration");
                                    }
                                     String PutAwayDoneBy=jsonObject.getString("PutAwayDoneBy");
                                     String PutAwaySelectionDoneBy=jsonObject.getString("PutAwaySelectionDoneBy");
                                     String PutAwayDate=jsonObject.getString("PutAwayDate");
                                     int AdvanceShippingNotificationID=0;
                                     String RTagNo=jsonObject.getString("RTagNo");
                                     int ClientMasterID=jsonObject.getInt("ClientMasterID");
                                     int WarehouseMasterID=jsonObject.getInt("WarehouseMasterID");
                                    String ETD=jsonObject.getString("ETD");
                                     String ETA=jsonObject.getString("ETA");
                                     String ReceivedDate=jsonObject.getString("ReceivedDate");
                                     String ClosedBy=jsonObject.getString("ClosedBy");
                                     String OpenedBy=jsonObject.getString("OpenedBy");
                                     String CreatedBy=jsonObject.getString("CreatedBy");
                                     String ModifiedBy=jsonObject.getString("ModifiedBy");
                                     String CreatedOn=jsonObject.getString("CreatedOn");
                                     String WarehouseCode=jsonObject.getString("WarehouseCode");
                                     String ClientCode=jsonObject.getString("ClientCode");
                                     int ServicesAppliedID=0;
                                                                                    //default ServicesAppliedID=0
                                     int TotalRows=jsonObject.getInt("TotalRows");
                                     int RowNos=jsonObject.getInt("RowNos");
                                     Rtag rtag=new Rtag(ReferenceNo,DateClosed,DateOpened,VersionNo,ReceiveDetailsID,Status,OrderType,PutAwayStatus,
                                                        rtagstarttime,rtagendtime,RTagMins,putawaystarttime,putawayendtime,PutAwayDuration,
                                                        TotalRTagDuration,PutAwayDoneBy,PutAwaySelectionDoneBy,PutAwayDate,AdvanceShippingNotificationID,
                                                        RTagNo,ClientMasterID,WarehouseMasterID,ETD,ETA,ReceivedDate,ClosedBy,OpenedBy,CreatedBy,
                                                        ModifiedBy,CreatedOn,WarehouseCode,ClientCode,ServicesAppliedID,TotalRows,RowNos);

                                    rtags.add(rtag);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(context, "loaded clients list", Toast.LENGTH_LONG).show();
                            Globals.defaultListOfRtags=rtags;
                            PutawaySplashScreen.decrementNoOfVolleyRequests();
                            Log.i("volley", "decremented to " + PutawaySplashScreen.noOfVolleyRequests);
                            if(TAG.equals("putaway_search")) {
                                delegate.processFinish();
                            }
                            //return this rTags List

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d("error fetching default rtags", "Error: " + error.getMessage());
                    PutawaySplashScreen.decrementNoOfVolleyRequests();
                }
            });
            AppController.getInstance().getRequestQueue().add(req);

        }

    }
