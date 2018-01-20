package hospital.hospital.FacilityProfileResources;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hospital.hospital.R;

public class FragmentFacilityProfileAboutUs extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_facility_profile_about_us, container, false);
        return rootView;
    }
}
