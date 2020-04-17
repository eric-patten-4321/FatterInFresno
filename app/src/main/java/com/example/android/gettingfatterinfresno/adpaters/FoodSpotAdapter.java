package com.example.android.gettingfatterinfresno.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.gettingfatterinfresno.R;
import com.example.android.gettingfatterinfresno.classes.FoodSpot;

import java.util.List;

public class FoodSpotAdapter extends ArrayAdapter<FoodSpot> {
    public FoodSpotAdapter(@NonNull Context context, @NonNull List<FoodSpot> spots) {
        super(context, 0, spots);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        FoodSpot currentSpot = getItem(position);
        TextView name = listItemView.findViewById(R.id.tv_name);
        TextView description = listItemView.findViewById(R.id.tv_description);

        if (currentSpot != null) {
            name.setText(currentSpot.getName());
            description.setText(currentSpot.getDescription());
        }

        return listItemView;
    }
}
