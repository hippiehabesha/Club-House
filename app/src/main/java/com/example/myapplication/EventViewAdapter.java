package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class EventViewAdapter extends FragmentStateAdapter {

    public EventViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new EventToday();
        } else if (position == 1) {
            return new EventUpcoming();
        } else {
            return new EventToday();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
