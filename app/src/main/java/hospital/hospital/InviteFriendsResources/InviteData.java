package hospital.hospital.InviteFriendsResources;

/**
 * Created by syeda on 1/18/2018.
 */

public class InviteData {
    private String profilePic, name;
    private boolean isInvited;

    public InviteData() {
    }

    public InviteData(String profilePic, String name, boolean isInvited) {
        this.isInvited = isInvited;
        this.profilePic = profilePic;
        this.name = name;
    }


    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public boolean isInvited() {
        return isInvited;
    }

    public void setInvited(boolean invited) {
        isInvited = invited;
    }

    public String getName() {
        return name;
    }

    public void setName(String time) {
        this.name = name;
    }
}
