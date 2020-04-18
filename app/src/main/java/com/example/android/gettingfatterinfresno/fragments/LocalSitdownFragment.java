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
public class LocalSitdownFragment extends Fragment {
    private static final String TAG = "FragmentSitDown";
    public LocalSitdownFragment() {
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
        spots.add(new FoodSpot(getString(R.string.duck_title), getString(R.string.duck_desc), getString(R.string.duck_address), getString(R.string.duck_phone), getString(R.string.duck_url), R.drawable.madduck));
        spots.add(new FoodSpot(getString(R.string.hk_title), getString(R.string.hk_desc), getString(R.string.hk_address), getString(R.string.hk_phone), getString(R.string.hk_url)));
        spots.add(new FoodSpot(getString(R.string.oka_title), getString(R.string.oka_desc), getString(R.string.oka_address), getString(R.string.oka_phone), getString(R.string.none)));
        spots.add(new FoodSpot(getString(R.string.sushi_title), getString(R.string.sushi_desc), getString(R.string.sushi_address), getString(R.string.sushi_phone), getString(R.string.sushi_url), R.drawable.ilivesushi));
        spots.add(new FoodSpot(getString(R.string.sh_title), getString(R.string.sh_desc), getString(R.string.sh_address), getString(R.string.sh_phone), getString(R.string.sh_url)));
        spots.add(new FoodSpot(getString(R.string.pis_title), getString(R.string.pis_desc), getString(R.string.pis_address), getString(R.string.pis_phone), getString(R.string.pis_url)));
        spots.add(new FoodSpot(getString(R.string.an_title), getString(R.string.an_desc), getString(R.string.an_address), getString(R.string.an_phone), getString(R.string.an_url)));
        spots.add(new FoodSpot(getString(R.string.palms_title), getString(R.string.palms_desc), getString(R.string.palms_address), getString(R.string.palms_phone), getString(R.string.palms_url), R.drawable.porterhouse));

        FoodSpotAdapter adpater = new FoodSpotAdapter(getActivity(), spots);
        ListView listView = rootView.findViewById(R.id.list_of_spots);
        final int bgColor = getResources().getColor(R.color.colorLightTurq);
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
