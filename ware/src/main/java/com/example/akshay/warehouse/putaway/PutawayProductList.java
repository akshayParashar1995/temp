package com.example.akshay.warehouse.putaway;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.models.Product;

public class PutawayProductList extends AppCompatActivity implements PutawayProductListFragment.OnItemPutawayProductItemSelectedListener{

    private FrameLayout putawayDetailsFragmentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putaway_product_list);

        putawayDetailsFragmentLayout= (FrameLayout) findViewById(R.id.fragment_putaaway_product_list_details);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_putaway_product_list, new PutawayProductListFragment())
                    .commit();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_putaaway_product_list_details, new PutawayProductListFragmentDetail())
                    .commit();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_putaway_product_list, menu);
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
    public void onProductItemSelected(Product product) {

        Log.i("test2","got product at parent activity "+product);
        PutawayProductListFragmentDetail currentlyPlacedPutawayProductListFragmentDetail=
                (PutawayProductListFragmentDetail) getFragmentManager().findFragmentById(R.id.fragment_putaaway_product_list_details);
        currentlyPlacedPutawayProductListFragmentDetail.updateProductDetails(product);

    }
}
