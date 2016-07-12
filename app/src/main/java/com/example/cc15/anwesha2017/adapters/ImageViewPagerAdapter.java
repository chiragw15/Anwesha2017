package com.example.cc15.anwesha2017.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import com.example.cc15.anwesha2017.fragments.ImageFourFragment;
import com.example.cc15.anwesha2017.fragments.ImageOneFragment;
import com.example.cc15.anwesha2017.fragments.ImageThreeFragment;
import com.example.cc15.anwesha2017.fragments.ImageTwoFragment;


public class ImageViewPagerAdapter extends FragmentPagerAdapter {
    private Context _context;
    public int totalPage = 4;

    public ImageViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        _context = context;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
            position =position % totalPage;
            switch (position) {
                case 0:
                    f = new ImageOneFragment();
                    break;
                case 1:
                    f = new ImageTwoFragment();
                    break;
                case 2:
                    f = new ImageThreeFragment();
                    break;
                case 3:
                    f = new ImageFourFragment();
            }
            return f;
        }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

}

