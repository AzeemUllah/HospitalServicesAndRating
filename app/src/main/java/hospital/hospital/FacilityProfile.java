package hospital.hospital;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hospital.hospital.FacilityProfileResources.FacilityProfileTabAdapter;

public class FacilityProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_profile);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FacilityProfileTabAdapter adapter = new FacilityProfileTabAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
