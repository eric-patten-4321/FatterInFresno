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
public class BakeryFragment extends Fragment {
    private static final String TAG = "FragmentBakery";
    public BakeryFragment() {
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
        spots.add(new FoodSpot(getString(R.string.ampTitle), getString(R.string.ampDesc), getString(R.string.ampAddress), getString(R.string.ampPhone), getString(R.string.ampUrl), R.drawable.ampersand, getString(R.string.amp_cap)));
        spots.add(new FoodSpot(getString(R.string.gTitle), getString(R.string.gDesc), getString(R.string.gAddress), getString(R.string.gPhone), getString(R.string.gUrl), R.drawable.gs, getString(R.string.c_cap)));
        spots.add(new FoodSpot(getString(R.string.labouTitle), getString(R.string.labouDesc), getString(R.string.labouAddress), getString(R.string.labouPhone), getString(R.string.labouUrl), R.drawable.labou, getString(R.string.labou_cap)));
        spots.add(new FoodSpot(getString(R.string.bdTitle), getString(R.string.bdDesc), getString(R.string.bdAddress), getString(R.string.bdPhone), getString(R.string.none), R.drawable.bakerydelights, ""));
        spots.add(new FoodSpot(getString(R.string.sbbTitle), getString(R.string.sbbDesc), getString(R.string.callAhead), getString(R.string.sbbPhone), getString(R.string.sbbUrl), R.drawable.sweetbeginning, getString(R.string.sb_cap)));
        spots.add(new FoodSpot(getString(R.string.bbbTitle), getString(R.string.bbbDesc), getString(R.string.bbbAddress), getString(R.string.bbbPhone), getString(R.string.none), R.drawable.armenbakery, ""));

        FoodSpotAdapter adpater = new FoodSpotAdapter(getActivity(), spots);
        ListView listView = rootView.findViewById(R.id.list_of_spots);
        final int bgColor = getResources().getColor(R.color.colorLightGreen);
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
                intent.putExtra("caption", currentSpot.getCaption());
                startActivity(intent);
            }
        });
        return listView;
    }
}
