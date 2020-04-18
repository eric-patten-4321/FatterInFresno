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
public class FoodTruckFragment extends Fragment {
    private static final String TAG = "FragmentFoodTruck";
    public FoodTruckFragment() {
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
        spots.add(new FoodSpot(getString(R.string.gg_title), getString(R.string.gg_desc), getString(R.string.call_ahead), getString(R.string.gg_phone), getString(R.string.gg_url)));
        spots.add(new FoodSpot(getString(R.string.md_title), getString(R.string.md_desc), getString(R.string.call_ahead), getString(R.string.md_phone), getString(R.string.md_url), R.drawable.meltdown_yelp_ritab));
        spots.add(new FoodSpot(getString(R.string.emp_title), getString(R.string.emp_desc), getString(R.string.call_ahead), getString(R.string.emp_phone), getString(R.string.none)));
        spots.add(new FoodSpot(getString(R.string.tm_title), getString(R.string.tm_desc), getString(R.string.call_ahead), getString(R.string.tm_phone), getString(R.string.none)));
        spots.add(new FoodSpot(getString(R.string.pv_title), getString(R.string.pv_desc), getString(R.string.call_ahead), getString(R.string.pv_phone), getString(R.string.none), R.drawable.vegan_yelp_jeets));
        spots.add(new FoodSpot(getString(R.string.phils_title), getString(R.string.phil_desc), getString(R.string.phil_address), getString(R.string.phil_phone), getString(R.string.none)));
        spots.add(new FoodSpot(getString(R.string.mega_title), getString(R.string.mega_desc), getString(R.string.mega_address), getString(R.string.mega_phone), getString(R.string.none), R.drawable.mega_yelp_lj));

        FoodSpotAdapter adpater = new FoodSpotAdapter(getActivity(), spots);
        final ListView listView = rootView.findViewById(R.id.list_of_spots);
        final int bgColor = getResources().getColor(R.color.colorLightPurple);
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

// TODO: 4/18/20 FEEDBACK ABOUT USING STRING ARRAYS to hold all strings to be passed in intent... try it out.
/*

  Instead of getting all these strings and passing them to the DetailActivity, you can easily send just the ID of the clicked location, and define a String array <string-array> in strings resource file with the corresponding names and values, and then, you can retrieve these values in the DetailActivity.
        For example:

//in strings.xml
<string-array
        name="house_of_kebab">
<item>House of Kebab</item>
<item> an\'t go wrong with the lula kebab.</item>
</string-array>
        And then in the Fragment here you just send the spots.get(postition).getId()
        Also, it would be handy to add the indices of the elements inside the string array in Constants.java so they don't get mixed up by mistake.

//keep the indices of parameters saved in static constants so you don't mix them up or have to look every time you extract them
static final int NAME_PARAMETER_INDEX = 0;
        And in the DetailActivity just:


        String id = intent.getStringExtra("id");
        String[] params = getResources.getStringArray(R.array.id)
        displayName.setText(params[Constants.NAME_PARAMETER_INDEX]);

        */
