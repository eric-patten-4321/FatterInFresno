package com.example.android.gettingfatterinfresno.adpaters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.gettingfatterinfresno.fragments.BakeryFragment;
import com.example.android.gettingfatterinfresno.fragments.FoodTruckFragment;
import com.example.android.gettingfatterinfresno.fragments.LocalSitdownFragment;
import com.example.android.gettingfatterinfresno.fragments.StandupLunchFragment;

public class SpotPagerAdapter extends FragmentStateAdapter {

    public SpotPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FoodTruckFragment();
            case 1:
                return new StandupLunchFragment();
            case 2:
                return new LocalSitdownFragment();
            case 3:
                return new BakeryFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
