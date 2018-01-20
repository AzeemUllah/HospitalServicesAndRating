package hospital.hospital.FacilityProfileResources;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hospital.hospital.FacilityProfileResources.ReviewsResources.ReviewsAdapter;
import hospital.hospital.FacilityProfileResources.ReviewsResources.ReviewsData;
import hospital.hospital.R;

public class FragmentFacilityProfileReviews extends Fragment {
    private List<ReviewsData> reviewsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReviewsAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup                  container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_facility_profile_reviews, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewReviewsList);

        mAdapter = new ReviewsAdapter(reviewsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareReviewsData();

        return rootView;
    }


    private void prepareReviewsData() {
        ReviewsData bubble1 = new ReviewsData("message1", "1", "time1", "name1",1);
        reviewsList.add(bubble1);
        ReviewsData bubble2 = new ReviewsData("message1", "1", "time1", "name1",1);
        reviewsList.add(bubble2);
        ReviewsData bubble3 = new ReviewsData("message1", "1", "time1", "name1",1);
        reviewsList.add(bubble3);
        ReviewsData bubble4 = new ReviewsData("message1", "1", "time1", "name1",1);
        reviewsList.add(bubble4);
        ReviewsData bubble5 = new ReviewsData("message1", "1", "time1", "name1",1);
        reviewsList.add(bubble5);
        ReviewsData bubble6 = new ReviewsData("message1", "1", "time1", "name1",1);
        reviewsList.add(bubble6);

        mAdapter.notifyDataSetChanged();
    }
}
