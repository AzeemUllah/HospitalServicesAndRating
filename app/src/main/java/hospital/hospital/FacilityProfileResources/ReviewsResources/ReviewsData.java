package hospital.hospital.FacilityProfileResources.ReviewsResources;

/**
 * Created by syeda on 1/9/2018.
 */

public class ReviewsData {
    private String review, profilePic, onlineStatus, name;
    int rating;

    public ReviewsData() {
    }

    public ReviewsData(String review, String profilePic, String onlineStatus, String name, int rating) {
        this.review = review;
        this.profilePic = profilePic;
        this.onlineStatus = onlineStatus;
        this.name = name;
        this.rating = rating;
    }

    public String getreview() {
        return review;
    }

    public void setreview(String review) {
        this.review = review;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getonlineStatus() {
        return onlineStatus;
    }

    public void setonlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String onlineStatus) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
