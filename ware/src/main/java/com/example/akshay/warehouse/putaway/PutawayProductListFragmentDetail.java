package com.example.akshay.warehouse.putaway;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.extras.Globals;
import com.example.akshay.warehouse.models.Product;
import com.example.akshay.warehouse.requests.BaseRequest;
import com.example.akshay.warehouse.requests.SavePutawayRequest;
import com.google.zxing.integration.android.IntentIntegrator;

/**
 * Created by akshay on 31/10/15.
 */



public class PutawayProductListFragmentDetail extends Fragment {

    private ListView detailsList;
    private PutawayProductItemDetailsListAdapter detailsListAdapter;
    private Product selectedProduct;
    private TextView tvbarcode;
    private TextView tvlocationcode;
    private TextView tvproductcode;
    private TextView tvrtagno;
    private TextView tvbatchno;
    private TextView tvlotno;
    private TextView tvproductclass;
    private TextView tvmfgdate;
    private TextView tvexpdate;
    private Button barcode;
    private LinearLayout lvissaved;
    private LinearLayout barcodeLinearLayout;
    boolean checksaved;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vi = inflater.inflate(R.layout.putaway_list_product_item, container, false);
        lvissaved=(LinearLayout)vi.findViewById(R.id.putaway_list_product_issaved);
        tvbarcode=(TextView)vi.findViewById(R.id.putaway_product_barcode);
        tvlocationcode=(TextView)vi.findViewById(R.id.putaway_product_locationcode);
        tvproductcode=(TextView)vi.findViewById(R.id.putaway_product_productcode);
        tvrtagno=(TextView)vi.findViewById(R.id.putaway_product_rtagno);
        tvbatchno=(TextView)vi.findViewById(R.id.putaway_product_batchno);
        tvlotno=(TextView)vi.findViewById(R.id.putaway_product_lotno);
        tvproductclass=(TextView)vi.findViewById(R.id.putaway_product_productclass);
        tvmfgdate=(TextView)vi.findViewById(R.id.putaway_product_mfgdate);
        tvexpdate=(TextView)vi.findViewById(R.id.putaway_product_expdate);
        barcode=(Button)vi.findViewById(R.id.putaway_product_barcode);
        barcodeLinearLayout= (LinearLayout) vi.findViewById(R.id.putaway_barcode_scan_layout);
        selectedProduct=Globals.productsForCurrentlySelelctedRtag.get(0);
        initializeFields(selectedProduct);
        barcodeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavePutawayRequest savePutawayRequest=new SavePutawayRequest(Globals.baseRequest.getUser(),Globals.baseRequest.getPwd(),
                        selectedProduct.getReceiveProductDetailsID(),selectedProduct.getProductClassID(),barcode.getText().toString(),tvlocationcode.getText().toString());
                new SavePutawayProduct().saveProduct(savePutawayRequest,getActivity().getApplicationContext());
            }
        });

        return vi;
    }

    public void updateProductDetails(Product product) {
       initializeFields(product);
    }

    private void initializeFields(Product product){
        tvbarcode.setText(product.getBarcodeNo());
        tvlocationcode.setText(product.getLocation());
        tvproductcode.setText(product.getProductCode());
        tvrtagno.setText(product.getRTagNo());
        tvbatchno.setText(product.getBatchNo());
        tvlotno.setText(product.getLotNo());
        tvproductclass.setText(product.getProductClassCode());
        tvmfgdate.setText(product.getMFGDate());
        tvexpdate.setText(product.getEXPDate());

        checksaved=product.getIsCompleted();

        Log.i("test3","got product at target fragment");

        if(checksaved==true)
        {
            lvissaved.setBackgroundColor(Color.argb(255, 255, 136, 0));
            Log.i("saved true", "true");
        }
        else
        {
            lvissaved.setBackgroundColor(Color.argb(255,100,221,23));
            Log.i("saved false", "false");
        }


    }
}
