package com.example.set12ma.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.set12ma.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MainActivitySectionsPagerAdapterDataExchange extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_SET12MA_text_0, R.string.tab_SET12MA_text_1, R.string.tab_SET12MA_text_2, R.string.tab_SET12MA_text_3};
    private final Context mContext;

    public MainActivitySectionsPagerAdapterDataExchange(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1);
        if (position == 0) {
            return FragmentInput.newInstance(position + 1);
        } else if (position == 1) {
            return FragmentOutput.newInstance(position + 1);
        } else if (position == 2) {
            return FragmentADC.newInstance(position + 1);
        } else {
            return TkFragment.newInstance(position + 1);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}
