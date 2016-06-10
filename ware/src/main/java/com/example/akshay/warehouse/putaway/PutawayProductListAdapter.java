package com.example.akshay.warehouse.putaway;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.models.Rtag;

import java.util.List;

/**
 * Created by akshay on 29/10/15.
 */
public class PutawayProductListAdapter extends BaseAdapter {


    LinearLayout llstatus;

    private Context _context;
    private List<Rtag> rtags;
    private static final int[] EMPTY_STATE_SET = {};
    private static final int[] GROUP_EXPANDED_STATE_SET = { android.R.attr.state_expanded };
    private static final int[][] GROUP_STATE_SETS = { EMPTY_STATE_SET, // 0
            GROUP_EXPANDED_STATE_SET // 1
    };



    public PutawayProductListAdapter(Context context, List<Rtag> rtags) {
        this._context = context;
        this.rtags = rtags;

           }


    @Override
    public int getCount() {
        return rtags.size();
    }

    @Override
    public Object getItem(int position) {
        return rtags.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Rtag parentGroup = (Rtag) rtags.get(position);
        String headerTitle = parentGroup.getRTagNo();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.putaway_list_product_short_item, null);
        }

        TextView rtagNo = (TextView) convertView.findViewById(R.id.rtagname);
        TextView clientCode= (TextView) convertView.findViewById(R.id.client_code);
        TextView status= (TextView) convertView.findViewById(R.id.status);
        TextView completed_by= (TextView) convertView.findViewById(R.id.completed_by);
        TextView completion_date= (TextView) convertView.findViewById(R.id.putaway_date);
        Button putaway=(Button)convertView.findViewById(R.id.putaway_rtag_bputaway);
        llstatus=(LinearLayout)convertView.findViewById(R.id.putaway_list_rtag_item_status_iscompleted);

        putaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //??????????????????????
                Log.i("onclick", "button clicked");
                Intent i=new Intent();
               i.setClass(_context, PutawayProductList.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                _context.startActivity(i);


            }
        });

        rtagNo.setText(headerTitle);
        clientCode.setText(parentGroup.getClientCode());
        status.setText(parentGroup.getStatus());
        completed_by.setText(parentGroup.getPutAwaySelectionDoneBy());
        completion_date.setText(parentGroup.getPutAwayDate());


        if(parentGroup.getStatus().equals("Completed"))
        {
            llstatus.setBackgroundColor(Color.argb(255, 255, 136, 0));
        }
        else
        {
            llstatus.setBackgroundColor(Color.argb(255,100,221,23));
        }

        return convertView;    }



}
