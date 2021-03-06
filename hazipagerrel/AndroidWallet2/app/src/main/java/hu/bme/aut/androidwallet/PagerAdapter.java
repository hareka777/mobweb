package hu.bme.aut.androidwallet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import hu.bme.aut.androidwallet.fragments.CkeckoutFragment;
import hu.bme.aut.androidwallet.fragments.TAndCs;

public class PagerAdapter extends Pager {
    private static final int NUM_PAGES = 2;
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CkeckoutFragment();
            case 1:
                return new TAndCs();
            default:
                return new CkeckoutFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }


}
