package com.example.akshay.warehouse.putaway.putaway_search;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.extras.Globals;
import com.example.akshay.warehouse.models.Client;
import com.example.akshay.warehouse.putaway.FetchingFilteredRtags;
import com.example.akshay.warehouse.requests.RtagRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by akshay on 31/10/15.
 */
public class PutawayListSearchFragment extends Fragment implements FetchingFilteredRtags.AsyncResponse{



    private Button bDisplayDateFrom;
    private Spinner clientSpinner;
    private CustomClientSpinnerAdapter spinnerAdapter;
    private Button bDisplayDateTo;
    private int year;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 999;
    private FancyButton search;
    private EditText rtagNo;
    private Calendar myCalendar;
    private OnSearchButtonClickListener onSearchButtonClickListener;
    private final String TAG="putaway_search";

    public interface OnSearchButtonClickListener {
        // This can be any number of events to be sent to the activity
        public void onSearchClicked();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.putaway_search_fragment, container, false);
        search= (FancyButton) rootView.findViewById(R.id.searchbutton_searchfragment);
        bDisplayDateFrom = (Button) rootView.findViewById(R.id.bdatefrom);
        bDisplayDateTo= (Button) rootView.findViewById(R.id.bdateto);
        clientSpinner= (Spinner) rootView.findViewById(R.id.client_list_dropdown);
        rtagNo= (EditText) rootView.findViewById(R.id.rtag_no);

        FetchingFilteredRtags.delegate=this;

        myCalendar = Calendar.getInstance();

        setCurrentDateOnView();
        addListenerOnButton();
        spinnerAdapter = new CustomClientSpinnerAdapter(getActivity(),Globals.spinnerClientsList,getActivity().getApplicationContext().getResources());
        clientSpinner.setAdapter(spinnerAdapter);



        final DatePickerDialog.OnDateSetListener dateFrom = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);

                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel(bDisplayDateFrom);
            }

        };

        final DatePickerDialog.OnDateSetListener dateTo = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);

                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel(bDisplayDateTo);
            }

        };



        bDisplayDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), dateFrom, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        bDisplayDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), dateTo, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateFrom=bDisplayDateFrom.getText().toString();
                String dateTo=bDisplayDateTo.getText().toString();
                Client selectedClient= (Globals.spinnerClientsList.get(clientSpinner.getSelectedItemPosition()));
                String rtag=rtagNo.getText().toString();
                RtagRequest rtagRequest=new RtagRequest(selectedClient.getClientMasterID(),0,(rtag),dateFrom,dateTo,0,0) ;         //add warehouse no.
                FetchingFilteredRtags.fetchRtags(getActivity().getApplicationContext(),rtagRequest,TAG);

                //go back to activity clearing the productslist and updating the rtags list
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnSearchButtonClickListener) {
            onSearchButtonClickListener = (OnSearchButtonClickListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement putawayListSearchFragment.OnsearchClickListener");
        }
    }

    // display current date
    public void setCurrentDateOnView() {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        bDisplayDateFrom.setText(new StringBuilder().append(day)
                .append("-").append(month + 1).append("-")
                .append(year));
        bDisplayDateTo.setText(new StringBuilder().append(day + 1)
                .append("-").append(month + 1).append("-")
                .append(year));

    }

    private void updateLabel(Button button) {

        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        button.setText(sdf.format(myCalendar.getTime()));
    }



    @Override
    public void processFinish() {
        Log.i("test","on process finish");
        Log.i("test","fetched list pf size "+Globals.defaultListOfRtags.size());
        onSearchButtonClickListener.onSearchClicked();
    }

    public void addListenerOnButton() {
        bDisplayDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("TAG", "reached onClick");

                getActivity().showDialog(DATE_DIALOG_ID);
                onCreateDialog(DATE_DIALOG_ID);
            }

        });

    }



    public Dialog onCreateDialog(int id) {

        Log.i("TAG", "reached onCreateDialogMethod");

        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                Log.i("TAG", "reached swichcase");
                return new DatePickerDialog(getActivity(), datePickerListener, year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            bDisplayDateFrom.setText(new StringBuilder().append(day)
                    .append("-").append(month + 1).append("-").append(year));

            // set selected date into datepicker also
            //   dpResult.init(year, month, day, null);

        }
    };



}
