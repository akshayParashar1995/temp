package com.example.akshay.warehouse.putaway;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.akshay.warehouse.R;
import com.example.akshay.warehouse.models.Rtag;
import com.example.akshay.warehouse.putaway.putaway_search.PutawayListSearchFragment;

public class PutAwayList extends AppCompatActivity implements PutawayListFragment.OnRtagListItemSelectedListener,FetchProductsForGivenRtag.OnSuccessfulFetchingOfProducts,PutawayListSearchFragment.OnSearchButtonClickListener {

    private FrameLayout putawayDetailsFragmentLayout;
    private FrameLayout putawaySearchFragmentLayout;
    private Fragment putawayListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_away_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            putawayListFragment=new PutawayListFragment();
            Bundle bundle=new Bundle();

            bundle.putBoolean("isListForDefaultRtags", true);
            putawayListFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_putaway_list,putawayListFragment)
                    .commit();

        }
        putawayDetailsFragmentLayout= (FrameLayout) findViewById(R.id.fragment_putaaway_list_details);
        putawaySearchFragmentLayout= (FrameLayout) findViewById(R.id.fragment_putaway_search_list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Search for particular Rtag", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
                if (putawaySearchFragmentLayout.getVisibility() == View.GONE) {
                    putawaySearchFragmentLayout.setVisibility(View.VISIBLE);
                    getFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_putaway_search_list, new PutawayListSearchFragment())
                            .commit();
                } else {
                    putawaySearchFragmentLayout.setVisibility(View.GONE);
                    Fragment presentFragment = getFragmentManager().findFragmentById(R.id.fragment_putaway_search_list);
                    if (presentFragment != null)
                        getFragmentManager().beginTransaction().remove(presentFragment).commit();

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_put_away_list, menu);
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
    public void onItemSelected(Rtag selectedRtag) {
        Log.i("Rtag no selected=", selectedRtag.getRTagNo());
        putawayDetailsFragmentLayout.setVisibility(View.VISIBLE);
        FetchProductsForGivenRtag fetchProductsForGivenRtag=new FetchProductsForGivenRtag();
        fetchProductsForGivenRtag.fetchProducts(selectedRtag, getApplicationContext());
        fetchProductsForGivenRtag.delegate=this;


    }

    @Override
    public void onResult() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_putaaway_list_details, new PutawayListDetailsFragment())
                .commit();
    }

    @Override
    public void onSearchClicked() {
        Log.i("test", "inside putaway list");
//        getFragmentManager().beginTransaction().remove(putawayListFragment);
//                .add(R.id.fragment_putaway_list, new PutawayListFragment());
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_putaway_list, new PutawayListFragment())
                .commit();
        putawayDetailsFragmentLayout.setVisibility(View.GONE);
        putawaySearchFragmentLayout.setVisibility(View.GONE);
    }
}
