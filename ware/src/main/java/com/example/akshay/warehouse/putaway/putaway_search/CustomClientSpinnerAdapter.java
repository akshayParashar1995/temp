package com.example.akshay.warehouse.putaway.putaway_search;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.models.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akshay on 15/12/15.
 */
public class CustomClientSpinnerAdapter  extends BaseAdapter {

    private TextView itemView;
    private List<Client> mItems;
    private Context context;
    public Resources res;
    private static LayoutInflater inflater=null;


    public CustomClientSpinnerAdapter(Activity activity,List<Client> items,Resources resLocal) {
        mItems=items;
        this.context=activity.getApplicationContext();
        res = resLocal;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.client_spinner_custom_dropdown, parent, false);

            itemView = (TextView) convertView.findViewById(R.id.client_dropdown_item);
        }
        Client item = mItems.get(position);
        if (item!= null) {
            // My layout has only one TextView
            // do whatever you want with your string and long
            itemView.setText(item.getClientCode());
        }

        return convertView;
    }


}
