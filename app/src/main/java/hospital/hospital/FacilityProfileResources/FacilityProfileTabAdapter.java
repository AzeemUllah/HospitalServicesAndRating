package hospital.hospital.FacilityProfileResources;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hospital.hospital.R;

/**
 * Created by syeda on 1/14/2018.
 */

public class FacilityProfileTabAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public FacilityProfileTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentFacilityProfileAboutUs();
        } else{
            return new FragmentFacilityProfileReviews();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "About Us";
            case 1:
                return "Reviews";
            default:
                return null;
        }
    }
}
