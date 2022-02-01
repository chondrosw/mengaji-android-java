package com.example.mengaji_java.View.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class AuthenticationPagerAdapter extends PagerAdapter {
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();


    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    public void addFragment(Fragment fragment) {
        fragmentsList.add(fragment);
    }
}
