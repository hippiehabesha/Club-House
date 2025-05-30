package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final boolean showMenu;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, boolean showMenu) {
        super(fragmentActivity);
        this.showMenu = showMenu;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (showMenu) {
            // HomeActivity: show HomePage (with menu)
            return new HomePage();
        } else {
            // MainActivity: show LoginPage (no menu)
            return new LoginPage();
        }
    }


    @Override
    public int getItemCount() {
        return 1; // Only one page (login)
    }
}

