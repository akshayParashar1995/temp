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
import com.example.akshay.warehouse.models.Rtag;

import java.util.List;

/**
 * Created by akshay on 31/10/15.
 */
public class PutawayListFragment extends Fragment {

    private ListView putawayListView;
    private PutawayListAdapter putawayListAdapter;
    private OnRtagListItemSelectedListener onRtagListItemSelectedListener;
    private List<Rtag> rtags;


    public interface OnRtagListItemSelectedListener {
        // This can be any number of events to be sent to the activity
        public void onItemSelected(Rtag selected);
    }

    public void changeFragmentContent(){
        rtags=Globals.defaultListOfRtags;
        putawayListAdapter.changeList(rtags);
        putawayListAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments=getArguments();
        rtags= Globals.defaultListOfRtags;

        View rootView = inflater.inflate(R.layout.putaway_list, container, false);
        Log.i("test","list fetched of size "+Globals.defaultListOfRtags.size());
        putawayListView= (ListView) rootView.findViewById(R.id.putaway_expandable_list_view);
        putawayListAdapter =new PutawayListAdapter(getActivity().getApplicationContext(),rtags);
        putawayListView.setAdapter(putawayListAdapter);
        putawayListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Rtag clickedRtag= (Rtag) parent.getItemAtPosition(position);
                Log.i("clicked", "item");
                Toast.makeText(getActivity().getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
                onRtagListItemSelectedListener.onItemSelected(clickedRtag);

            }
        });
        return rootView;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnRtagListItemSelectedListener) {
            onRtagListItemSelectedListener = (OnRtagListItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }



    }


