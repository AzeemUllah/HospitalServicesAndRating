package hospital.hospital.FacilityProfileResources.ReviewsResources;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import hospital.hospital.R;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.MyViewHolder> {

    private List<ReviewsData> reviewList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView reviewerName, reviewText;
        //public CircularImageView imgReviewer;

        public MyViewHolder(View view) {
            super(view);
            reviewerName = (TextView) view.findViewById(R.id.reviewerNameTxtb);
            reviewText = (TextView) view.findViewById(R.id.reviewTextTxtb);
            //imgReviewer = (CircularImageView) view.findViewById(R.id.imgReviewer);
        }
    }


    public ReviewsAdapter(List<ReviewsData> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_facility_profile_review_subreview, parent, false);
            return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReviewsData review = reviewList.get(position);
            holder.reviewerName.setText(review.getName());
            holder.reviewText.setText(review.getreview());
            //review.getonlineStatus();
            //holder.imgReviewer.setBackgroundResource(review.getProfilePic());
            //review.getRating();
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return 0;
    }

}
