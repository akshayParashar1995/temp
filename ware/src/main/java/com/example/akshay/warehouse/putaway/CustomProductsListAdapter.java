package com.example.akshay.warehouse.putaway;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.models.Product;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

/**
 * Created by akshay on 31/10/15.
 */
public class CustomProductsListAdapter extends BaseAdapter {


    TextView tvbarcode, tvlocationcode, tvproductcode, tvrtagno, tvbatchno, tvlotno, tvproductclass, tvmfgdate, tvexpdate;
    Button barcode;
    LinearLayout lvissaved;
    boolean checksaved;
    public static class ViewHolder{


        public TextView text;

        public TextView text1;
        public TextView textWide;
        public ImageView image;
    }
    private Activity activity;
    private List<Product> list;
    private Context mcontext;
    private static LayoutInflater inflater=null;
    public Resources res;

    public CustomProductsListAdapter(Activity activity, List<Product> list, Resources resLocal){
        this.activity=activity;
        this.list=list;
        this.mcontext=activity.getApplicationContext();
        res = resLocal;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){
            vi = inflater.inflate(R.layout.putaway_list_product_short_item, null);
            holder = new ViewHolder();
          //  holder.text = (TextView) vi.findViewById(R.id.product_id);
           // holder.text1=(TextView)vi.findViewById(R.id.product_rtag);
           // vi.setTag( holder );
        }
      //  else

       // final Rtag parentGroup = (Rtag) rtags.get(position);
        final Product product=(Product)list.get(position);

        Log.i("checkk", "reached custom products list adapter");

            holder=(ViewHolder)vi.getTag();

      //  if(list.size()<=0)
      //  {
           // holder.text.setText("No Data");

     //   }
       // else
      //  {
          //  Product product=list.get(position);
           // holder.text.setText( product.getProductId() );
           // holder.text1.setText( product.getRtagNo());

        lvissaved=(LinearLayout)vi.findViewById(R.id.putaway_list_product_issaved);
        tvbarcode=(TextView)vi.findViewById(R.id.putaway_product_barcode);
        tvlocationcode=(TextView)vi.findViewById(R.id.putaway_product_locationcode);
        tvproductcode=(TextView)vi.findViewById(R.id.putaway_product_productcode);
      //  tvrtagno=(TextView)vi.findViewById(R.id.putaway_product_rtagno);
        tvbatchno=(TextView)vi.findViewById(R.id.putaway_product_batchno);
        tvlotno=(TextView)vi.findViewById(R.id.putaway_product_lotno);
     //   tvproductclass=(TextView)vi.findViewById(R.id.putaway_product_productclass);
      //  tvmfgdate=(TextView)vi.findViewById(R.id.putaway_product_mfgdate);
      //  tvexpdate=(TextView)vi.findViewById(R.id.putaway_product_expdate);
        barcode=(Button)vi.findViewById(R.id.putaway_product_barcode);



        tvbarcode.setText(product.getBarcodeNo());
        tvlocationcode.setText(product.getLocation());
        tvproductcode.setText(product.getProductCode());
       // tvrtagno.setText(product.getRtagNo());
        tvbatchno.setText(product.getBatchNo());
        tvlotno.setText(product.getLotNo());
      //  tvproductclass.setText(product.getProductClass());
       // tvmfgdate.setText(product.getMfgDate());
      //  tvexpdate.setText(product.getExpDate());

        checksaved=product.getIsCompleted();

        Log.i("saved", String.valueOf(checksaved));

        if(checksaved==true)
        {
            lvissaved.setBackgroundColor(Color.argb(255,255,136,0));
            Log.i("saved true", "true");
        }
        else
        {
            lvissaved.setBackgroundColor(Color.argb(255,100,221,23));
            Log.i("saved false", "false");
        }

        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(activity).initiateScan();

            }
        });

        return vi;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("UserLoginActivity", "Cancelled scan");
                Toast.makeText(activity, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("UserLoginActivity", "Scanned");
                Toast.makeText(activity, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            Log.d("UserLoginActivity", "Weird");
            // This is important, otherwise the result will not be passed to the fragment
        }
    }

}
