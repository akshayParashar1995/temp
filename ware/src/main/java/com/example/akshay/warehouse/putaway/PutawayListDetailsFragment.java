package com.example.akshay.warehouse.putaway;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.extras.Globals;

/**
 * Created by akshay on 31/10/15.
 */



public class PutawayListDetailsFragment extends Fragment {

    private ListView detailsList;
    private CustomProductsListAdapter detailsListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.putaway_list_detail, container, false);
        detailsList= (ListView) rootView.findViewById(R.id.putaway_details_list);


        detailsListAdapter=new CustomProductsListAdapter(getActivity(), Globals.productsForCurrentlySelelctedRtag,getResources());
        detailsList.setAdapter(detailsListAdapter);

        return rootView;
    }
}
