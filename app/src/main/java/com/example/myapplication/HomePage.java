package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;
import com.example.myapplication.databinding.FragmentHomePageBinding;

import java.util.ArrayList;

public class HomePage extends Fragment {
    private FragmentHomePageBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    EventViewAdapter vpAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomePageBinding.inflate(inflater, container, false);

        ImageSlider imageSlider = binding.imageSlider;
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.test1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.test2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.test3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int position) {
                Toast.makeText(requireContext(), "Image " + (position + 1) + " clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void doubleClick(int position) {
                // Optional: handle double click if needed
            }
        });

        tabLayout = binding.tabLayout;
        viewPager = binding.eventsViewpage;
        vpAdapter = new EventViewAdapter(requireActivity());
        viewPager.setAdapter(vpAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // No action needed
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // No action needed
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return binding.getRoot();
    }

}
