package com.example.android.gettingfatterinfresno.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.android.gettingfatterinfresno.DetailActivity;
import com.example.android.gettingfatterinfresno.R;
import com.example.android.gettingfatterinfresno.adpaters.FoodSpotAdapter;
import com.example.android.gettingfatterinfresno.classes.FoodSpot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StandupLunchFragment extends Fragment {
    private static final String TAG = "FragmentStandup";
    public StandupLunchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.spot_list, container, false);
        super.onCreate(savedInstanceState);

        //create list of FoodSpots
        final ArrayList<FoodSpot> spots = new ArrayList<>();
        spots.add(new FoodSpot(getString(R.string.maw_title), getString(R.string.maw_desc), getString(R.string.maw_address), getString(R.string.maw_phone), getString(R.string.maw_url)));
        spots.add(new FoodSpot(getString(R.string.brock_title), getString(R.string.brock_desc), getString(R.string.brock_address), getString(R.string.brock_phone), getString(R.string.brock_url), R.drawable.beerock_yelp_meganp));
        spots.add(new FoodSpot(getString(R.string.ken_title), getString(R.string.ken_desc), getString(R.string.ken_address), getString(R.string.ken_phone), getString(R.string.ken_url), R.drawable.kenji_yelp_joelc));
        spots.add(new FoodSpot(getString(R.string.wc_title), getString(R.string.wc_desc), getString(R.string.wc_address), getString(R.string.wc_phone), getString(R.string.none)));
        spots.add(new FoodSpot(getString(R.string.charr_title), getString(R.string.charr_desc), getString(R.string.charr_address), getString(R.string.charr_phone), getString(R.string.none)));
        spots.add(new FoodSpot(getString(R.string.kar_title), getString(R.string.kar_desc), getString(R.string.kar_address), getString(R.string.kar_phone), getString(R.string.none)));

        FoodSpotAdapter adpater = new FoodSpotAdapter(getActivity(), spots);
        ListView listView = rootView.findViewById(R.id.list_of_spots);
        final int bgColor = getResources().getColor(R.color.colorLightBlue);
        listView.setBackgroundColor(bgColor);
        listView.setAdapter(adpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Clicked");
                FoodSpot currentSpot = spots.get(position);
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("name", currentSpot.getName());
                intent.putExtra("description", currentSpot.getDescription());
                intent.putExtra("address", currentSpot.getAddress());
                intent.putExtra("phone", currentSpot.getPhone());
                intent.putExtra("url", currentSpot.getWebsite());
                intent.putExtra("bgColor", bgColor);
                intent.putExtra("imageId", currentSpot.getImageId());
                startActivity(intent);
            }
        });
        return listView;
    }
}
