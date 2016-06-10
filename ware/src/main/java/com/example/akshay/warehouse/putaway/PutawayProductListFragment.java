package com.example.akshay.warehouse.putaway;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.extras.Globals;
import com.example.akshay.warehouse.models.Product;

import java.util.List;

/**
 * Created by akshay on 31/10/15.
 */



public class PutawayProductListFragment extends Fragment {

    private ListView productsListView;
    private CustomProductsListAdapter productsListViewAdapter;
    List<Product> list;
    private OnItemPutawayProductItemSelectedListener onItemPutawayProductItemSelectedListener;

    public interface OnItemPutawayProductItemSelectedListener {
        public void onProductItemSelected(Product selected);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_putaway_product_list, container, false);
        productsListView= (ListView) rootView.findViewById(R.id.putaway_product_list);

        productsListViewAdapter =new CustomProductsListAdapter(getActivity(), Globals.productsForCurrentlySelelctedRtag,getResources());
        productsListView.setAdapter(productsListViewAdapter);

         list=Globals.productsForCurrentlySelelctedRtag;




        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Product product=(Product)list.get(position);
                Log.i("test2", "product clicked :" +product);
                onItemPutawayProductItemSelectedListener.onProductItemSelected(product);
            }
        });

        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);



        if (activity instanceof OnItemPutawayProductItemSelectedListener) {
            onItemPutawayProductItemSelectedListener = (OnItemPutawayProductItemSelectedListener) activity;

        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }


}
